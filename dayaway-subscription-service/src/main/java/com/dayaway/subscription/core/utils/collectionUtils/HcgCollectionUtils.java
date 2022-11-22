package com.dayaway.subscription.core.utils.collectionUtils;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class HcgCollectionUtils
{

    private final RangeIndex rangeIndex = new RangeIndex();

    @Autowired
    private Comparator comparatorInstant;


    /**
     * @param firstArray
     * @param secondArray
     * @return
     */
    public int calculateIndex(int firstArray, int secondArray, int totalSize)
    {
        return firstArray * totalSize + secondArray;
    }

    /**
     * @param collections
     * @param comparator
     * @param <T>
     * @return
     */
    public <T> List<T> sorting(List<T> collections, Comparator<T> comparator)
    {
        return collections.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }


    /**
     * @param collections
     * @param function
     * @param <T>
     * @param <R>
     * @return
     */
    public <T, R> R[] convertPropertyArray(List<T> collections, Function<T, R> function, Class<R> rClass)
    {
        return this.getPropertyList(collections, function).toArray((R[]) Array.newInstance(rClass, collections.size()));
    }

    /**
     * @param collections
     * @param function
     * @param <T>
     * @param <R>
     * @return
     */
    public <T, R> List<R> getPropertyList(List<T> collections, Function<T, R> function)
    {

        return collections.stream()
                .map(function)
                .collect(Collectors.toList());
    }

    /**
     * Merge children collection property field / instance into parent collection base on mapping field.
     *
     * @param parentCollection
     * @return
     */
    public <P, C, K> void mergeCollection(List<P> parentCollection, List<MappingField> mappingFieldList)
    {

        //Prepare data for child list
        this.prepareChildList(mappingFieldList);
        //Merge process
        for (P parent : parentCollection)
        {
            for (MappingField mappingField : mappingFieldList)
            {
                K parentKey = (K) mappingField.getParentKeyField().apply(parent);
                switch (mappingField.getFieldType())
                {
                    case SINGLE_FIELD:
                        Integer index = this.searchIndex(parentKey, mappingField.getKeyArray());
                        if (index != null)
                        {
                            //Set data for Single field
                            mappingField.getResultField().accept(parent, this.getResultKey(mappingField, mappingField.getChildrenList().get(index)));
                        }

                        break;
                    case COLLECTION_FIELD:
                        ResponseMultiIndex multiIndex = this.searchMultiIndex(parentKey, mappingField.getKeyArray());
                        //Set data for Collection field
                        mappingField.getResultField().accept(parent, this.getResultKey(mappingField, this.subList(mappingField.getChildrenList(), multiIndex)));
                        break;
                }
            }
        }
    }

    /**
     * Get Result base on Mapping field condition : single object
     *
     * @param mappingField
     * @param child
     * @param <C>
     * @param <R>
     */
    public <C, R> R getResultKey(MappingField mappingField, C child)
    {
        R result;
        if (mappingField.getChildResultField() != null)
        {
            result = (R) mappingField.getChildResultField().apply(child);
        }
        else
        {
            result = (R) child;
        }
        return result;
    }

    /**
     * Get Result base on Mapping field condition : Collection object
     * If result is Single object -> add 1 object into list
     * If result is Collection object -> add all object into list
     *
     * @param mappingField
     * @param childrenList
     * @param <C>
     * @param <R>
     */
    public <C, R> List<R> getResultKey(MappingField mappingField, List<C> childrenList)
    {
        List<R> result = new ArrayList<>();
        for (C child : childrenList)
        {
            R tempResult = this.getResultKey(mappingField, child);
            if (tempResult instanceof Collection)
            {
                result.addAll((Collection<R>) tempResult);
            }
            else
            {
                result.add(tempResult);
            }
        }
        return result;
    }

    /**
     * Sorting and prepare key array for Mapping Field if key array not been initialized
     *
     * @param mappingFieldList
     * @param <C>
     * @param <K>
     */
    public <C, K> void prepareChildList(List<MappingField> mappingFieldList)
    {
        //Prepare data
        for (MappingField mappingField : mappingFieldList)
        {
            if (mappingField.getKeyArray() == null)
            {
                List<C> childList = mappingField.getChildrenList();
                childList = this.sorting(childList, Comparator.comparing(mappingField.getChildrenKeyField()));
                K[] keyArray = (K[]) this.convertPropertyArray(childList, mappingField.getChildrenKeyField(), mappingField.getKeyCLass());
                mappingField.setKeyArray(keyArray);
                mappingField.setChildrenList(childList);
            }
        }
    }

    /**
     * Function sublist , check condition from != null
     * Not check collection is null
     * Not check from , to range is not available with collection
     *
     * @param collections
     * @param responseMultiIndex
     * @param <T>
     * @return
     */
    public <T> List<T> subList(List<T> collections, ResponseMultiIndex responseMultiIndex)
    {

        List<T> result;
        if (responseMultiIndex.getFromIndex() != null)
        {
            result = collections.subList(responseMultiIndex.getFromIndex(), responseMultiIndex.getToIndex() + 1);
        }
        else
        {
            result = new ArrayList<>();
        }
        return result;
    }

    /**
     * binary search O(n) = log(n)
     *
     * @param searchValue
     * @param indexArray
     * @return
     */
    public <T> Integer searchIndex(T searchValue, T[] indexArray)
    {

        int from = 0;
        int to = indexArray != null ? indexArray.length - 1 : 0;
        return this.searchIndex(searchValue, indexArray, from, to);
    }


    /**
     * binary search O(n) = log(n)
     *
     * @param searchValue
     * @param indexArray
     * @return
     */
    public <T> Integer searchIndex(T searchValue, T[] indexArray, Integer from, Integer to)
    {
        return this.searchIndex(searchValue, indexArray, new RangeIndex(from, to));
    }

    /**
     * binary search O(n) = log(n)
     *
     * @param searchValue
     * @param indexArray
     * @return
     */
    private <T> Integer searchIndex(T searchValue, T[] indexArray, RangeIndex rangeIndex)
    {

        Integer result = null;

        if (searchValue != null && indexArray != null && rangeIndex.from != null && rangeIndex.to != null)
        {
            T findValue = searchValue;
            this.setDefault(rangeIndex, indexArray.length);
            int from = rangeIndex.from;
            int to = rangeIndex.to;

            int middle;

            while (from <= to)
            {
                middle = (from + to) / 2;
                int compareValue = comparatorInstant.compare(indexArray[middle], findValue);

                if (compareValue < 0)
                {
                    from = middle + 1;
                }
                else
                {
                    if (compareValue > 0)
                    {
                        to = middle - 1;
                    }
                    else
                    {
                        result = middle;
                        break;
                    }
                }
            }
        }

        return result;
    }

    /**
     * @param searchValue
     * @param indexArray
     * @param <T>
     * @return
     */
    public <T> ResponseMultiIndex searchMultiIndex(T searchValue, T[] indexArray)
    {
        int from = 0;
        int to = indexArray != null ? indexArray.length : 0;
        return this.searchMultiIndex(searchValue, indexArray, from, to);
    }

    /**
     * @param searchValue
     * @param indexArray
     * @param <T>
     * @return
     */
    public <T> ResponseMultiIndex searchMultiIndex(T searchValue, T[] indexArray, Integer from, Integer to)
    {
        return this.searchMultiIndex(searchValue, indexArray, new RangeIndex(from, to));
    }

    /**
     * @param searchValue
     * @param indexArray
     * @param <T>
     * @return
     */
    private <T> ResponseMultiIndex searchMultiIndex(T searchValue, T[] indexArray, RangeIndex rangeIndex)
    {
        //Binary search
        Integer firstIndex = this.searchIndex(searchValue, indexArray, rangeIndex);
        //Spread Array
        return this.spreadIndex(firstIndex, searchValue, indexArray, rangeIndex);
    }

    /**
     * @param fromValue
     * @param toValue
     * @param indexArray
     * @param <T>
     * @return
     */
    public <T> ResponseMultiIndex searchRangeIndex(T fromValue, T toValue, T[] indexArray)
    {

        int from = 0;
        int to = indexArray != null ? indexArray.length : 0;
        return this.searchRangeIndex(fromValue, toValue, indexArray, from, to);
    }


    /**
     * @param fromValue
     * @param toValue
     * @param indexArray
     * @param <T>
     * @return
     */
    public <T> ResponseMultiIndex searchRangeIndex(T fromValue, T toValue, T[] indexArray, Integer from, Integer to)
    {

        return this.searchRangeIndex(fromValue, toValue, indexArray, new RangeIndex(from, to));
    }

    /**
     * @param fromValue
     * @param toValue
     * @param indexArray
     * @param <T>
     * @return
     */
    public <T> ResponseMultiIndex searchRangeIndex(T fromValue, T toValue, T[] indexArray, RangeIndex rangeIndex)
    {

        Integer index = this.searchRange(fromValue, toValue, indexArray, rangeIndex);
        return this.spreadRangeIndex(index, fromValue, toValue, indexArray, rangeIndex);
    }

    /**
     * @param fromValue
     * @param toValue
     * @param indexArray
     * @param <T>
     * @return
     */
    private <T> Integer searchRange(T fromValue, T toValue, T[] indexArray, RangeIndex rangeIndex)
    {

        Integer result = null;

        if (fromValue != null && toValue != null && indexArray != null && rangeIndex.from != null && rangeIndex.to != null)
        {

            this.setDefault(rangeIndex, indexArray.length);

            int from = rangeIndex.from;
            int to = rangeIndex.to;
            int middle;

            while (from <= to)
            {
                middle = (from + to) / 2;
                if (comparatorInstant.compare(indexArray[middle], fromValue) < 0)
                {
                    from = middle + 1;
                }
                else
                {
                    if (comparatorInstant.compare(indexArray[middle], toValue) > 0)
                    {
                        to = middle - 1;
                    }
                    else
                    {
                        result = middle;
                        break;
                    }
                }
            }
        }
        return result;
    }

    /**
     * index = 2 | 3
     * 0  1  2  3  4  5  6
     * 5  7  3  3  5  6  9
     * <- <-  index -> ->
     * Response :
     * from = 2
     * to = 3
     *
     * @param firstIndex
     * @param searchValue
     * @param indexArray
     * @return
     */
    private <T> ResponseMultiIndex spreadIndex(Integer firstIndex, T searchValue, T[] indexArray, RangeIndex rangeIndex)
    {
        Integer fromIndex = firstIndex;
        Integer toIndex = firstIndex;

        if (firstIndex != null && rangeIndex.from != null && rangeIndex.to != null)
        {
            this.setDefault(rangeIndex, indexArray.length);

            int rangeMin = rangeIndex.from;
            int rangeMax = rangeIndex.to + 1;

            while (fromIndex >= rangeMin && comparatorInstant.compare(indexArray[fromIndex], searchValue) == 0)
            {
                fromIndex--;
            }
            fromIndex++;

            while (toIndex < rangeMax && comparatorInstant.compare(indexArray[toIndex], searchValue) == 0)
            {
                toIndex++;
            }
            toIndex--;
        }


        return new ResponseMultiIndex(fromIndex, toIndex);
    }

    /**
     * fromValue = 4 , toValue = 7
     * index = 2 | 3 | 4
     * <p>
     * 0  1  2  3  4  5  6
     * 3  3  4  5  7  10 11
     * <- <-  index -> ->
     * Response :
     * from = 2
     * to = 4
     *
     * @param firstIndex
     * @param fromValue
     * @param toValue
     * @param indexArray
     * @return
     */
    private <T> ResponseMultiIndex spreadRangeIndex(Integer firstIndex, T fromValue, T toValue, T[] indexArray,
                                                    RangeIndex rangeIndex)
    {
        Integer fromIndex = firstIndex;
        Integer toIndex = firstIndex;

        if (firstIndex != null && rangeIndex.from != null && rangeIndex.to != null)
        {

            this.setDefault(rangeIndex, indexArray.length);
            int rangeMin = rangeIndex.from;
            int rangeMax = rangeIndex.to + 1;

            while (fromIndex >= rangeMin && comparatorInstant.compare(indexArray[fromIndex], fromValue) > -1)
            {
                fromIndex--;
            }
            fromIndex++;

            while (toIndex < rangeMax && comparatorInstant.compare(indexArray[toIndex], toValue) < 1)
            {
                toIndex++;
            }
            toIndex--;
        }


        return new ResponseMultiIndex(fromIndex, toIndex);
    }

    /**
     *
     */
    private class RangeIndex
    {
        public Integer from;
        public Integer to;

        public RangeIndex()
        {
            super();
        }

        protected RangeIndex(Integer from, Integer to)
        {
            super();
            this.from = from;
            this.to = to;
        }
    }

    /**
     * @param rangeIndex
     */
    private void setDefault(RangeIndex rangeIndex, int arrayLength)
    {
        if (rangeIndex.from > rangeIndex.to)
        {
            int temp = rangeIndex.from;
            rangeIndex.from = rangeIndex.to;
            rangeIndex.to = temp;
        }
        rangeIndex.from = rangeIndex.from < 0 ? 0 : rangeIndex.from;
        rangeIndex.to = rangeIndex.to > arrayLength - 1 ? (arrayLength - 1) : rangeIndex.to;
    }
}

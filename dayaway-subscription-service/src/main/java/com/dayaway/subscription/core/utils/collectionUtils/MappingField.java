package com.dayaway.subscription.core.utils.collectionUtils;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * @param <P> parent class
 * @param <C> children class
 * @param <R> result class
 * @param <K> key class
 */
@Getter
@Setter
public class MappingField<P, C, R, K>
{

    public enum FieldTypeEnum
    {
        SINGLE_FIELD, COLLECTION_FIELD
    }

    private List<C> childrenList;

    /**
     * function get key field from parent
     */
    private Function<P, K> parentKeyField;

    /**
     * function get key field from children
     */
    private Function<C, K> childrenKeyField;

    /**
     * function set result field into parent
     */
    private BiConsumer<P, R> resultField;

    /**
     * function get children result field
     */
    private Function<C, R> childResultField;

    /**
     * Class of key
     */
    private Class<K> keyCLass;

    /**
     * Key array from children list( set if want to reuse key array )
     */
    private K[] keyArray;

    private FieldTypeEnum fieldType;

    public MappingField(List<C> childrenList, Function<P, K> parentKeyField, Function<C, K> childrenKeyField,
                        BiConsumer<P, R> resultField, Class<K> keyClass, FieldTypeEnum fieldType)
    {

        this.childrenList = childrenList;
        this.parentKeyField = parentKeyField;
        this.childrenKeyField = childrenKeyField;
        this.resultField = resultField;
        this.keyCLass = keyClass;
        this.fieldType = fieldType;
    }


    public MappingField(List<C> childrenList, Function<P, K> parentKeyField, Function<C, K> childrenKeyField,
                        BiConsumer<P, R> resultField, Function<C, R> childrenResultField, Class<K> keyClass,
                        FieldTypeEnum fieldType)
    {

        this.childrenList = childrenList;
        this.parentKeyField = parentKeyField;
        this.childrenKeyField = childrenKeyField;
        this.childResultField = childrenResultField;
        this.resultField = resultField;
        this.keyCLass = keyClass;
        this.fieldType = fieldType;
    }

    public MappingField(List<C> childrenList, Function<P, K> parentKeyField, BiConsumer<P, R> resultField, K[] keyArray,
                        FieldTypeEnum fieldType)
    {
        this.childrenList = childrenList;
        this.parentKeyField = parentKeyField;
        this.resultField = resultField;
        this.keyArray = keyArray;
        this.fieldType = fieldType;
    }
}

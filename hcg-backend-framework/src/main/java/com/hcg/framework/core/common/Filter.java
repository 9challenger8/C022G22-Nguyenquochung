package com.hcg.framework.core.common;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.hcg.framework.core.graphql.ResponseData;
import io.ebean.PagedList;
import io.ebean.typequery.TQRootBean;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Filter implements Serializable {
    private static final long serialVersionUID = -4078129172545961372L;

    private Set<String> expand;

    private Integer pageSize;

    private Integer pageIndex;

    private Set<String> sort;

    public Filter(Set<String> expand) {
        this.expand = expand;
    }

    public static <T extends Filter> T setDefaultValue(T filter, Class<T> tClass) {
        T result = filter;
        if (filter == null) {

            try {
                result = tClass.getDeclaredConstructor().newInstance();
            } catch (Exception e) {
//                throw new RuntimeException(e);
            }

        }

        result.setExpand(result.getExpand() == null ? new HashSet<>() : result.getExpand());
        result.setSort(result.getSort() == null ? new HashSet<>() : result.getSort());

//        if(result.getPageIndex() != null || result.getPageSize() != null){
//            result.setPageIndex(result.getPageIndex() == null ? -1 : result.getPageIndex());
//            result.setPageSize(result.getPageSize() == null ? 10 : result.getPageSize());
//        }



        return result;
    }

    /**
     * @param query
     * @param filter
     * @param <T>
     * @param <R>
     * @param <K>
     */
    public static <T extends Filter, R extends AbstractAuditedEntity, K extends TQRootBean> void setPagingFilter(TQRootBean<R, K> query, T filter) {

        int offset = filter.getPageIndex() * filter.getPageSize();

        Set<String> sortConver = new HashSet<>();
        for (String sort : filter.getSort()) {
            sortConver.add(Filter.convertSorting(sort));
        }

        if (sortConver.size() > 0) {
            query.order(String.join(" , ", sortConver));
        }

        // Set query
        query
                .setFirstRow(offset)
                .setMaxRows(filter.getPageSize());
    }

    public static <T extends Filter, R extends AbstractAuditedEntity, K extends TQRootBean> ResponseData<R> getData(TQRootBean<R, K> query, T filter) {
        ResponseData<R> responseData = new ResponseData<>();
        if (filter.getPageSize() != null && filter.getPageIndex() != null) {
            setPagingFilter(query, filter);
            PagedList<R> pagedList = query.findPagedList();
            responseData.setCount(pagedList.getTotalCount());
            responseData.setTotalPage(pagedList.getTotalPageCount());
            responseData.setData(pagedList.getList());
        } else {
            List<R> list = query.findList();
            responseData.setCount(list.size());
            responseData.setTotalPage(1);
            responseData.setData(list);
        }
        return responseData;
    }

    /**
     * @param sortParam
     * @return
     */
    public static String convertSorting(String sortParam) {
        String result = null;

        String[] array = sortParam.split(":");

        // Assign sorting
        if (array.length == 2) {
            result = array[0] + " " + array[1];
        } else {
            result = array[0];
        }

        return result;
    }

}
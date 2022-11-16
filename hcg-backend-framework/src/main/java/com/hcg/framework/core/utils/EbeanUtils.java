package com.hcg.framework.core.utils;


import com.hcg.framework.core.common.AbstractAuditedEntity;
import com.hcg.framework.core.common.AbstractAuditedMapper;
import com.hcg.framework.core.common.Filter;
import com.hcg.framework.core.graphql.ResponseData;
import io.ebean.PagedList;
import io.ebean.typequery.PBaseValueEqual;
import io.ebean.typequery.PString;
import io.ebean.typequery.TQRootBean;
import org.apache.logging.log4j.util.Strings;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

public class EbeanUtils {
    public static <T extends AbstractAuditedEntity> void removeId(List<T> entityList) {
        if (entityList != null) {
            for (T entity : entityList) {
                EbeanUtils.removeId(entity);
            }
        }
    }

    public static <T extends AbstractAuditedEntity> void removeId(T entity) {
        if (entity != null) {
            entity.setId(null);
        }
    }

    public static <R, T> void setEqualOrInQuery(PBaseValueEqual<R, T> query, Collection<T> set) {
        if (set != null && set.size() > 0) {
            set = set.stream().filter(Objects::nonNull).collect(Collectors.toList());
            if (set.size() == 1) {
                query.equalTo(set.iterator().next());
            } else {
                query.in(set);
            }
        }
    }

    public static <R, T> void setNotEqualOrNotInQuery(PBaseValueEqual<R, T> query, Collection<T> set) {
        if (set != null && set.size() > 0) {
            if (set.size() == 1) {
                query.ne(set.iterator().next());
            } else {
                query.notIn(set);
            }

        }
    }

    public static <R> void setLikeQuery(PString<R> query, String text, boolean isCaseSensitive) {
        if (!Strings.isEmpty(text)) {
            String likeText = "%" + text.replaceAll("( )", "%$1%") + "%";

            if (isCaseSensitive) {
                query.like(likeText);
            } else {
                query.ilike(likeText);
            }
        }
    }

    public static <R> void setLikeQueryList(TQRootBean qEntity, List<PString<R>> queries, String text, boolean isCaseSensitive) {
        if (!Strings.isEmpty(text)) {
            String likeText = "%" + text.replaceAll("( )", "%$1%") + "%";

            qEntity.or();
            for (PString<R> query : queries) {
                if (isCaseSensitive) {
                    query.like(likeText);
                } else {
                    query.ilike(likeText);
                }
            }
            qEntity.endOr();
        }
    }



    public static <T extends Filter, R extends AbstractAuditedEntity, K extends TQRootBean> ResponseData<R> queryEntity(TQRootBean<R, K> query, T filter) {
        ResponseData<R> responseData = new ResponseData<>();

        if(filter.getSort() != null){


            Set<String> sortConver = new HashSet<>();
            for (String sort : filter.getSort()) {
                sortConver.add(sort.replace(":", " "));
            }

            if (sortConver.size() > 0) {
                query.order(String.join(" , ", sortConver));
            }

        }

        if (filter.getPageSize() != null && filter.getPageIndex() != null) {

            int offset = filter.getPageIndex() * filter.getPageSize();
            query
                    .setFirstRow(offset)
                    .setMaxRows(filter.getPageSize());

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

}

package com.hcg.framework.core.graphql;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ResponseData<T> implements Serializable {
    private Integer count;

    private Integer totalPage;

    private List<T> data;

    public ResponseData(ResponseData res, List<T> data) {
        this.count = res.count;
        this.totalPage = res.totalPage;
        this.data = data;
    }

    public ResponseData(Integer count, Integer totalPage, List<T> data) {
        this.count = count;
        this.totalPage = totalPage;
        this.data = data;
    }
}

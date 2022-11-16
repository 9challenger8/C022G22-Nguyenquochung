package com.hcg.framework.core.graphql;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.hcg.framework.core.validation.ValidationMessage;
import lombok.Data;

import java.io.Serializable;
import java.util.Collection;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseContent<T> implements Serializable {
    private static final long serialVersionUID = 1952592584032847050L;

    private String message;
    private String code;
    private ResponseContentStatusEnum status; // success / error / warning
    private T data; // return data if success
    private Collection<T> dataList; // return data if success

    public ResponseContent() {
        super();
    }

    public ResponseContent(String code, String message) {
        super();
        this.code = code;
        this.message = message;
    }

    public ResponseContent(ResponseContentStatusEnum status, T data) {
        super();
        this.status = status;
        this.data = data;
    }

    public ResponseContent(ValidationMessage messageResponse, ResponseContentStatusEnum status) {
        super();
        this.code = messageResponse.getCode();
        this.message = messageResponse.getMessage();
        this.status = status;
    }

    public ResponseContent(ValidationMessage messageResponse, ResponseContentStatusEnum status, T data) {
        super();
        this.code = messageResponse.getCode();
        this.message = messageResponse.getMessage();
        this.status = status;
        this.data = data;
    }


    public ResponseContent(ValidationMessage messageResponse, ResponseContentStatusEnum status, Collection<T> dataList) {
        super();
        this.code = messageResponse.getCode();
        this.message = messageResponse.getMessage();
        this.status = status;
        this.dataList = dataList;
    }


    public ResponseContent(String code, String message, ResponseContentStatusEnum status, T data) {
        super();
        this.code = code;
        this.message = message;
        this.status = status;
        this.data = data;
    }

}
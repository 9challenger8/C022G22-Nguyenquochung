package com.hcg.framework.core.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseController {
    @Autowired
    protected  ObjectMapper objectMapper ;

    protected <T extends Filter> T mapEnv2Filter(DataFetchingEnvironment env, Class<T> tClass){
        T result = objectMapper.convertValue(env.getArgument("filter"), tClass);

        return result;

    }

    protected <T extends Input> T mapEnv2Input(DataFetchingEnvironment env, Class<T> tClass){
        T result = objectMapper.convertValue(env.getArgument("input"), tClass);

        return result;

    }

}

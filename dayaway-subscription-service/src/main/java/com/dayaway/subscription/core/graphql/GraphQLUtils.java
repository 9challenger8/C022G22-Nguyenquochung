package com.dayaway.subscription.core.graphql;

import com.dayaway.subscription.core.httpClientRemote.RequestContent;
import com.dayaway.subscription.core.httpClientRemote.ResponseContent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class GraphQLUtils {

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * @param responseString
     * @param tTypeReference
     * @param <T>
     * @return
     * @throws JsonProcessingException
     */
    public <T> T readValues(String responseString, String queryName, TypeReference<T> tTypeReference) throws JsonProcessingException {

        T result = null;
        ResponseContent responseContent = objectMapper.readValue(responseString, new TypeReference<ResponseContent>() {
        });
        if (responseContent.getErrors() == null || responseContent.getErrors().size() > 0) {
            if (responseContent.getData().get(queryName) != null)
                result = objectMapper.readValue(responseContent.getData().get(queryName).toString()
                        , tTypeReference);
            else
                result = objectMapper.readValue(responseContent.getData().get("response").toString()
                        , tTypeReference);
        }
        return result;
    }

    /**
     * @param query
     * @return
     */
    public RequestContent generateRequestContent(String query, Map<String, String> queryGraphMap) {
        return this.generateRequestContent(query, queryGraphMap, null);
    }

    /**
     * @param query
     * @param variables
     * @param <T>
     * @return
     */
    public <T> RequestContent generateRequestContent(String query, Map<String, String> queryGraphMap, Map<String, Object> variables) {
        String queryGraph = queryGraphMap.get(query);

        RequestContent requestContent = new RequestContent();
        requestContent.setOperationName(query);
        requestContent.setQuery(queryGraph);
        requestContent.setVariables(variables);

        return requestContent;
    }
}

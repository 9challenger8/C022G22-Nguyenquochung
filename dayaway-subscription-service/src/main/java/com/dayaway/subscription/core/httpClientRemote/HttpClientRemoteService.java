package com.dayaway.subscription.core.httpClientRemote;

import com.dayaway.subscription.core.graphql.GraphQLUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
@Log4j2
public class HttpClientRemoteService {
    private final ObjectMapper objectMapper;

    private final GraphQLUtils graphQLUtils;

    private final Map<ClientRemoteEnum, String> clientRemoteUrlMap;

    private final RestTemplate restTemplate;

    public HttpClientRemoteService(ObjectMapper objectMapper, GraphQLUtils graphQLUtils, Map<ClientRemoteEnum, String> clientRemoteUrlMap, RestTemplate restTemplate) {
        this.objectMapper = objectMapper;
        this.graphQLUtils = graphQLUtils;
        this.clientRemoteUrlMap = clientRemoteUrlMap;
        this.restTemplate = restTemplate;
    }

    public <T> List<T> entityList(String query, TypeReference<List<T>> typeReference, ClientRemoteEnum clientRemoteEnum, Map<String, String> queryGraphMap) throws IOException, URISyntaxException {
        RequestContent requestContent = graphQLUtils.generateRequestContent(query, queryGraphMap);
        return this.entityList(query, typeReference, requestContent, clientRemoteEnum);
    }

    public <T> List<T> entityList(String query, TypeReference<List<T>> typeReference, ClientRemoteEnum clientRemoteEnum, Map<String, String> queryGraphMap, Map<String, Object> variables) throws IOException, URISyntaxException {
        RequestContent requestContent = graphQLUtils.generateRequestContent(query, queryGraphMap, variables);
        return this.entityList(query, typeReference, requestContent, clientRemoteEnum);
    }

    public <T> List<T> entityList(String query, TypeReference<List<T>> typeReference, RequestContent requestContent, ClientRemoteEnum clientRemoteEnum) throws IOException, URISyntaxException {
        //Execute post request
        String responseString = this.executePostRequest(clientRemoteUrlMap.get(clientRemoteEnum), requestContent);
        List<T> result = graphQLUtils.readValues(responseString, query, typeReference);
        result = result == null ? new ArrayList<>() : result;
        log.info("Response: " + responseString);
        return result;
    }

    public <T> T entity(String query, TypeReference<T> typeReference, ClientRemoteEnum clientRemoteEnum, Map<String, String> queryGraphMap) throws IOException, URISyntaxException {
        RequestContent requestContent = graphQLUtils.generateRequestContent(query, queryGraphMap);
        return this.entity(query, typeReference, requestContent, clientRemoteEnum);
    }

    public <T> T entity(String query, TypeReference<T> typeReference, ClientRemoteEnum clientRemoteEnum, Map<String, String> queryGraphMap, Map<String, Object> variables) {
        RequestContent requestContent = graphQLUtils.generateRequestContent(query, queryGraphMap, variables);
        return this.entity(query, typeReference, requestContent, clientRemoteEnum);
    }

    public <T> T entity(String query, TypeReference<T> typeReference, RequestContent requestContent, ClientRemoteEnum clientRemoteEnum) {
        try {
            //Execute post request
            long start = System.currentTimeMillis();
            String responseString = this.executePostRequest(clientRemoteUrlMap.get(clientRemoteEnum), requestContent);
            log.info(String.format("Query [%s] took %s ms with payload: %s | Response: %s",
                    query, System.currentTimeMillis() - start, objectMapper.writeValueAsString(requestContent.getVariables()), responseString));
            T result = graphQLUtils.readValues(responseString, query, typeReference);
            return result;
        } catch (IOException | URISyntaxException exception) {
            log.error("Execute post request error: query={}, exception={}", query, exception.toString());

            //TODO handler here
            return null;
        }
    }

    public <T> String executePostRequest(String url, T bodyEntity) throws URISyntaxException, JsonProcessingException {
        //Create http response
        return this.postEntity(url, bodyEntity);
    }

    public <T> String postEntity(String url, T body) throws URISyntaxException, JsonProcessingException {
        log.info("URL: " + url);
        return this.postEntity(this.generateHeader(), new URI(url), body);
    }

    private <T> String postEntity(HttpHeaders headers, URI url, T body) throws JsonProcessingException {
        return this.callMethod(this.generateHttpEntity(headers, body), url);
    }

    private String callMethod(HttpEntity<String> httpEntity, URI url) {
        //Return result
        String result = null;
        try {
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, httpEntity, String.class);

            result = response.getBody();
        } catch (Exception clientError) {
            clientError.printStackTrace();
        }
        return result;
    }

    public HttpEntity generateHttpEntity(HttpHeaders headers) {
        return new HttpEntity<>(headers);
    }

    public <T> HttpEntity generateHttpEntity(HttpHeaders headers, T body) throws JsonProcessingException {
        return new HttpEntity<>(objectMapper.writeValueAsString(body), headers);
    }

    public HttpHeaders generateHeader() {
        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);

        return headers;
    }

    public <T> T convertValue(JsonNode jsonResponse, String keyName, TypeReference<T> typeReference) throws JsonProcessingException {
        T data = null;
        if (typeReference != null) {
            if (keyName != null) {
                data = this.convertValue(jsonResponse.get(keyName), typeReference);
            } else {
                data = this.convertValue(jsonResponse, typeReference);
            }
        }
        return data;
    }

    public <T> T convertValue(JsonNode jsonResponse, TypeReference<T> typeReference) throws JsonProcessingException {
        return objectMapper.readValue(jsonResponse.toString(), typeReference);
    }
}

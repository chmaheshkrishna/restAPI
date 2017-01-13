package com.rest.service;

import org.json.JSONException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class RestService {

    public String doServiceCall(String url, String body, String contentType) {
        StringBuilder message = new StringBuilder();
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpEntity<String> entity = new HttpEntity<>(body, buildHttpHeaders());
            ResponseEntity<Object> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, entity, Object.class);
            message.append("statusCode:").append(responseEntity.getStatusCode()).append(",").append("body:")
                .append(responseEntity.getBody()).append("success:true");
        } catch (JSONException | RestClientException e) {
            if (e instanceof HttpClientErrorException) {
                message.append("statusCode:").append(((HttpClientErrorException) e).getStatusCode())
                    .append("body:").append(((HttpClientErrorException) e).getResponseBodyAsString()).append("success:false");
            }
        }
        return message.toString();
    }

    private MultiValueMap<String, String> buildHttpHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.set("Authorization", String.format("Bearer %s", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJhbGlnbi5zbWlsZWRpcmVjdGNsdWIuY29tIiwic3ViIjoxLCJpYXQiOjE0ODQwOTgzMzQsImV4cCI6MTQ4NDcwMzEzNH0.KmY9qCNgf_Qr769WdHlz1HttWCX6sdU3VVC26gMSBqA"));
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.putAll(httpHeaders);
        return headers;
    }

}

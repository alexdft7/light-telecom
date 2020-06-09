package com.alexdft.lighttelecomsubscriber.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class SubscriberService {

    private RestTemplate restTemplate;

    @Autowired
    public SubscriberService(RestTemplate restTemplate) {
        this.restTemplate=restTemplate;
    }

    public String retrieveMessage() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        String request = restTemplate.getForObject("http://localhost:8080/lighttelecompublisher/sendMessage", String.class, requestEntity);
        return request;
    }
}

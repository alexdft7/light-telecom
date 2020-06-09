package com.alexdft.lighttelecompublisher.service;

import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Random;
import java.util.logging.Logger;

@Service
public class PublisherService {

    private static Logger log = Logger.getLogger(PublisherService.class.getName());

    public static final String[] actionList = {
            "PURCHASE",
            "SUBSCRIPTION"
    };

    public String createPublisherMessage() {
        log.info("Creating Publisher Message...");

        Random rnd = new Random();
        int msisdn = 100000000 + rnd.nextInt(900000000);
        String action = actionList[rnd.nextInt(actionList.length)];
        long unixTimestamp = System.currentTimeMillis() / 1000L;

        JSONObject jo = new JSONObject();
        jo.put("msisdn", msisdn);
        jo.put("action", action);
        jo.put("timestamp", unixTimestamp);

        log.info("Publisher's Message is created!");

        return jo.toString();
    }

    public ResponseEntity<String> sendPublisherMessage() throws URISyntaxException {
        log.info("Uploading Publisher Message...");

        RestTemplate restTemplate = new RestTemplate();
        String url = "https://jsonplaceholder.typicode.com/posts";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(createPublisherMessage(), headers);
        ResponseEntity<String> response = restTemplate.exchange(new URI(url), HttpMethod.POST, entity, String.class);

        log.info("Publisher's Message is uploaded!");

        return response;
    }
}
package com.alexdft.lighttelecompublisher.controller;

import com.alexdft.lighttelecompublisher.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;

@RestController
public class DemoController {

    private PublisherService publisherService;

    @Autowired
    public DemoController(PublisherService publisherService) {
        this.publisherService=publisherService;
    }

    @GetMapping(value = "/readMessage")
    public String showPublisherMessage() {
        return publisherService.createPublisherMessage();
    }

    @PostMapping(value = "/sendMessage")
    public ResponseEntity<String> sendPublisherMessage() throws URISyntaxException {
        return publisherService.sendPublisherMessage();
    }
}
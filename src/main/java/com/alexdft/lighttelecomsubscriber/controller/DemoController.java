package com.alexdft.lighttelecomsubscriber.controller;

import com.alexdft.lighttelecomsubscriber.service.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class DemoController {

    private SubscriberService subscriberService;

    @Autowired
    public DemoController(SubscriberService subscriberService) {
        this.subscriberService=subscriberService;
    }

    @GetMapping(value = "/retrieveMessage", produces = MediaType.APPLICATION_JSON_VALUE)
    public String receiveMessage() {
        return subscriberService.retrieveMessage();
    }
}

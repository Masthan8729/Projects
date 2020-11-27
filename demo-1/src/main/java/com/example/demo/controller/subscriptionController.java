package com.example.demo.controller;

import com.example.demo.vo.Subscription;

import com.example.demo.service.subscriptionService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class subscriptionController {
    final static Logger log = LogManager.getLogger(subscriptionController.class);
    @Autowired
    private subscriptionService service;


    @PostMapping("/addSubscription")
    @CrossOrigin("https://web.postman.co/build/")
    public void addSubscription(@RequestBody Subscription subscription) throws Exception {
        String subscriptionName=subscription.getSubscriptionName();
        boolean value=service.isSubscriptionAlreadyExist(subscriptionName) ;
        if(value==true){
            log.info("Saving Recommended Subscription Item");
            service.saveSubscription(subscription);
        }
        else{
            log.error("Subscription already exist");
            throw new Exception(subscriptionName+" is already exist in the recommendations");
        }

    }

    @GetMapping("/getAllSubscriptions")
    @CrossOrigin("http://localhost:4200/homepage")
    public List<Subscription> getAllSubscriptions() {
        log.info("Getting all recommended subscriptions");
        List<Subscription> subscriptionList = service.getSubscriptions();
        return subscriptionList;
    }
    @GetMapping("/getSubscriptionById/{subscriptionId}")
    @CrossOrigin("http://localhost:4200/homepage")
    public Subscription getSubscriptionById(@PathVariable int subscriptionId){
        log.info("Getting recommended subscription by subscription Id");
        return service.subscriptionById(subscriptionId);
    }
}

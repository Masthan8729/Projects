package com.example.demo.vo;

import javax.persistence.*;

@Entity
    @Table(name = "subscription_details_tbl")

public class Subscription {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int subscriptionId;
    private String subscriptionName;
    private String subscriptionType;

    public Subscription(int subscriptionId, String subscriptionName, String subscriptionType) {
        this.subscriptionId = subscriptionId;
        this.subscriptionName = subscriptionName;
        this.subscriptionType = subscriptionType;
    }

    public Subscription(){

    }
    public int getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(int subscriptionId) {
        this.subscriptionId = subscriptionId;
    }



    public String getSubscriptionName() {
        return subscriptionName;
    }

    public void setSubscriptionName(String subscriptionName) {
        this.subscriptionName = subscriptionName;
    }

    public String getSubscriptionType() {
        return subscriptionType;
    }

    public void setSubscriptionType(String subscriptionType) {
        this.subscriptionType = subscriptionType;
    }





}

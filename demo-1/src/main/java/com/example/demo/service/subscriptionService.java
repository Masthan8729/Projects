package com.example.demo.service;

import com.example.demo.Dao.subscriptionDao;
import com.example.demo.vo.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class subscriptionService {
    @Autowired
    private subscriptionDao subscriptionDao;

    public void saveSubscription(Subscription subscription){
        subscriptionDao.addSubscription(subscription);
    }

    public List<Subscription> getSubscriptions(){
        return subscriptionDao.findAllSubscriptions();
    }

    public  Subscription subscriptionById(int subscriptionId){
        return subscriptionDao.getSubscriptionById(subscriptionId);
    }
    public boolean isSubscriptionAlreadyExist(String subscriptionName){
        return subscriptionDao.isSubscriptionAlreadyExist(subscriptionName);

    }
}

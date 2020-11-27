package com.example.demo.service;

import com.example.demo.Dao.subscribedItemsDao;
import com.example.demo.vo.subscribedItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class subscribedItemsService {

    @Autowired
    private subscribedItemsDao subscribedItemsDao;

    public subscribedItems getsubscribedItemByName(String subscribedItemName){
        return subscribedItemsDao.getSubscribedItemByName(subscribedItemName);
    }

    public void saveSubscribedItems(subscribedItems subscribedItems){
        subscribedItemsDao.addSubcribedItems(subscribedItems);
    }

    public List<subscribedItems> getSubscribedItems(int userId){
        return subscribedItemsDao.findAllSubscribedItems(userId);
    }

    public void deleteSubscribedItemByName(String subscribedItemName){
        subscribedItemsDao.deleteSubscribedItemByName(subscribedItemName);
    }
    public List<subscribedItems> getSubscibedItemByPlan(String subscribedItemPlan){
        return subscribedItemsDao.getSubscribedItemByPlan(subscribedItemPlan);
    }
    public boolean findSubscribedItemExistsOnUserId(int userId,String subscribedItemName){
        return subscribedItemsDao.findSubscribedItemExistsOnUserId(userId,subscribedItemName);
    }
}

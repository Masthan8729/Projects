package com.example.demo.vo;

import javax.persistence.*;

@Entity
@Table(name = "subscribedItems_tbl")
public class subscribedItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int subscribedItemId;
    private String subscribedItemName;
    private String subscribedItemType;
    private String subscribedItemPlan;
    private int userId;


    public subscribedItems() {
    }

    public subscribedItems(int subscribedItemId, String subscribedItemName, String subscribedItemType, String subscribedItemPlan,int userId) {
        this.subscribedItemId = subscribedItemId;
        this.subscribedItemName = subscribedItemName;
        this.subscribedItemType = subscribedItemType;
        this.subscribedItemPlan = subscribedItemPlan;
        this.userId=userId;
    }

    public int getSubscribedItemId() {
        return subscribedItemId;
    }

    public void setSubscribedItemId(int subscribedItemId) {
        this.subscribedItemId = subscribedItemId;
    }

    public String getSubscribedItemName() {
        return subscribedItemName;
    }

    public void setSubscribedItemName(String subscribedItemName) {
        this.subscribedItemName = subscribedItemName;
    }

    public String getSubscribedItemType() {
        return subscribedItemType;
    }

    public void setSubscribedItemType(String subscribedItemType) {
        this.subscribedItemType = subscribedItemType;
    }

    public String getSubscribedItemPlan() {
        return subscribedItemPlan;
    }

    public void setSubscribedItemPlan(String subscribedItemPlan) {
        this.subscribedItemPlan = subscribedItemPlan;
    }
    /*public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }*/

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}

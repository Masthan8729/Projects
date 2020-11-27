package com.example.demo.vo;

import javax.persistence.*;

@Entity
@Table(name = "subscription_transactionDetails_tbl")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionId;
    private String transactionItem;
    private String plan;
    private int transactionAmount;
    private String transactionDate;
    private String planEndDate;
    private int userId;



    public Transaction() {
    }

    public Transaction(int transactionId,String transactionItem, int transactionAmount,String plan, String transactionDate,String planEndDate, int userId) {
        this.transactionId = transactionId;
        this.transactionItem=transactionItem;
        this.transactionAmount = transactionAmount;
        this.plan=plan;
        this.transactionDate = transactionDate;
        this.planEndDate=planEndDate;
        this.userId=userId;

    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }
    public String getTransactionItem() {
        return transactionItem;
    }

    public void setTransactionItem(String transactionItem) {
        this.transactionItem = transactionItem;
    }

    public int getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(int transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }
    public String getPlanEndDate() {
        return planEndDate;
    }

    public void setPlanEndDate(String planEndDate) {
        this.planEndDate = planEndDate;
    }

    public int getUserId() {
        return userId;
    }



    public void setUserId(int userId) {
        this.userId = userId;
    }
    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", transactionAmount=" + transactionAmount +
                ", transactionDate='" + transactionDate + '\'' +
                ", transactionItem='" + transactionItem + '\'' +
                ", planEndDate='" + planEndDate + '\'' +
                ", plan='" + plan + '\'' +
                ", userId=" + userId +
                '}';
    }
}

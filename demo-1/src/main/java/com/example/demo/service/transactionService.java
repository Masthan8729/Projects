package com.example.demo.service;

import com.example.demo.Dao.transactionDao;
import com.example.demo.vo.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class transactionService {

    @Autowired
    private transactionDao transactionDao;

    public void saveTransaction(Transaction transaction){
        transactionDao.saveTransaction(transaction);
    }

    public List<Transaction> getTransactions(int userId){
        return transactionDao.getAllTransactions(userId);
    }

    public Transaction getTransactionsByTransactionId(int transactionId){
        return transactionDao.getTransactionById(transactionId);
    }

    public List<Transaction> getTransactionsByPlanEndDate(String planEndDate){
        return transactionDao.getTransactionByPlanEndDate(planEndDate);
    }

    public List<Transaction> getTransactionsByPlan(String plan){
        return transactionDao.getTransactionByPlan(plan);
    }

    public Transaction getTransactionsByTransactionItem(String transactionItem){
        return transactionDao.getTransactionByItem(transactionItem);
    }

    public void deleteTransactionById(int transactionId){
        transactionDao.deleteTransactionById(transactionId);
    }

    public List<Transaction> getTransactionsByTransactionDate(String transactionDate){
        return transactionDao.getTransactionsByTransactionDate(transactionDate);
    }
    public List<Transaction> getTransactionsByUserId(int userId){
        return transactionDao.getTransactionsByUserId(userId);
    }
    public List<Transaction> getTransactionsByUserIdAndTransactionDate(int userId,String transactionDate){
        return transactionDao.getTransactionsByUserIdAndTransactionDate(userId, transactionDate);
    }

    public List<Transaction> getTransactionsByUserIdAndPlanEndDate(int userId, String planEndDate){
        return transactionDao.getTransactionsByUserIdAndPlanEndDate(userId, planEndDate);
    }
    public int getNoOfTransactions(int userId){
        return transactionDao.getNoOfTransactions(userId);
    }

    public List<Transaction> getAllTransactionstoCheckIfPlanEnds(int userId){
        return transactionDao.getAllTransactionstoCheckIfPlanEnds(userId);
    }
}

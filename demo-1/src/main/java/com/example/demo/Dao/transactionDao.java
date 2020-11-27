package com.example.demo.Dao;

import com.example.demo.vo.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class transactionDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void saveTransaction(Transaction transaction){
        String sql="insert into subscription_transaction_details_tbl(transaction_amount,transaction_date,transaction_item,plan_end_date,plan,user_id) values(?,?,?,?,?,?)";
        jdbcTemplate.update(sql,new Object[]{transaction.getTransactionAmount(),transaction.getTransactionDate(),transaction.getTransactionItem(),transaction.getPlanEndDate(),transaction.getPlan(),transaction.getUserId()});
    }

    public List<Transaction> getAllTransactions(int userId){
        String sql="select * from subscription_transaction_details_tbl where user_id=?";
        List<Transaction> transactions=jdbcTemplate.query(
                sql,
                new Object[]{userId},
                new BeanPropertyRowMapper<>(Transaction.class)
        );
        return transactions;
    }

    public Transaction getTransactionById(int id){
        String sql="select * from subscription_transaction_details_tbl where transaction_id=?";
        return (Transaction) jdbcTemplate.queryForObject(
                sql,
                new Object[]{id},
                new BeanPropertyRowMapper<>(Transaction.class));
    }
    public List<Transaction> getTransactionByPlanEndDate(String planEndDate){
        String sql="select * from subscription_transaction_details_tbl where plan_end_date=?";
        List<Transaction> transactions= jdbcTemplate.query(
                sql,
                new Object[]{planEndDate},
                new BeanPropertyRowMapper<>(Transaction.class));
        return transactions;
    }
    public List<Transaction> getTransactionByPlan(String plan){
        String sql="select * from subscription_transaction_details_tbl where plan=?";
        List<Transaction> transactions= jdbcTemplate.query(
                sql,
                new Object[]{plan},
                new BeanPropertyRowMapper<>(Transaction.class));
        return transactions;
    }
    public Transaction getTransactionByItem(String transactionItem){
        String sql="select * from subscription_transaction_details_tbl where transaction_item=?";
        return (Transaction) jdbcTemplate.queryForObject(
                sql,
                new Object[]{transactionItem},
                new BeanPropertyRowMapper<>(Transaction.class));
    }
    public void deleteTransactionById(int transactionId){
        String sql="delete from subscription_transaction_details_tbl where transaction_id=?";
        jdbcTemplate.update(sql,transactionId);
    }

    public List<Transaction> getTransactionsByTransactionDate(String transactionDate){
        String sql="select * from subscription_transaction_details_tbl where transaction_date=?";
        List<Transaction> transactions= jdbcTemplate.query(
                sql,
                new Object[]{transactionDate},
                new BeanPropertyRowMapper<>(Transaction.class));
        return transactions;
    }

   /* public List<Transaction> getTransactionsByTransactionDateAndUserId(String transactionDate,int userId){
        String sql="select * from subscription_transaction_details_tbl where transaction_date=? and user_id=?";
        List<Transaction> transactions= jdbcTemplate.query(
                sql,
                new Object[]{transactionDate,userId},
                new BeanPropertyRowMapper<>(Transaction.class));
        return transactions;
    }*/

    public List<Transaction> getTransactionsByUserId(int userId){
        String sql="select * from subscription_transaction_details_tbl where user_id=?";
        List<Transaction> transactions= jdbcTemplate.query(
                sql,
                new Object[]{userId},
                new BeanPropertyRowMapper<>(Transaction.class));
        return transactions;
    }

    public List<Transaction> getTransactionsByUserIdAndTransactionDate(int userId,String transactionDate){
        String sql="select * from subscription_transaction_details_tbl where user_id=? and transaction_date=?";
        List<Transaction> transactions= jdbcTemplate.query(
                sql,
                new Object[]{userId,transactionDate},
                new BeanPropertyRowMapper<>(Transaction.class));
        return transactions;
    }

    public List<Transaction> getTransactionsByUserIdAndPlanEndDate(int userId,String planEndDate){
        String sql="select * from subscription_transaction_details_tbl where user_id=? and plan_end_date=?";
        List<Transaction> transactions= jdbcTemplate.query(
                sql,
                new Object[]{userId,planEndDate},
                new BeanPropertyRowMapper<>(Transaction.class));
        return transactions;
    }
    public int getNoOfTransactions(int userId){
        String sql="select count(*) from subscription_transaction_details_tbl where user_id=?";
        int count=jdbcTemplate.queryForObject(sql,new Object[]{userId},Integer.class);
        return count;
    }

    public List<Transaction> getAllTransactionstoCheckIfPlanEnds(int userId){
        String sql="select * from subscription_transaction_details_tbl where user_id=?";
        List<Transaction> transactions=jdbcTemplate.query(
                sql,
                new Object[]{userId},
                new BeanPropertyRowMapper<>(Transaction.class)
        );
        return transactions;
    }
}

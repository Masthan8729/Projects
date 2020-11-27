package com.example.demo.controller;

import com.example.demo.service.mailService;
import com.example.demo.service.userService;
import com.example.demo.vo.Transaction;
import com.example.demo.service.transactionService;

import com.example.demo.vo.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.plugin.javascript.navig.Array;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@RestController
public class transactionController {
    final static Logger log = LogManager.getLogger(transactionController.class);
    @Autowired
    private transactionService service;

    @Autowired
    private mailService mailService;

    @Autowired
    private userService userService;

    public void check(){
        System.out.println("hey buddy");
    }

    @PostMapping("/addTransaction")
    @CrossOrigin("http://localhost:4200/")
    public void saveTransaction(@RequestBody Transaction transaction)  {
       service.saveTransaction(transaction);
        log.info("Saving transaction");
    }
    
    public void checkIfPlanEnds(String[] planEndDate,int userId) throws ParseException {
        log.info("Checking if current date is near to plan end date");

        User userobj = userService.findUserById(userId);
        int n = service.getNoOfTransactions(userId);
        String[] pedArr = new String[n];
        LinkedHashSet<String> uniquePlanEndDates = new LinkedHashSet<String>(Arrays.asList(planEndDate));
        String[] newArray = uniquePlanEndDates.toArray(new String[uniquePlanEndDates.size()]);
        for (String value : newArray) {
            List<Transaction> transactionList = service.getTransactionsByUserIdAndPlanEndDate(userId, value);
            System.out.println(transactionList);
            for (int i = 0; i < transactionList.size(); i++) {
                pedArr[i] = transactionList.get(i).getTransactionItem();
            }
            System.out.println(Arrays.toString(pedArr));
            String pattern = "dd-MM-yyyy";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            Date date = null;
            try {
                date = simpleDateFormat.parse(value);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            long millis = date.getTime();
            long curDate = new Date().getTime();
            long beforeDueDate = millis - 604800000;
            if (curDate >= beforeDueDate) {
                for (int i = 0; i < transactionList.size(); i++) {
                    mailService.sendMail(userobj.getEmail(), "Subscription ending", "Your subscription for " + pedArr[i] + " is going to end on " + value);
                    log.info("Sending mail to the user");
                }
            }


        }
    }
    @GetMapping("/getAllTransactions/{userId}")
    @CrossOrigin("http://localhost:4200/")
    /*@CrossOrigin("https://web.postman.co/build")*/
    public List<Transaction> getAllTransactions(@PathVariable("userId") int userId) throws ParseException {

        log.info("Getting all transactions of the user");
        List<Transaction> transactionList = service.getTransactions(userId);
        /*int n=service.getNoOfTransactions(userId);
        String[] str=new String[n];
        for(int i=0;i<n;i++) {
            str[i] = transactionList.get(i).getPlanEndDate();
        }
        checkIfPlanEnds(str,userId);*/
        return transactionList;
    }
    @GetMapping("/getAllTransactionstoCheckIfPlanEnds/{userId}")
    public List<Transaction> getAllTransactionstoCheckIfPlanEnds(@PathVariable("userId") int userId) throws ParseException {

        log.info("in getAllTransactionstoCheckIfPlanEnds method");
        List<Transaction> transactionList = service.getAllTransactionstoCheckIfPlanEnds(userId);
        int n=service.getNoOfTransactions(userId);
        String[] str=new String[n];
        for(int i=0;i<n;i++) {
            str[i] = transactionList.get(i).getPlanEndDate();
        }
        checkIfPlanEnds(str,userId);
        return transactionList;
    }

    @GetMapping("/getTransactionById/{transactionId}")
    @CrossOrigin("https://web.postman.co/build")
    public Transaction getTransactionsByTransactionId(@PathVariable int transactionId){
        log.info("Getting transaction by transaction Id");
        Transaction transactionList=service.getTransactionsByTransactionId(transactionId);
        return transactionList;
    }


    @GetMapping("/getTransactionBytransactionItem/{transactionItem}")
    @CrossOrigin("https://web.postman.co/build")
    public Transaction getTransactionsByTransactionItem(@PathVariable String transactionItem){
        log.info("Getting transaction by Transaction item");
        Transaction transactionList=service.getTransactionsByTransactionItem(transactionItem);
        return transactionList;
    }

    @DeleteMapping("deleteTransactionById/{transactionId}")
    public void deleteTransactionById(@PathVariable int transactionId){
        log.info("Deleting transaction by transaction Id");
        service.deleteTransactionById(transactionId);
    }


        @GetMapping("/getTransactionsByUserIdAndTransactionDate/{userId}/{transactionDate}")
    @CrossOrigin("https://web.postman.co/build")
    public List<Transaction> getTransactionsByUserIdAndTransactionDate(@PathVariable("userId") int userId,@PathVariable("transactionDate") String transactionDate){
            log.info("Getting transactions of the user by Transaction date");
        List<Transaction> transactionList=service.getTransactionsByUserIdAndTransactionDate(userId, transactionDate);
        return transactionList;
    }

    @GetMapping("/getTransactionsByUserIdAndPlanEndDate/{userId}/{planEndDate}")
    @CrossOrigin("https://web.postman.co/build")
    public List<Transaction> getTransactionsByUserIdAndPlanEndDate(@PathVariable("userId") int userId,@PathVariable("planEndDate") String planEndDate){
        log.info("Getting transactions of the user by Plan end date");
        List<Transaction> transactionList=service.getTransactionsByUserIdAndPlanEndDate(userId, planEndDate);
        return transactionList;

    }
}

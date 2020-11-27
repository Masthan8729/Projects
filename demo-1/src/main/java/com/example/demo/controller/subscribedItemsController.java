package com.example.demo.controller;


import com.example.demo.service.mailService;
import com.example.demo.service.userService;
import com.example.demo.vo.Transaction;
import com.example.demo.vo.subscribedItems;
import com.example.demo.service.subscribedItemsService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;
import com.example.demo.vo.User;
import java.util.List;

@RestController
public class subscribedItemsController {

    final static Logger log = LogManager.getLogger(subscribedItemsController.class);

    @Autowired
    private subscribedItemsService service;

    @Autowired
    private userService userService;

    @Autowired
    private mailService mailService;

    @PostMapping("/addSubscribedItems")
    @CrossOrigin("https://web.postman.co/build/")
    public void saveSubscribedItems(@RequestBody subscribedItems subscribedItem) throws Exception {
           /* subscribedItems obj=service.saveSubscribedItems(subscribedItems);
            return obj;*/


            String subscribedItemName= subscribedItem.getSubscribedItemName();
            int userId=subscribedItem.getUserId();
            System.out.println(subscribedItemName);
            boolean value=service.findSubscribedItemExistsOnUserId(userId,subscribedItemName);
            System.out.println(value);
            if(value==true){
                User userobj=userService.findUserById(userId);
                service.saveSubscribedItems(subscribedItem);
                log.info("Saving subscribed item");
                mailService.sendMail(userobj.getEmail(),"Subscription Successful","You have successfully subscribed "+subscribedItem.getSubscribedItemName()+"\n\n\n"+
                "Name       : "+subscribedItemName+"\n"+ "Category  : "+subscribedItem.getSubscribedItemType()+"\n"+"Plan         : "+subscribedItem.getSubscribedItemPlan()

                );
            }
            else {
                throw new Exception("You have already subscribed " + subscribedItemName);
            }
    }

    @GetMapping("/getSubscribedItems/{userId}")
    @CrossOrigin("https://web.postman.co/build/")
    public Iterable<subscribedItems> getSubscribedItems(@PathVariable("userId") int userId)
    {
        log.info("Getting all subscribed items of the user");
        Iterable<subscribedItems> subscribedItemsList=service.getSubscribedItems(userId);
        return subscribedItemsList;
    }
    @GetMapping("/getSubscribedItemByName/{subscribedItemName}")
    @CrossOrigin("https://web.postman.co/build/")
    public subscribedItems getSubscribedItemByName(@PathVariable String subscribedItemName){
        log.info("Getting subscribed item by name");
        subscribedItems itemName=service.getsubscribedItemByName(subscribedItemName);
        return itemName;
    }
    @DeleteMapping("/deleteSubscribedItemByName/{subscribedItemName}")
    public String deleteSubscribedItemByName(@PathVariable String subscribedItemName )
    {
        log.info("deleting subscribed item by subscribed item name");
        service.deleteSubscribedItemByName(subscribedItemName);
        return "SubscribedItem deleted";
    }

    /*@GetMapping("/getSubscribedItemByPlan/{subscribedItemPlan}")
    public List<subscribedItems> getSubscribedItemByPlan(@PathVariable String subscribedItemPlan){
        List<subscribedItems> subscribedItemsList=service.getSubscibedItemByPlan(subscribedItemPlan);
        return subscribedItemsList;
    }*/
}

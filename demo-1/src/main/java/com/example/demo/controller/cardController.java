package com.example.demo.controller;


import com.example.demo.Demo1Application;
import com.example.demo.vo.Card;
import com.example.demo.service.cardService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class cardController {

    final static Logger log = LogManager.getLogger(cardController.class);
    @Autowired
    private cardService service;


    @PostMapping("/addCard")
   /* @CrossOrigin("http://localhost:4200")*/
    @CrossOrigin("https://web.postman.co/build")
    public void saveCard(@RequestBody Card card) throws Exception {
        String cardNo=card.getCardNo();
        int userId=card.getUserId();
        boolean value=service.findCardNumExistsOnUserId(userId,cardNo);
        if(value==true) {
            service.saveCard(card);
            log.info("Saving Credit card");
        }
        else{
            throw new Exception("You have already added "+card.getCardNo());
        }
    }

    @GetMapping("/getCards/{userId}")
    @CrossOrigin("https://web.postman.co/build")
    public List<Card> getAllCards(@PathVariable("userId") int userId){
        log.info("Getting all credit cards of the user");
        List<Card> cards=service.getCards(userId);
        return  cards;
    }
    @GetMapping("/getCard/{cardId}")
    public Card getCardByCardId(@PathVariable int cardId)
    {
        log.info("Getting card by Id");
        Card cardobj=service.getCardByCardId(cardId);
        return  cardobj;
    }

    @DeleteMapping("deleteCardById/{cardId}")
    public String deleteCardById(@PathVariable("cardId") int cardId){
        log.info("Deleting card by Id");
        return service.deleteCardById(cardId);
    }
}

package com.example.demo.service;

import com.example.demo.Dao.cardDao;
import com.example.demo.vo.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class cardService {

    @Autowired
    private cardDao cardDao;

    public void saveCard(Card card)
    {
        cardDao.saveCard(card);
    }
    public List<Card> getCards(int userId){
        return cardDao.findAllCards(userId);
    }

    public Card getCardByCardId(int cardId){
        return cardDao.getCardById(cardId);
    }

    public boolean findCardNumExistsOnUserId(int userId, String cardNo){
        return cardDao.findCardNumExistsOnUserId(userId, cardNo);
    }

    public String deleteCardById(int cardId){
        return  cardDao.deleteCardById(cardId);
    }
}

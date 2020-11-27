package com.example.demo.Dao;

import com.example.demo.vo.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class cardDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void saveCard(Card card){
        String sql="insert into card_details_tbl(card_no,name_on_card,expiry_date,cvv,user_id) values(?,?,?,?,?)";
        jdbcTemplate.update(sql,new Object[] {card.getCardNo(),card.getNameOnCard(),card.getExpiryDate(),card.getCvv(),card.getUserId()});
    }
    public List<Card> findAllCards(int userId) {

        String sql = "SELECT * FROM card_details_tbl where user_id=? ";
        List<Card> cards = jdbcTemplate.query(
                sql,
                new Object[]{userId},
                new BeanPropertyRowMapper<>(Card.class));

        return cards;

    }

    public Card getCardById(int cardId){
        String sql="select * from card_details_tbl where card_id=?";
        return (Card) jdbcTemplate.queryForObject(
                sql,
                new Object[]{cardId},
                new BeanPropertyRowMapper<>(Card.class));
    }
    public boolean findCardNumExistsOnUserId(int userId,String cardNo)
    {
        String sql="select count(*) from card_details_tbl  where user_id=? and card_no=?";

        int count=jdbcTemplate.queryForObject(sql,new Object[] {userId,cardNo},Integer.class );

        if(count>0)
        {
            return false;
        }
        else {
            return true;
        }
    }

    public String deleteCardById(int cardId){
        String sql="delete from card_details_tbl where card_id=?";
        jdbcTemplate.update(sql,cardId);
        return "Card deleted";
    }
}

package com.example.demo.Dao;

import com.example.demo.vo.subscribedItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class subscribedItemsDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addSubcribedItems(subscribedItems subscribedItems){
        String sql="insert into subscribed_items_tbl(subscribed_item_name,subscribed_item_type,subscribed_item_plan,user_id) values(?,?,?,?)";
        jdbcTemplate.update(sql,new Object[]{subscribedItems.getSubscribedItemName(),subscribedItems.getSubscribedItemType(),subscribedItems.getSubscribedItemPlan(),subscribedItems.getUserId()});
    }

    public subscribedItems getSubscribedItemByName(String subscribedItemName){
        String sql="select * from subscribed_items_tbl where subscribed_item_name=?";
        return (subscribedItems) jdbcTemplate.queryForObject(
                sql,
                new Object[]{subscribedItemName},
                new BeanPropertyRowMapper<>(subscribedItems.class));
    }
    public List<subscribedItems> findAllSubscribedItems(int userId) {

        String sql = "SELECT * FROM subscribed_items_tbl where user_id=?";
        List<subscribedItems> subscribedItems = jdbcTemplate.query(
                sql,
                new Object[]{userId},
                new BeanPropertyRowMapper<>(subscribedItems.class));
        return subscribedItems;

    }
    public void deleteSubscribedItemByName(String subscribedItemName){
        String sql="delete from subscribed_items_tbl where subscribed_item_name=?";
        jdbcTemplate.update(sql,subscribedItemName);
    }

    public List<subscribedItems> getSubscribedItemByPlan(String plan){
        String sql="select * from subscribed_items_tbl  where subscribed_item_plan=?";
        List<subscribedItems> subscribedItems= jdbcTemplate.query(
                sql,
                new Object[]{plan},
                new BeanPropertyRowMapper<>(subscribedItems.class));
        return subscribedItems;
    }

    public boolean findSubscribedItemExistsOnUserId(int userId,String subscribedItemName)
    {
        String sql="select count(*) from subscribed_items_tbl  where user_id=? and subscribed_item_name=?";

        int count=jdbcTemplate.queryForObject(sql,new Object[] {userId,subscribedItemName},Integer.class );

        if(count>0)
        {
            return false;
        }
        else {
            return true;
        }
    }
    
}

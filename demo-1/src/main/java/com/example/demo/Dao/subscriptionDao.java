package com.example.demo.Dao;

import com.example.demo.vo.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class subscriptionDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addSubscription(Subscription subscription) {
        String sql="insert into subscription_details_tbl(subscription_name,subscription_type) values(?,?)";
        jdbcTemplate.update(sql,new Object[] {subscription.getSubscriptionName(),subscription.getSubscriptionType()});
    }

    public Subscription getSubscriptionById(int subscriptionId){
        String sql="select * from subscription_details_tbl where subscription_id=?";
        return (Subscription) jdbcTemplate.queryForObject(
                sql,
                new Object[]{subscriptionId},
                new BeanPropertyRowMapper<>(Subscription.class));
    }
    public List<Subscription> findAllSubscriptions() {

        String sql = "SELECT * FROM subscription_details_tbl ";
        List<Subscription> subscriptions = jdbcTemplate.query(
                sql,
                new BeanPropertyRowMapper<>(Subscription.class));
        return subscriptions;

    }
    public boolean isSubscriptionAlreadyExist(String subscriptionName)
    {
        String sql="select count(*) from subscription_details_tbl  where subscription_name=?";

        int count=jdbcTemplate.queryForObject(sql,new Object[] {subscriptionName},Integer.class );

        if(count>0)
        {
            return false;
        }
        else {
            return true;
        }
    }
}

package com.example.demo.Dao;

import com.example.demo.vo.Plans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class plansDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addPlan(Plans plans) {
        String sql="insert into subcription_plans_tbl(monthly,three_months,six_months,one_year) values(?,?,?,?)";
        jdbcTemplate.update(sql,new Object[] {plans.getMonthly(),plans.getThreeMonths(),plans.getSixMonths(),plans.getOneYear()});
    }

    public Plans getPlanById(int planId){
        String sql="select * from subcription_plans_tbl where plan_id=?";
        return (Plans) jdbcTemplate.queryForObject(
                sql,
                new Object[]{planId},
                new BeanPropertyRowMapper<>(Plans.class));
    }
}

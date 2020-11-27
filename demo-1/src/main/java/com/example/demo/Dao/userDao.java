package com.example.demo.Dao;

import com.example.demo.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class userDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addUser(User user) {
        String sql="insert into registered_user_tbl(first_name,last_name,email,password) values(?,?,?,?)";
        jdbcTemplate.update(sql, new Object[]{user.getFirstName(),user.getLastName(),user.getEmail(),user.getPassword()});
    }
    public User getUserByEmail(String email){
        String sql="select * from registered_user_tbl where email=?";
        return (User) jdbcTemplate.queryForObject(
                sql,
                new Object[]{email},
                new BeanPropertyRowMapper<>(User.class));
    }
    public User getuserByEmailAndPassword(String email,String password){
        String sql="select * from registered_user_tbl where email=? and password=?";
        return (User) jdbcTemplate.queryForObject(
                sql,
                new Object[]{email,password},
                new BeanPropertyRowMapper<>(User.class));
    }
    public boolean findUserExists(String email)
    {
        String sql="select count(*) from registered_user_tbl where email=?";

        int count=jdbcTemplate.queryForObject(sql,new Object[] {email},Integer.class );

        if(count>0)
        {
            return false;
        }
        else {
            return true;
        }
    }
    public User findUserById(int userId){
        String sql="select * from registered_user_tbl where user_id=?";
        return (User) jdbcTemplate.queryForObject(sql,new Object[]{userId},new BeanPropertyRowMapper<>(User.class));
    }
}

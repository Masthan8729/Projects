package com.example.demo.service;

import com.example.demo.Dao.userDao;
import com.example.demo.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userService {

    @Autowired
    private userDao userDao;

    public User fetchUserByEmail(String email){
        return userDao.getUserByEmail(email);
    }
    public void saveUser(User user){
        userDao.addUser(user);
    }
    public User fetchUserByEmailAndPassword(String email,String password){
        return userDao.getuserByEmailAndPassword(email,password);
    }
    public boolean findUserExists(String email){
        return userDao.findUserExists(email);
    }

    public User findUserById(int userId){
        return userDao.findUserById(userId);
    }
}

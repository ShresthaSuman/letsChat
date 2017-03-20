/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.chat.listener.UserDAOImpl;

import com.leapfrog.chat.entity.User;
import com.leapfrog.chat.userDAO.userDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mr. Shrestha Suman
 */
public class userDAOImpl implements userDAO {

    @Override
    public List<User> getAll() {
    List<User> userList=new ArrayList<>();
    userList.add(new User(1,"suman","suman","suman@gmail.com",true));
     userList.add(new User(2,"abhishesh","abhishesh","abhi@gmail.com",true));
      userList.add(new User(3,"rahul","rahul","rahul@gmail.com",true));
       userList.add(new User(4,"sadip","sadip","sadip@gmail.com",true));
       return userList;
    }

    @Override
    public User login(String username, String password) {
    for(User u:getAll()){
    if(u.getUsername().equalsIgnoreCase(username)&&u.getPassword().equalsIgnoreCase(password)){
    return u;
    }
     
   
    }
    return null;
    } 
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.chat.userDAO;

import com.leapfrog.chat.entity.User;
import java.util.List;

/**
 *
 * @author Mr. Shrestha Suman
 */
public interface userDAO {
    List<User> getAll();
    User login(String username,String password);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.chat.entity;

import java.net.Socket;

/**
 *
 * @author Mr. Shrestha Suman
 */
public class Client {
    String Username;
    Socket socket;

    public Client(String Username, Socket socket) {
        this.Username = Username;
        this.socket = socket;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
    
}

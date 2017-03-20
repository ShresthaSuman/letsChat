/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.chat.listener.handler;

import com.leapfrog.chat.entity.Client;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mr. Shrestha Suman
 */
public class ClientHandler {

    List<Client> clientList = new ArrayList<>();

    public void addClient(Client c) {
        clientList.add(c);
    }

    public void removeClient(Client c) {
        clientList.remove(c);
    }

    public List<Client> getClient() {
        return clientList;
    }

    Client getByUsername(String username) {
        for (Client c : clientList) {
            if (c != null) {
                if (c.getUsername().equalsIgnoreCase(username)) {
                    return c;
                }
            }
        }
        return null;
    }

    Client getBySocket(Socket socket) {
        for (Client c : clientList) {
            if (c != null) {
                if (c.getSocket().equals(c)) {
                    return c;
                }
            }
        }
        return null;
    }

}

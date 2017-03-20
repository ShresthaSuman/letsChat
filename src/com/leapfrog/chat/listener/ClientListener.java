/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.chat.listener;

import com.leapfrog.chat.entity.Client;
import com.leapfrog.chat.entity.User;
import com.leapfrog.chat.listener.handler.ClientHandler;
import com.leapfrog.chat.userDAO.userDAO;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 *
 * @author Mr. Shrestha Suman
 */
public class ClientListener extends Thread {

    Client client;
    ClientHandler handler;
    Socket socket;
    PrintStream ps;
    BufferedReader bf;
    userDAO userDAO;

    public ClientListener(Socket socket, ClientHandler handler) throws IOException {
        this.socket = socket;
        this.handler = handler;
        bf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        ps = new PrintStream(socket.getOutputStream());
    }

    @Override
    public void run() {
        try {
            while (!doLogin()) {
                ps.println("welcome to my guffgaff room");
            }
            while (!interrupted()) {
                ps.println(">>");
                String line = bf.readLine();
                broadcastMessage(client, client.getUsername() + "says >> " + line);

            }

        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }

    }

    private boolean doLogin() throws IOException {
        boolean success = false;
        ps.println("enter your username");
        String username = bf.readLine();
        ps.println("enter password");
        String password = bf.readLine();
        User user = userDAO.login(username, password);
        if (user == null) {
            ps.println("user doesnot exist");
            success = false;
        } else {
            if (!user.isStatus()) {
                ps.println("account not activated yet");
                success = false;
            } else {
                Client client = new Client(username, socket);
                handler.addClient(client);
                ps.println("thannkyou for login");
                broadcastMessage(client, username + " has logged in");
                success = true;
            }
        }
        return success;
    }

    public void broadcastMessage(Client client, String msg) throws IOException {
        for (Client c : handler.getClient()) {
            if (!c.equals(client)) {
                PrintStream writer = new PrintStream(c.getSocket().getOutputStream());
                writer.println(msg);

            }
        }

    }

}

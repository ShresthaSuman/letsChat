/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.chat;

import com.leapfrog.chat.listener.ClientListener;
import com.leapfrog.chat.listener.handler.ClientHandler;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Mr. Shrestha Suman
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       int port=9999;
     try{
       ServerSocket server=new ServerSocket(port);
         System.out.println("the currently use port is "+port);
         ClientHandler handler=new ClientHandler();
       while(true){
       Socket socket=server.accept();
           System.out.println("the client ip is "+socket.getInetAddress().getHostAddress());
           ClientListener listener=new ClientListener(socket,handler);
          listener.start();
       }
    }catch(IOException ioe){
         System.out.println(ioe.getMessage());
    }
    
    }
    
}

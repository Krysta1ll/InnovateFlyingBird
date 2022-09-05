package com.example.innovateflyingbird.gaming;

import com.example.innovateflyingbird.gaming.GameFrame;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
//    private static Socket socket;
    public static boolean connection_state = false;

    public static void main(String[] args){
        Socket socket = new Socket();
        while (!connection_state) {
            connect(socket);
            try {
                Thread.sleep(3000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    private static void connect(Socket socket){
        try {
            socket = new Socket("192.168.112.179", 8081);
            connection_state = true;
            new Thread(new Client_listen(socket)).start();
            new Thread(new Client_send(socket)).start();
        }catch (Exception e){
            e.printStackTrace();
            connection_state = false;
        }
    }

    public static void reconnect(Socket socket){
        while (!connection_state){
            System.out.println("Trying reconnecting...");
            connect(socket);
            try {
                Thread.sleep(3000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}

class Client_listen implements Runnable{
    private Socket socket;

    Client_listen(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            while (true){
                InputStreamReader isr = new InputStreamReader(socket.getInputStream());
                BufferedReader br = new BufferedReader(isr);
                String info = br.readLine();
                System.out.println(info);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

class Client_send implements Runnable{
    private Socket socket;

    Client_send(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try{
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            while(true) {
                GameFrame frame = new GameFrame();
                frame.setLocation(100, 100);
                frame.setVisible(true);
                while (frame.bird.bmove) {
                    int count = frame.count;
                    pw.println("Enermy's score is " + count);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            try{
                socket.close();
                Client.connection_state = false;
                Client.reconnect(socket);
            }catch(Exception ee){
                ee.printStackTrace();
            }
        }
    }
}


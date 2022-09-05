package com.example.innovateflyingbird.gaming;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
// import org.json.simple.JSONObject;


public class Server {
    public static void main(String[] args){
        try {
            //           socket总部
            // serversocket    clientsocket
            //    允许通信
            //  开始监听/发送

            String ipAddress = null;

            try{
                ipAddress = InetAddress.getLocalHost().getHostAddress();
                System.out.println(ipAddress);
            }catch(Exception e){
                e.printStackTrace();
            }

            System.out.println("Socket ready");
            ServerSocket serverSocket = new ServerSocket(8081);

            Socket socket = serverSocket.accept();
            new Thread(new Server_listen(socket)).start();
            new Thread(new Server_send(socket)).start();

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Server_listen implements Runnable {
    private Socket socket;

    Server_listen(Socket socket) {
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


class Server_send implements Runnable {
    private Socket socket;
    public Server_send(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try{
                PrintWriter pw = new PrintWriter(socket.getOutputStream());

                GameFrame frame = new GameFrame();
                frame.setLocation(100, 100);
                frame.setVisible(true);
                while(frame.bird.bmove) {
                    int count = frame.count;
                    pw.println("Enermy's score is " + count);
                    System.out.println(count);
                }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
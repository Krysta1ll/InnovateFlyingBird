package com.example.innovateflyingbird.gaming;
import com.example.innovateflyingbird.dao.UserDAO;
import com.example.innovateflyingbird.views.loginViewController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.Buffer;
import java.util.Random;

public class GameFrame extends JFrame implements KeyListener {
    Random ran = new Random();
    int count = 0;
    String user= loginViewController.userName;
    // 鸟是在飞还是下降的状态
    int flag = 0;
    Bg bg = new Bg();
    Bird bird = new Bird(this);
    Bround bround = new Bround();
    Colum colum0 = new Colum(this);
    Colum colum1 = new Colum(this);
    Score score = new Score();
    Image offScreenImage;
    Coin coin = new Coin();
    int start = 0;
    MusicPlayer player = new MusicPlayer(this);
    public GameFrame() {
        this.setFocusable(true);
        this.addKeyListener(this);
        colum1.x = 700;
        //bround.start();

        //bird.start();
        setSize(700, 670);
        setLocationRelativeTo(null);
        setResizable(false);
        // setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setTitle("InnovateFlyBird");

        player.start();
        bround.start();
        bird.start();


     new Thread() {

            public void run() {


                    while (bird.bmove) {
                        repaint();
                        if (bird.v0 <= 0) {
                            flag = 2;
                        }
                        try {
                            Thread.sleep(0);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    bround.stop();
                    bird.stop();
                    player.stop();
                }

        }.start();

    }

//    Thread main= new Thread() {
//
//        public void run() {
//
//
//            while (bird.bmove) {
//                repaint();
//                if (bird.v0 <= 0) {
//                    flag = 2;
//                }
//                try {
//                    Thread.sleep(0);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//            bround.interrupt();
//            bird.interrupt();
//            player.interrupt();
//        }
//
//    };
    public void paint(Graphics g) {
        offScreenImage = this.createImage(700, 670);
        Graphics gImage = offScreenImage.getGraphics();
        gImage.drawImage(bg.bg0, 0, 0, bg.w, bg.h, null );
        gImage.drawImage(bg.bg0, bg.w, 0, bg.w, bg.h, null );
        gImage.drawImage(colum0.colum1, colum0.x, colum0.y, colum0.w, colum0.h / 2, null);
        gImage.drawImage(colum0.colum0, colum0.x, colum0.y + colum0.h / 2 + colum0.distance, colum0.w, colum0.h / 2, null);
        gImage.drawImage(colum1.colum1, colum1.x, colum1.y, colum1.w, colum1.h / 2, null);
        gImage.drawImage(colum1.colum0, colum1.x, colum1.y + colum1.h / 2 + colum1.distance, colum1.w, colum1.h / 2, null);
        if(50 <= count && count <= 52) {
            bird.bird = bird.ybird;
        } else if(100 <= count && count <= 102) {
            bird.bird = bird.rbird;
        }
        if(bird.y < 39) {
            bird.y = 39;
        }
        gImage.drawImage(bird.bird.get(flag), bird.x, bird.y, bird.w, bird.h, null);
        gImage.drawImage(bround.bround, bround.x, bround.y, bround.w , bround.h, null);
        gImage.drawImage(bround.bround, bround.x + bround.w - 57, bround.y, bround.w , bround.h, null);
        int temp = count;
        int i = 0;
        while(temp != 0) {
            int k = temp % 10;
            temp /= 10;
            gImage.drawImage(score.img.get(k), 650 - i * 40, 60, 40, 40, null);
            i ++;
        }
        if(coin.flag) {
            gImage.drawImage(coin.coin.get(1), coin.x, coin.y, coin.w, coin.h, null);
        }
        if(!bird.bmove) {
            gImage.drawImage(bg.bg2, 130, 180, 480, 120, null);



            UserDAO userDAO=new UserDAO();
            int oddScore=userDAO.getInfo(user,"highestScore");
            if(oddScore<count) {
                userDAO.highScore(count, user);
                System.out.println("--最高分为"+count+"已上传--");
            }
        }
        g.drawImage(offScreenImage, 0, 0, null);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if(key==KeyEvent.VK_ENTER){
//            main.start();
//            bround.start();
//            bird.start();
//            player.start();

        }
        if(key == KeyEvent.VK_SPACE) {


            if(start == 0) {
                start = 1;
            }else if(start == 1) {
                start = 2;
            }
            bird.moveup();
            flag = 1;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

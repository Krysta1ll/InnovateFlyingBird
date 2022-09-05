package com.example.innovateflyingbird.gaming;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Bird extends Thread {
    GameFrame frame = null;
    public boolean alive=false;
    public int x = 110;
    public int y = 320;
    public int w = 44;
    public int h = 32;
    public double v0 = 2.0;
    public double t = 0.23;
    public double s = 0;
    public double g = 1;
    boolean bmove = true;
    public List<BufferedImage> bird = new ArrayList<>();
    public List<BufferedImage> bbird = new ArrayList<>();
    public List<BufferedImage> rbird = new ArrayList<>();
    public List<BufferedImage> ybird = new ArrayList<>();
    public BufferedImage bird0 = Tools.getImage("img/blue-mid.png");
    public BufferedImage bird1 = Tools.getImage("img/blue-up.png");
    public BufferedImage bird2 = Tools.getImage("img/blue-down.png");
    public BufferedImage bird3 = Tools.getImage("img/red-mid.png");
    public BufferedImage bird4 = Tools.getImage("img/red-up.png");
    public BufferedImage bird5 = Tools.getImage("img/red-down.png");
    public BufferedImage bird6 = Tools.getImage("img/yellow-mid.png");
    public BufferedImage bird7 = Tools.getImage("img/yellow-up.png");
    public BufferedImage bird8 = Tools.getImage("img/yellow-down.png");

    public Bird(GameFrame frame) {
        this.frame = frame;
        bbird.add(bird0);
        bbird.add(bird1);
        bbird.add(bird2);
        rbird.add(bird3);
        rbird.add(bird4);
        rbird.add(bird5);
        ybird.add(bird6);
        ybird.add(bird7);
        ybird.add(bird8);
        bird = bbird;
    }

    public void move() {
        s = v0 * t;
        y = (int)(y - s);
        double v2 = v0 - g * t;
        v0 = v2;
    }

    public void collid(Colum c) {
        if(y + 32 >= 529) {
            bmove = false;
        }
        if(x >= c.x - 44 && x <= c.x + 70) {
            if(y <= c.y + 545 || y + 32 >= c.y + 545 + 120) {
                bmove = false;
            }
        }
    }

    public void coincollid() {
        if(x >= frame.coin.x - 44 && x <= frame.coin.x + 40 + 44) {
            if(y >= frame.coin.y - 32 && y <= frame.coin.y + 30 + 32) {
                if(frame.coin.flag) {
                    frame.count += 3;
                }
                frame.coin.flag = false;

            }
        }
    }


    public void moveup() {
        v0 = 6 ;
    }


    public void run() {
        while(true) {
            if(bmove) {
                move();
                collid(frame.colum0);
                collid(frame.colum1);
                coincollid();
            }
            try {
                Thread.sleep(7);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }


}

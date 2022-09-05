package com.example.innovateflyingbird.gaming;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Colum {
    GameFrame frame = null;
    Random r = new Random();
    public int x = 300;
    public int y = -220;
    public int w = 70;
    public int h = 1090;
    public int distance = 120;
    boolean Cmove = true;
    BufferedImage colum0 = Tools.getImage("img/green-pipe.png");
    BufferedImage colum1 = Tools.getImage("img/green-pipeD.png");
    public Colum(GameFrame frame) {
        this.frame = frame;
    }


    {
        new Thread() {
            public void run() {
                while (true) {
                    if (Cmove) {
                        x--;
                    }
                    if(x == 110) {
                        frame.count ++;
                    }
                    if(x == -60) {
                        x = 750 + r.nextInt(150) - 75;
                        y=-300-50+r.nextInt(200);
                    }

                    try {
                        Thread.sleep(8);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

        }.start();
    }
}

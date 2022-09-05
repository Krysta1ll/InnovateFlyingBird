package com.example.innovateflyingbird.gaming;
import java.awt.image.BufferedImage;

public class Bround extends Thread {
    int x = 0;
    int y = 529;
    int w = 403;
    int h = 140;
    BufferedImage bround = Tools.getImage("img/floor.png");

    public void run() {

        while(true) {
            x --;
            if(x == -28) {
                x = 0;
            }
            try {
                Thread.sleep(7);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

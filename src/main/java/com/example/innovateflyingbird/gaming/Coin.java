package com.example.innovateflyingbird.gaming;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Coin {
    Random r = new Random();
    // 是否出现
    public boolean flag = true;
    public int x = 500;
    public int y = 320;
    public int w = 40;
    public int h = 30;
    public boolean Cmove = true;
    public List<BufferedImage> coin = new ArrayList<>();
    public String path = System.getProperty("user.dir") + "/src/main/java/com/example/innovateflyingbird/gaming/img/";
    public Coin() {
        for(int i = 0; i < 4; i ++) {
            try {
                coin.add(ImageIO.read(new File(path + "medals-" + i + ".png")));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    {
        new Thread() {
            public void run() {
                while (true) {
                    if (Cmove) {
                        x--;
                    }

                    if(x == -60) {
                        flag = true;
                        x = 720 + r.nextInt(150);
                        y=320-50+r.nextInt(200);
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




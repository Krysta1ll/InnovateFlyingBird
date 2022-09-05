package com.example.innovateflyingbird.gaming;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

public class Score {
    public List<BufferedImage> img = new ArrayList<>();
    public String path = System.getProperty("user.dir") + "/src/main/java/com/example/innovateflyingbird/gaming/img/";

    public Score() {
        for(int i = 0; i < 10; i ++) {
            try {
                img.add(ImageIO.read(new File(path + i + ".png")));

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}

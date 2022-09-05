package com.example.innovateflyingbird.gaming;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Tools {
    public static BufferedImage getImage(String path) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(Tools.class.getResource(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return img;
    }

}


package com.saimonefcs.imager;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String... args) throws IOException {

        new Main().doThat();
    }

    private void doThat() throws IOException {
        File jpegFile = new File(
                getClass().getClassLoader().getResource("in/jpeg.jpeg").getFile()
        );
//        Imager.fromJpeg(jpegFile).blur(BLUR_HEAVY).rotate(ROTATION_CLOCKWISE).shrink().buildBufferedImage();
//        Imager.fromJpeg(jpegFile).blur(BLUR_HEAVY).rotate(ROTATION_CLOCKWISE).shrink().buildFile();
    }
}

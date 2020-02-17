package com.saimonefcs.imager.executer;

import com.saimonefcs.imager.Rotate;

import java.awt.image.BufferedImage;

public class Rotater {
    public static BufferedImage rotate(BufferedImage bufferedImage, Rotate rotate) {
        if (rotate == null) {
            return bufferedImage;
        }

        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();

        BufferedImage newBufferedImage = new BufferedImage(width, height, bufferedImage.getType());

        int newX = width - 1;
        int newY;

        for (int y = 0; y < height; y++) {
            newY = 0;
            for (int x = 0; x < width; x++) {
                newBufferedImage.setRGB(newX, newY, bufferedImage.getRGB(x, y));
                newY++;
            }
            newX--;
        }
        /*
        clock 9x9
        00 80
        10 81
        01 80
        11 88
        88 00
         */

        return newBufferedImage;
    }
}

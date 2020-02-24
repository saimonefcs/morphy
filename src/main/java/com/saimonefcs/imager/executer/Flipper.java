package com.saimonefcs.imager.executer;

import com.saimonefcs.imager.Flip;

import java.awt.image.BufferedImage;

public class Flipper {

    public static BufferedImage flip(BufferedImage bufferedImage, Flip flip) {
        if (flip == null) {
            return bufferedImage;
        }

        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();
        BufferedImage newBufferedImage = null;
        switch (flip) {
            case HORIZONTAL_AXIS:
                newBufferedImage = new BufferedImage(width, height, bufferedImage.getType());
                flipHorizontal(bufferedImage, width, height, newBufferedImage);
                break;
            case VERTICAL_AXIS:
                newBufferedImage = new BufferedImage(width, height, bufferedImage.getType());
                flipVertical(bufferedImage, width, height, newBufferedImage);
                break;
        }
        return newBufferedImage;
    }

    private static void flipHorizontal(BufferedImage bufferedImage, int width, int height, BufferedImage newBufferedImage) {
        int newX;
        int newY = height - 1;

        for (int y = 0; y < height; y++) {
            newX = 0;
            for (int x = 0; x < width; x++) {
                newBufferedImage.setRGB(newX, newY, bufferedImage.getRGB(x, y));
                newX++;
            }
            newY--;
        }
    }

    private static void flipVertical(BufferedImage bufferedImage, int width, int height, BufferedImage newBufferedImage) {
        int newX;
        int newY = 0;

        for (int y = 0; y < height; y++) {
            newX = width - 1;
            for (int x = 0; x < width; x++) {
                newBufferedImage.setRGB(newX, newY, bufferedImage.getRGB(x, y));
                newX--;
            }
            newY++;
        }
    }
}

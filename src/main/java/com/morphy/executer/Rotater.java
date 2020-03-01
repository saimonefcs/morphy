package com.morphy.executer;

import com.morphy.Rotate;

import java.awt.image.BufferedImage;

public class Rotater {
    public static BufferedImage rotate(BufferedImage bufferedImage, Rotate rotate) {
        if (rotate == null) {
            return bufferedImage;
        }

        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();


        BufferedImage newBufferedImage = null;
        switch (rotate) {
            case CLOCKWISE:
                newBufferedImage = new BufferedImage(height, width, bufferedImage.getType());
                rotateClockwise(bufferedImage, width, height, newBufferedImage);
                break;
            case ANTI_CLOCKWISE:
                newBufferedImage = new BufferedImage(height, width, bufferedImage.getType());
                rotateAnticlockwise(bufferedImage, width, height, newBufferedImage);
                break;
            case UPSIDE_DOWN:
                newBufferedImage = new BufferedImage(width, height, bufferedImage.getType());
                rotateUpsideDown(bufferedImage, width, height, newBufferedImage);
                break;
        }

        return newBufferedImage;
    }

    private static void rotateClockwise(BufferedImage bufferedImage, int width, int height, BufferedImage newBufferedImage) {
        int newX = height - 1;
        int newY;

        for (int y = 0; y < height; y++) {
            newY = 0;
            for (int x = 0; x < width; x++) {
                newBufferedImage.setRGB(newX, newY, bufferedImage.getRGB(x, y));
                newY++;
            }
            newX--;
        }
    }

    private static void rotateAnticlockwise(BufferedImage bufferedImage, int width, int height, BufferedImage newBufferedImage) {
        int newX = 0;
        int newY;

        for (int y = 0; y < height; y++) {
            newY = width - 1;
            for (int x = 0; x < width; x++) {
                newBufferedImage.setRGB(newX, newY, bufferedImage.getRGB(x, y));
                newY--;
            }
            newX++;
        }
    }

    private static void rotateUpsideDown(BufferedImage bufferedImage, int width, int height, BufferedImage newBufferedImage) {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                newBufferedImage.setRGB((width - 1) - x, (height - 1) - y, bufferedImage.getRGB(x, y));
            }
        }
    }
}

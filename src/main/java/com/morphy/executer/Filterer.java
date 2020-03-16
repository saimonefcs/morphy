package com.morphy.executer;

import com.morphy.option.Filter;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Filterer {
    public static BufferedImage filter(BufferedImage bufferedImage, Filter filter) {
        if (filter == null) {
            return bufferedImage;
        }

        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();
        BufferedImage newBufferedImage = new BufferedImage(width, height, bufferedImage.getType());

        switch (filter) {
            case NEGATIVE:
                newBufferedImage = negative(bufferedImage, newBufferedImage);
            case GREYSCALE:
                newBufferedImage = greyscale(bufferedImage, newBufferedImage);
            case BLACK_N_WHITE:
                newBufferedImage = blackNWhite(bufferedImage, newBufferedImage);
        }
        return newBufferedImage;
    }

    private static BufferedImage negative(BufferedImage bufferedImage, BufferedImage newBufferedImage) {

        for (int y = 0; y < bufferedImage.getHeight(); y++) {
            for (int x = 0; x < bufferedImage.getWidth(); x++) {
                newBufferedImage.setRGB(x, y, invertColor(new Color(bufferedImage.getRGB(x, y))));
            }
        }
        return newBufferedImage;
    }

    private static BufferedImage greyscale(BufferedImage bufferedImage, BufferedImage newBufferedImage) {

        for (int y = 0; y < bufferedImage.getHeight(); y++) {
            for (int x = 0; x < bufferedImage.getWidth(); x++) {
                newBufferedImage.setRGB(x, y, toGreyscale(new Color(bufferedImage.getRGB(x, y))));
            }
        }
        return newBufferedImage;
    }

    private static BufferedImage blackNWhite(BufferedImage bufferedImage, BufferedImage newBufferedImage) {

        for (int y = 0; y < bufferedImage.getHeight(); y++) {
            for (int x = 0; x < bufferedImage.getWidth(); x++) {
                newBufferedImage.setRGB(x, y, toBlackOrWhite(new Color(bufferedImage.getRGB(x, y))));
            }
        }
        return newBufferedImage;
    }

    private static int invertColor(Color color) {
        int red = color.getRed();
        int green = color.getGreen();
        int blue = color.getBlue();

        Color resultingColor = new Color(255 - red, 255 - green, 255 - blue);

        return resultingColor.getRGB();
    }

    private static int toGreyscale(Color color) {
        int red = color.getRed();
        int green = color.getGreen();
        int blue = color.getBlue();

        int grey = (red + green + blue) / 3;
        Color resultingColor = new Color(grey, grey, grey);

        return resultingColor.getRGB();
    }

    private static int toBlackOrWhite(Color color) {
        int red = color.getRed();
        int green = color.getGreen();
        int blue = color.getBlue();

        Color resultingColor;
        if ((red + green + blue) / 3 <= 124) {
            resultingColor = new Color(0, 0, 0);
        } else {
            resultingColor = new Color(255, 255, 255);
        }

        return resultingColor.getRGB();
    }
}

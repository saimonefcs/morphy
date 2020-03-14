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

    private static int invertColor(Color color) {
        int red = color.getRed();
        int green = color.getGreen();
        int blue = color.getBlue();

        Color resultingColor = new Color(255 - red, 255 - green, 255 - blue);

        return resultingColor.getRGB();
    }
}

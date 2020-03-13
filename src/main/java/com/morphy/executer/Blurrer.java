package com.morphy.executer;

import com.morphy.option.Blur;
import com.morphy.util.ImageUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Blurrer {

    public static BufferedImage blur(BufferedImage bufferedImage, Blur blur) {
        if (blur == null) {
            return bufferedImage;
        }
        int[][] matrix = ImageUtils.imageToMatrix(bufferedImage);
        int[] imageOutPixels = blur(matrix, bufferedImage.getHeight(), bufferedImage.getWidth(), blur.getBrushSize());

        return ImageUtils.fromArrayToImage(bufferedImage, imageOutPixels);
    }

    private static int[] blur(int[][] imageInPixels, int height, int width, int brushSize) {
        int[] imageOutPixels = new int[height * width];

        int c = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                List<Integer> adjacentPixels = getAdjacentPixels(imageInPixels, i, j, brushSize);
                Color averageColor = pixelsColorAverage(adjacentPixels);
                imageOutPixels[c] = averageColor.getRGB();
                c++;
            }
        }
        return imageOutPixels;
    }

    private static Color pixelsColorAverage(List<Integer> adjacentPixels) {

        int red = 0, green = 0, blue = 0, alpha = 0;
        for (Integer adjacentPixel : adjacentPixels) {
            Color tempColor = new Color(adjacentPixel);
            red += tempColor.getRed();
            green += tempColor.getGreen();
            blue += tempColor.getBlue();
            alpha += tempColor.getAlpha();
        }
        red /= adjacentPixels.size();
        green /= adjacentPixels.size();
        blue /= adjacentPixels.size();
        alpha /= adjacentPixels.size();

        return new Color(red, green, blue, alpha);
    }

    private static List<Integer> getAdjacentPixels(int[][] pixels, int x, int y, int brushSize) {
        List<Integer> adjacentPixels = new ArrayList<>();

        for (int i = x - brushSize; i <= x + brushSize; i++) {
            for (int j = y - brushSize; j <= y + brushSize; j++) {
                try {
                    int targetPixel = pixels[i][j];
                    adjacentPixels.add(targetPixel);
                } catch (ArrayIndexOutOfBoundsException ignored) {}
            }
        }

        return adjacentPixels;
    }
}

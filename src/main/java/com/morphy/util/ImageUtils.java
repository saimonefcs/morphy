package com.morphy.util;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageUtils {

    public static BufferedImage openImage(String path) {
        File file = new File(path);
        try {
            return ImageIO.read(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void saveImage(BufferedImage imageOut, String path) {
        File file = new File(path);
        try {
            ImageIO.write(imageOut, "jpg", file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int[] imageToArray(BufferedImage image) {
        return image.getRGB(0, 0, image.getWidth(), image.getHeight(), null, 0, image.getWidth());
    }

    public static BufferedImage fromArrayToImage(BufferedImage imageIn, int[] imageInPixels) {
        BufferedImage imageOut = new BufferedImage(imageIn.getWidth(), imageIn.getHeight(), BufferedImage.TYPE_INT_RGB);
        imageOut.setRGB(0, 0, imageIn.getWidth(), imageIn.getHeight(), imageInPixels, 0, imageIn.getWidth());
        return imageOut;
    }

    public static int[][] imageToMatrix(BufferedImage image) {
        int[] pixels = imageToArray(image);

        int height = image.getHeight();
        int width = image.getWidth();

        int[][] ints = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                ints[i][j] = pixels[i * width + j];
            }
        }

        return ints;
    }
}

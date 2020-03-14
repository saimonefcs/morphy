package com.morphy;

import com.morphy.exception.ImageNotFoundException;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * Image manipulation class.
 * Open-source, fluent, easy to use library.
 *
 * @author andrea morandotti
 */
public class Morphy {

    /**
     * Entry point to start the manipulation.
     * The file must be an image and existing.
     *
     * @param file File to load
     * @return A context to manipulate the image with.
     * @throws ImageNotFoundException If the image doesn't exist
     */
    public static MorphyContext fromFile(File file) {
        BufferedImage bufferedImage;

        try {
            Files.probeContentType(file.toPath());
            bufferedImage = ImageIO.read(file);
        } catch (IOException e) {
            throw new ImageNotFoundException();
        }

        return fromImage(bufferedImage);
    }

    /**
     * Entry point to start the manipulation.
     * The image must not be null.
     *
     * @param bufferedImage The actual image
     * @return A context to manipulate the image with.
     */
    public static MorphyContext fromImage(BufferedImage bufferedImage) {
        if (bufferedImage == null) {
            throw new ImageNotFoundException();
        }

        MorphyContext morphyContext = new MorphyContext();
        morphyContext.setBufferedImage(bufferedImage);
        return morphyContext;
    }

    /**
     * Compares two images
     * If an image is not equal to the other pixel-by-pixel they're not identical
     *
     * @param first First image to compare
     * @param second Second image to compare
     * @return True if the images are identical, false if they're not. Also false if one or both images are null
     */
    public static boolean compareImages(BufferedImage first, BufferedImage second) {
        if (first == null || second == null) {
            return false;
        } else if (first.getHeight() != second.getHeight()) {
            return false;
        } else if (first.getWidth() != second.getWidth()) {
            return false;
        }

        if (first.getWidth() != second.getWidth() || first.getHeight() != second.getHeight()) {
            return false;
        }

        for (int i = 0; i < second.getWidth(); i++) {
            for (int j = 0; j < second.getHeight(); j++) {
                if (first.getRGB(i, j) != second.getRGB(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }
}

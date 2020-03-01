package com.morphy;

import com.morphy.exception.ImageNotFoundException;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Morphy {

    public static MorphyContext fromFile(File file) {

        BufferedImage bufferedImage;
        try {
            Files.probeContentType(file.toPath());
            bufferedImage = ImageIO.read(file);
        } catch (IOException e) {
            throw new ImageNotFoundException();
        }


        MorphyContext morphyContext = new MorphyContext();
        morphyContext.setBufferedImage(bufferedImage);
        return morphyContext;
    }

    public static boolean compareImages(BufferedImage first, BufferedImage second) {
        if (first == null || second == null) {
            return false;
        } else if (first.getHeight() != second.getHeight()) {
            return false;
        } else if (first.getWidth() != second.getWidth()) {
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

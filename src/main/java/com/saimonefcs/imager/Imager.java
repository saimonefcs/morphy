package com.saimonefcs.imager;

import com.saimonefcs.imager.exception.ImageNotFoundException;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;

public class Imager {

    public static ImagerContext fromFile(File file) {

        BufferedImage bufferedImage;
        try {
            Files.probeContentType(file.toPath());
            bufferedImage = ImageIO.read(file);
        } catch (IOException e) {
            throw new ImageNotFoundException();
        }


        ImagerContext imagerContext = new ImagerContext();
        imagerContext.setBufferedImage(bufferedImage);
        return imagerContext;
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

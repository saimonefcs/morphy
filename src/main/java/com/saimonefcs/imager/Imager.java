package com.saimonefcs.imager;

import com.saimonefcs.imager.exception.ImageNotFoundException;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;

public class Imager {

    public static ImagerContext fromJpeg(File file) {

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

}

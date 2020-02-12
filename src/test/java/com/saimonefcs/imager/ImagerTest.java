package com.saimonefcs.imager;

import com.saimonefcs.imager.exception.ImageNotFoundException;
import com.saimonefcs.imager.exception.ImageTypeMismatchException;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ImagerTest {

    @Test
    public void fromJpegThrowsExceptionIfFileDoesNotExist() {
        assertThrows(ImageNotFoundException.class, () -> {
            Imager.fromJpeg(new File("notFoundJpeg.jpg"));
        });
    }

//    @Test
//    public void fromJpegThrowsExceptionIfTheImageIsNotJpeg() {
//        File gifFile = ImagerTestUtils.load("in/gif.gif");
//
//        assertThrows(ImageTypeMismatchException.class, () -> {
//            Imager.fromJpeg(gifFile);
//        });
//    }

    @Test
    public void buildImageReturnsABufferedImage() {
        File file = new File("jpg.jpg");

        BufferedImage actual = Imager.fromJpeg(file).buildImage();

        assertNotNull(actual);
    }
}
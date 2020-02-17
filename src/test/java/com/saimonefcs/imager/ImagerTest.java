package com.saimonefcs.imager;

import com.saimonefcs.imager.exception.ImageNotFoundException;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class ImagerTest {

    @Test
    public void fromFileThrowsExceptionIfFileDoesNotExist() {
        assertThrows(ImageNotFoundException.class, () -> {
            Imager.fromFile(new File("notFoundJpeg.jpg"));
        });
    }

    @Test
    public void compareImagesReturnsTrueIfImagesAreIdentical() throws IOException {
        File file1 = TestUtils.load("in/png.png");
        File file2 = TestUtils.load("in/png.png");
        BufferedImage bufferedImage1 = ImageIO.read(file1);
        BufferedImage bufferedImage2 = ImageIO.read(file2);

        assertTrue(Imager.compareImages(bufferedImage1, bufferedImage2));
    }

    @Test
    public void compareImagesReturnsFalseIfImagesAreNotIdentical() throws IOException {
        File file1 = TestUtils.load("in/png.png");
        File file2 = TestUtils.load("in/gif.gif");
        BufferedImage bufferedImage1 = ImageIO.read(file1);
        BufferedImage bufferedImage2 = ImageIO.read(file2);

        assertFalse(Imager.compareImages(bufferedImage1, bufferedImage2));
    }

    @Test
    public void compareImagesReturnsFalseIfTheFirstImagesIsNull() throws IOException {
        File file = TestUtils.load("in/png.png");
        BufferedImage bufferedImage = ImageIO.read(file);

        assertFalse(Imager.compareImages(null, bufferedImage));
    }

    @Test
    public void compareImagesReturnsFalseIfTheSecondImagesIsNull() throws IOException {
        File file = TestUtils.load("in/png.png");
        BufferedImage bufferedImage = ImageIO.read(file);

        assertFalse(Imager.compareImages(bufferedImage, null));
    }

    @Test
    public void compareImagesReturnsFalseIfBothImagesAreNull() throws IOException {
        assertFalse(Imager.compareImages(null, null));
    }

    @Test
    public void buildImageReturnsABufferedImage() {
        File file = TestUtils.load("in/png.png");

        BufferedImage actual = Imager.fromFile(file).buildImage();

        assertNotNull(actual);
    }

    @Test
    public void rotateCalled1TimeClockwiseReturnsTheExpectedImage() throws IOException {
        File file = new File(getClass().getClassLoader().getResource("in/png.png").getFile());

        BufferedImage actual = Imager.fromFile(file).rotate(Rotate.CLOCKWISE).buildImage();

        File expectedFile = new File(getClass().getClassLoader().getResource("expected/png-rotated-clock.png").getFile());
        BufferedImage expected = ImageIO.read(expectedFile);
        assertTrue(Imager.compareImages(expected, actual));
    }
}

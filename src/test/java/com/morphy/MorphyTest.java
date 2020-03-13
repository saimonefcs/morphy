package com.morphy;

import com.morphy.exception.ImageNotFoundException;
import com.morphy.option.Blur;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class MorphyTest {

    @Test
    public void fromFileThrowsExceptionIfFileDoesNotExist() {
        assertThrows(ImageNotFoundException.class, () -> Morphy.fromFile(new File("notFoundJpeg.jpg")));
    }

    @Test
    public void fromImageThrowsExceptionIfImageIsNull() {
        assertThrows(ImageNotFoundException.class, () -> Morphy.fromImage(null));
    }

    @Test
    public void compareImagesReturnsTrueIfImagesAreIdentical() throws IOException {
        File file1 = TestUtils.loadFile("in/png.png");
        File file2 = TestUtils.loadFile("in/png.png");
        BufferedImage bufferedImage1 = ImageIO.read(file1);
        BufferedImage bufferedImage2 = ImageIO.read(file2);

        assertTrue(Morphy.compareImages(bufferedImage1, bufferedImage2));
    }

    @Test
    public void compareImagesReturnsFalseIfImagesAreNotIdentical() throws IOException {
        File file1 = TestUtils.loadFile("in/png.png");
        File file2 = TestUtils.loadFile("in/gif.gif");
        BufferedImage bufferedImage1 = ImageIO.read(file1);
        BufferedImage bufferedImage2 = ImageIO.read(file2);

        assertFalse(Morphy.compareImages(bufferedImage1, bufferedImage2));
    }

    @Test
    public void compareImagesReturnsFalseIfTheFirstImagesIsNull() throws IOException {
        File file = TestUtils.loadFile("in/png.png");
        BufferedImage bufferedImage = ImageIO.read(file);

        assertFalse(Morphy.compareImages(null, bufferedImage));
    }

    @Test
    public void compareImagesReturnsFalseIfTheSecondImagesIsNull() throws IOException {
        File file = TestUtils.loadFile("in/png.png");
        BufferedImage bufferedImage = ImageIO.read(file);

        assertFalse(Morphy.compareImages(bufferedImage, null));
    }

    @Test
    public void compareImagesReturnsFalseIfBothImagesAreNull() {
        assertFalse(Morphy.compareImages(null, null));
    }

    @Test
    public void buildImageReturnsABufferedImage() {
        File file = TestUtils.loadFile("in/png.png");

        BufferedImage actual = Morphy.fromFile(file).buildImage();

        assertNotNull(actual);
    }

    @Test
    public void rotateNullReturnsTheSame() throws IOException {
        BufferedImage bufferedImage = TestUtils.loadImage("in/png.png");

        BufferedImage actual = Morphy.fromImage(bufferedImage).rotate(null).buildImage();

        File expectedFile = TestUtils.loadFile("in/png.png");
        BufferedImage expected = ImageIO.read(expectedFile);
        assertTrue(TestUtils.compareImages(expected, actual));
    }

    @Test
    public void blurWithoutPassingAnythingReturnsAMediumBlurredImage() throws IOException {
        File file = TestUtils.loadFile("in/png.png");

        BufferedImage actual = Morphy.fromFile(file).blur().buildImage();

        File expectedFile = TestUtils.loadFile("expected/png-blurred-medium.png");
        BufferedImage expected = ImageIO.read(expectedFile);
        assertTrue(TestUtils.compareImages(expected, actual));
    }

    @Test
    public void blurLightlyReturnsALightBlurredImage() throws IOException {
        File file = TestUtils.loadFile("in/png.png");

        BufferedImage actual = Morphy.fromFile(file).blur(Blur.LIGHT).buildImage();

        File expectedFile = TestUtils.loadFile("expected/png-blurred-light.png");
        BufferedImage expected = ImageIO.read(expectedFile);
        assertTrue(TestUtils.compareImages(expected, actual));
    }

    @Test
    public void blurMediumReturnsAMediumBlurredImage() throws IOException {
        File file = TestUtils.loadFile("in/png.png");

        BufferedImage actual = Morphy.fromFile(file).blur(Blur.MEDIUM).buildImage();

        File expectedFile = TestUtils.loadFile("expected/png-blurred-medium.png");
        BufferedImage expected = ImageIO.read(expectedFile);
        assertTrue(TestUtils.compareImages(expected, actual));
    }

    @Test
    public void blurHeavilyReturnsAnHeavyBlurredImage() throws IOException {
        File file = TestUtils.loadFile("in/png.png");

        BufferedImage actual = Morphy.fromFile(file).blur(Blur.HEAVY).buildImage();

        File expectedFile = TestUtils.loadFile("expected/png-blurred-heavy.png");
        BufferedImage expected = ImageIO.read(expectedFile);
        assertTrue(TestUtils.compareImages(expected, actual));
    }

    @Test
    public void flipPassingNullReturnsTheSameImage() {
        BufferedImage bufferedImage = TestUtils.loadImage("in/png.png");

        BufferedImage actual = Morphy.fromImage(bufferedImage).flip(null).buildImage();

        BufferedImage expected = TestUtils.loadImage("in/png.png");
        assertTrue(TestUtils.compareImages(expected, actual));
    }
}

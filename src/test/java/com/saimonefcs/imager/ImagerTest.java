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
        assertThrows(ImageNotFoundException.class, () -> Imager.fromFile(new File("notFoundJpeg.jpg")));
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
    public void compareImagesReturnsFalseIfBothImagesAreNull() {
        assertFalse(Imager.compareImages(null, null));
    }

    @Test
    public void buildImageReturnsABufferedImage() {
        File file = TestUtils.load("in/png.png");

        BufferedImage actual = Imager.fromFile(file).buildImage();

        assertNotNull(actual);
    }

    @Test
    public void rotateClockwiseReturnsTheExpectedImage() throws IOException {
        File file = TestUtils.load("in/png.png");

        BufferedImage actual = Imager.fromFile(file).rotate(Rotate.CLOCKWISE).buildImage();

        File expectedFile = TestUtils.load("expected/png-rotated-clock.png");
        BufferedImage expected = ImageIO.read(expectedFile);
        assertTrue(Imager.compareImages(expected, actual));
    }

    @Test
    public void rotateAnticlockwiseReturnsTheExpectedImage() throws IOException {
        File file = TestUtils.load("in/png.png");

        BufferedImage actual = Imager.fromFile(file).rotate(Rotate.ANTI_CLOCKWISE).buildImage();

        File expectedFile = TestUtils.load("expected/png-rotated-anticlock.png");
        BufferedImage expected = ImageIO.read(expectedFile);
        assertTrue(Imager.compareImages(expected, actual));
    }

    @Test
    public void rotateUpsideDownReturnsTheExpectedImage() throws IOException {
        File file = TestUtils.load("in/png.png");

        BufferedImage actual = Imager.fromFile(file).rotate(Rotate.UPSIDE_DOWN).buildImage();

        File expectedFile = TestUtils.load("expected/png-rotated-upsidedown.png");
        BufferedImage expected = ImageIO.read(expectedFile);
        assertTrue(Imager.compareImages(expected, actual));
    }

    @Test
    public void rotateNullReturnsTheSame() throws IOException {
        File file = TestUtils.load("in/png.png");

        BufferedImage actual = Imager.fromFile(file).rotate(null).buildImage();

        File expectedFile = TestUtils.load("in/png.png");
        BufferedImage expected = ImageIO.read(expectedFile);
        assertTrue(Imager.compareImages(expected, actual));
    }

    @Test
    public void blurWithoutPassingAnythingReturnsAMediumBlurredImage() throws IOException {
        File file = TestUtils.load("in/png.png");

        BufferedImage actual = Imager.fromFile(file).blur().buildImage();

        File expectedFile = TestUtils.load("expected/png-blurred-medium.png");
        BufferedImage expected = ImageIO.read(expectedFile);
        assertTrue(Imager.compareImages(expected, actual));
    }

    @Test
    public void blurLightlyReturnsALightBlurredImage() throws IOException {
        File file = TestUtils.load("in/png.png");

        BufferedImage actual = Imager.fromFile(file).blur(Blur.LIGHT).buildImage();

        File expectedFile = TestUtils.load("expected/png-blurred-light.png");
        BufferedImage expected = ImageIO.read(expectedFile);
        assertTrue(Imager.compareImages(expected, actual));
    }

    @Test
    public void blurMediumReturnsAMediumBlurredImage() throws IOException {
        File file = TestUtils.load("in/png.png");

        BufferedImage actual = Imager.fromFile(file).blur(Blur.MEDIUM).buildImage();

        File expectedFile = TestUtils.load("expected/png-blurred-medium.png");
        BufferedImage expected = ImageIO.read(expectedFile);
        assertTrue(Imager.compareImages(expected, actual));
    }

    @Test
    public void blurHeavilyReturnsAnHeavyBlurredImage() throws IOException {
        File file = TestUtils.load("in/png.png");

        BufferedImage actual = Imager.fromFile(file).blur(Blur.HEAVY).buildImage();

        File expectedFile = TestUtils.load("expected/png-blurred-heavy.png");
        BufferedImage expected = ImageIO.read(expectedFile);
        assertTrue(Imager.compareImages(expected, actual));
    }

    @Test
    public void flipHorizontalReturnsAFlippedImage() throws IOException {
        File file = TestUtils.load("in/png.png");

        BufferedImage actual = Imager.fromFile(file).flip(Flip.HORIZONTAL_AXIS).buildImage();

        File expectedFile = TestUtils.load("expected/png-flipped-horizontal.png");
        BufferedImage expected = ImageIO.read(expectedFile);
        assertTrue(Imager.compareImages(expected, actual));
    }

    @Test
    public void flipVerticalReturnsAFlippedImage() throws IOException {
        File file = TestUtils.load("in/png.png");

        BufferedImage actual = Imager.fromFile(file).flip(Flip.VERTICAL_AXIS).buildImage();

        File expectedFile = TestUtils.load("expected/png-flipped-vertical.png");
        BufferedImage expected = ImageIO.read(expectedFile);
        assertTrue(Imager.compareImages(expected, actual));
    }
}

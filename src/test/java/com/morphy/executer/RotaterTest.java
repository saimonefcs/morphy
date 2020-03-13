package com.morphy.executer;

import com.morphy.Morphy;
import com.morphy.option.Rotate;
import com.morphy.TestUtils;
import org.junit.jupiter.api.Test;

import java.awt.image.BufferedImage;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RotaterTest {

    @Test
    public void rotateClockwiseReturnsTheExpectedImage() throws IOException {
        BufferedImage bufferedImage = TestUtils.loadImage("in/png.png");

        BufferedImage actual = Rotater.rotate(bufferedImage, Rotate.CLOCKWISE);

        BufferedImage expected = TestUtils.loadImage("expected/png-rotated-clock.png");
        assertTrue(Morphy.compareImages(expected, actual));
    }

    @Test
    public void rotateAnticlockwiseReturnsTheExpectedImage() throws IOException {
        BufferedImage bufferedImage = TestUtils.loadImage("in/png.png");

        BufferedImage actual = Rotater.rotate(bufferedImage, Rotate.ANTI_CLOCKWISE);

        BufferedImage expected = TestUtils.loadImage("expected/png-rotated-anticlock.png");
        assertTrue(Morphy.compareImages(expected, actual));
    }

    @Test
    public void rotateUpsideDownReturnsTheExpectedImage() throws IOException {
        BufferedImage bufferedImage = TestUtils.loadImage("in/png.png");

        BufferedImage actual = Rotater.rotate(bufferedImage, Rotate.UPSIDE_DOWN);

        BufferedImage expected = TestUtils.loadImage("expected/png-rotated-upsidedown.png");
        assertTrue(Morphy.compareImages(expected, actual));
    }
}
package com.morphy.executer;

import com.morphy.TestUtils;
import com.morphy.option.Blur;
import org.junit.jupiter.api.Test;

import java.awt.image.BufferedImage;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

class BlurrerTest {

    @Test
    public void blurLightlyReturnsALightBlurredImage() throws IOException {
        BufferedImage bufferedImage = TestUtils.loadImage("in/png.png");

        BufferedImage actual = Blurrer.blur(bufferedImage, Blur.LIGHT);

        BufferedImage expected = TestUtils.loadImage("expected/png-blurred-light.png");
        assertTrue(TestUtils.compareImages(expected, actual));
    }

    @Test
    public void blurMediumReturnsAMediumBlurredImage() throws IOException {
        BufferedImage bufferedImage = TestUtils.loadImage("in/png.png");

        BufferedImage actual = Blurrer.blur(bufferedImage, Blur.MEDIUM);

        BufferedImage expected = TestUtils.loadImage("expected/png-blurred-medium.png");
        assertTrue(TestUtils.compareImages(expected, actual));
    }

    @Test
    public void blurHeavilyReturnsAnHeavyBlurredImage() throws IOException {
        BufferedImage bufferedImage = TestUtils.loadImage("in/png.png");

        BufferedImage actual = Blurrer.blur(bufferedImage, Blur.HEAVY);

        BufferedImage expected = TestUtils.loadImage("expected/png-blurred-heavy.png");
        assertTrue(TestUtils.compareImages(expected, actual));
    }
}

package com.morphy.executer;

import com.morphy.option.Flip;
import com.morphy.Morphy;
import com.morphy.TestUtils;
import org.junit.jupiter.api.Test;

import java.awt.image.BufferedImage;

import static org.junit.jupiter.api.Assertions.assertTrue;

class FlipperTest {

    @Test
    public void flipHorizontalReturnsAFlippedImage() {
        BufferedImage bufferedImage = TestUtils.loadImage("in/png.png");

        BufferedImage actual = Flipper.flip(bufferedImage, Flip.HORIZONTAL_AXIS);

        BufferedImage expected = TestUtils.loadImage("expected/png-flipped-horizontal.png");
        assertTrue(Morphy.compareImages(expected, actual));
    }

    @Test
    public void flipVerticalReturnsAFlippedImage() {
        BufferedImage bufferedImage = TestUtils.loadImage("in/png.png");

        BufferedImage actual = Flipper.flip(bufferedImage, Flip.VERTICAL_AXIS);

        BufferedImage expected = TestUtils.loadImage("expected/png-flipped-vertical.png");
        assertTrue(Morphy.compareImages(expected, actual));
    }

}
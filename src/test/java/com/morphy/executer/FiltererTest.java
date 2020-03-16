package com.morphy.executer;

import com.morphy.TestUtils;
import com.morphy.option.Filter;
import org.junit.jupiter.api.Test;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class FiltererTest {

    @Test
    public void filterPassingNullReturnsTheSameImage() {
        BufferedImage bufferedImage = TestUtils.loadImage("in/png.png");

        BufferedImage actual = Filterer.filter(bufferedImage, null);

        TestUtils.compareImages(bufferedImage, actual);
    }

    @Test
    public void filterNegativeReturnsANegativeImage() {
        BufferedImage bufferedImage = TestUtils.loadImage("in/png.png");

        BufferedImage actual = Filterer.filter(bufferedImage, Filter.NEGATIVE);

        BufferedImage expected = TestUtils.loadImage("expected/png-filter-invert.png");

        TestUtils.compareImages(expected, actual);
    }

    @Test
    public void filterGreyscaleReturnsAnImageOfGrayscale() {
        BufferedImage bufferedImage = TestUtils.loadImage("in/png.png");

        BufferedImage actual = Filterer.filter(bufferedImage, Filter.GREYSCALE);

        BufferedImage expected = TestUtils.loadImage("expected/png-filter-greyscale.png");

        TestUtils.compareImages(expected, actual);
    }

    @Test
    public void filterBlackNWhiteReturnsABlackNWhiteImage() throws IOException {
        BufferedImage bufferedImage = TestUtils.loadImage("in/png.png");

        BufferedImage actual = Filterer.filter(bufferedImage, Filter.BLACK_N_WHITE);

        BufferedImage expected = TestUtils.loadImage("expected/png-filter-black-n-white.png");

        TestUtils.compareImages(expected, actual);
    }
}

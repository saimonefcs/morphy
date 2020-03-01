package com.morphy;

import com.morphy.executer.Rotater;
import com.morphy.executer.Blurrer;
import com.morphy.executer.Flipper;

import java.awt.image.BufferedImage;

public class MorphyContext {
    private BufferedImage bufferedImage;
    private Rotate rotate;
    private Blur blur;
    private Flip flip;

    void setBufferedImage(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
    }

    public BufferedImage buildImage() {
        bufferedImage = Rotater.rotate(bufferedImage, rotate);
        bufferedImage = Blurrer.blur(bufferedImage, blur);
        bufferedImage = Flipper.flip(bufferedImage, flip);
        return bufferedImage;
    }

    public MorphyContext rotate(Rotate rotate) {
        this.rotate = rotate;
        return this;
    }

    public MorphyContext blur() {
        return blur(Blur.MEDIUM);
    }

    public MorphyContext blur(Blur blur) {
        this.blur = blur;
        return this;
    }

    public MorphyContext flip(Flip flip) {
        this.flip = flip;
        return this;
    }
}

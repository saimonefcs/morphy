package com.saimonefcs.imager;

import com.saimonefcs.imager.executer.Blurrer;
import com.saimonefcs.imager.executer.Rotater;

import java.awt.image.BufferedImage;

public class ImagerContext {
    private BufferedImage bufferedImage;
    private Rotate rotate;
    private Blur blur;

    void setBufferedImage(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
    }

    public BufferedImage buildImage() {
        bufferedImage = Rotater.rotate(bufferedImage, rotate);
        bufferedImage = Blurrer.blur(bufferedImage, blur);
        return bufferedImage;
    }

    public ImagerContext rotate(Rotate rotate) {
        this.rotate = rotate;
        return this;
    }

    public ImagerContext blur() {
        return blur(Blur.MEDIUM);
    }

    private ImagerContext blur(Blur blur) {
        this.blur = blur;
        return this;
    }
}

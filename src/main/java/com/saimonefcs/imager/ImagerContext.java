package com.saimonefcs.imager;

import com.saimonefcs.imager.executer.Rotater;

import java.awt.image.BufferedImage;

public class ImagerContext {
    private BufferedImage bufferedImage;
    private Rotate rotate;

    void setBufferedImage(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
    }

    public BufferedImage buildImage() {
        bufferedImage = Rotater.rotate(bufferedImage, rotate);
        return bufferedImage;
    }

    public ImagerContext rotate(Rotate rotate) {
        this.rotate = rotate;
        return this;
    }
}

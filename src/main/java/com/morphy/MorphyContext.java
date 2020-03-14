package com.morphy;

import com.morphy.executer.Rotater;
import com.morphy.executer.Blurrer;
import com.morphy.executer.Flipper;
import com.morphy.option.Blur;
import com.morphy.option.Flip;
import com.morphy.option.Rotate;

import java.awt.image.BufferedImage;

public class MorphyContext {
    private BufferedImage bufferedImage;
    private Rotate rotate;
    private Blur blur;
    private Flip flip;

    void setBufferedImage(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
    }

    /**
     * Processes and builds the image depending on the options set.
     *
     * @return The resulting image.
     */
    public BufferedImage buildImage() {
        bufferedImage = Rotater.rotate(bufferedImage, rotate);
        bufferedImage = Blurrer.blur(bufferedImage, blur);
        bufferedImage = Flipper.flip(bufferedImage, flip);
        return bufferedImage;
    }

    /**
     * Rotates the image.
     * In case of a non-square image, rotating by 90° will result in size change because the width and height will be inverted.
     * No quality loss in the process.
     *
     * @param rotate Rotation direction. Passing null will result in no taken actions.
     * @return The Morphy context to continue building with.
     * @see com.morphy.option.Rotate
     */
    public MorphyContext rotate(Rotate rotate) {
        this.rotate = rotate;
        return this;
    }

    /**
     * Blurs the image with a MEDIUM intensity.
     * Width and height will remain the same.
     * It is recommended to always specify the blur intensity because the default value can change overtime.
     *
     * @return The Morphy context to continue building with.
     * @see com.morphy.option.Blur
     */
    public MorphyContext blur() {
        return blur(Blur.MEDIUM);
    }

    /**
     * Blurs the image with the specified intensity.
     * Width and height will remain the same.
     *
     * @param blur Intensity to blur with. Passing null will result in no taken actions.
     * @return The Morphy context to continue building with.
     * @see com.morphy.option.Blur
     */
    public MorphyContext blur(Blur blur) {
        this.blur = blur;
        return this;
    }

    /**
     * Flips the image.
     * Width and height will remain the same.
     *
     * @param flip Flip axis option. Passing null will result in no taken actions.
     * @return The Morphy context to continue building with.
     */
    public MorphyContext flip(Flip flip) {
        this.flip = flip;
        return this;
    }
}

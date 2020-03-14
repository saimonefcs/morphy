package com.morphy.option;

/**
 * Blur intensity.
 * The bigger the image is the heavier the blur must be to be same visually blurred as a smaller one.
 * See the single enum values for further information.
 */
public enum Blur {
    /**
     * The resulting image will be still recognizable but a little foggy.
     */
    LIGHT(1),
    /**
     * The resulting image will be foggy.
     */
    MEDIUM(5),
    /**
     * The resulting image will be so fogged that text will not be 
     */
    HEAVY(10);

    private int brushSize;

    Blur(int brushSize) {
        this.brushSize = brushSize;
    }

    public int getBrushSize() {
        return brushSize;
    }
}

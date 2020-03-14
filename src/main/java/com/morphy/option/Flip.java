package com.morphy.option;

/**
 * FLip option.
 * The value must be intend as te axis in which the image will be rotated.
 * See the single enum values for further information.
 */
public enum Flip {
    /**
     * Flip the image along the vertical axis.
     * Example: The left side of the image will be in the right side and so the right side will be in the left side.
     */
    VERTICAL_AXIS,
    /**
     * Flip the image along the horizontal axis.
     * Example: The upper-side of the image will be in the down-side and so the down-side will be in the upper-side.
     */
    HORIZONTAL_AXIS
}

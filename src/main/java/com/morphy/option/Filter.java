package com.morphy.option;

/**
 * Filter to apply.
 * See the single enum values for further information.
 */
public enum Filter {
    /**
     * The image is transformed in a greyscale.
     * To be not confused with black and white.
     */
    GREYSCALE,
    /**
     * The image is transformed with negative colors.
     */
    NEGATIVE
}

package model;

import java.awt.*;

/**
 * Contains global constants
 */
abstract public class GlobalConstants {
    /**
     * A variable describing the margin around object
     */
    public static final int MARGIN = 5;
    /**
     * The thickness of border around objects, example the display
     */
    public static final int BORDER_THICKNESS = 5;
    /**
     * If the border around objects should be rounded
     */
    public static final Boolean ROUNDED_BORDER = false;
    /**
     * The font to use
     */
    public static final Font FONT = new Font("Arial", Font.BOLD, 85);
    /**
     * The size of the buttons
     */
    public static final int BUTTON_SIZE = 100;
    /**
     * The color of th keypad, not the buttons
     */
    public static final Color KEYPAD_COLOR = new Color(128,128,128);
    /**
     * The color of borders, example the color of the border around the Jlabel
     */
    public static final Color BORDER_COLOR = Color.BLACK;
    /**
     * The color of a button
     */
    public static final Color BUTTON_COLOR = Color.WHITE;
    /**
     *  The colour if a button is selected
     */
    public static final Color ACTIVE_COLOR = Color.RED;
}

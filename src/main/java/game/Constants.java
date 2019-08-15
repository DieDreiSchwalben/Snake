package game;

import java.awt.*;

public interface Constants {

    public static final Point ORIGIN = new Point(0,20);
    public static final int WINDOW_BAR_HEIGHT = 20;

    public static final int CANVAS_WIDTH = 400; // pixel
    public static final int CANVAS_HEIGHT = 400; // pixel
    public static final int DELAY = 10; // milliseconds

    public static final int COLS = 10; // number of columns
    public static final int ROWS = 10; // number of rows

    public static final int COLUMN_WIDTH = CANVAS_WIDTH / COLS; // width of columns
    public static final int ROW_HEIGHT = CANVAS_HEIGHT / ROWS; // height of rows

    public static final Color BACKGROUND_COLOR = Color.WHITE;
    public static final Color DEFAULT_STROKE_COLOR = Color.BLACK;
    public static final Color DEFAULT_FILLED_COLOR = Color.GREEN;

}

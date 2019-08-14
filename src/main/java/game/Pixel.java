package game;

import java.awt.*;

public class Pixel implements Constants {
    public int x;
    public int y;
    public int width;
    public int height;

    public Color strokeColor = DEFAULT_STROKE_COLOR;
    public Color fillColor = DEFAULT_FILLED_COLOR;

    public Pixel() {
        x = 0;
        y = 0;
        width = COLUMN_WIDTH;
        height = ROW_HEIGHT;
    }

    public Pixel(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = COLUMN_WIDTH;
        this.height = ROW_HEIGHT;
    }

    public void draw(Graphics g) {
        g.setColor(DEFAULT_STROKE_COLOR);
        g.drawRect(x, y, width, height);

        g.setColor(DEFAULT_FILLED_COLOR);
        g.fillRect(x, y, width, height);
    }
}

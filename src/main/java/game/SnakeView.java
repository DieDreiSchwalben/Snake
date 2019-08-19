package game;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SnakeView extends JFrame {

    private static final int WINDOW_BAR_HEIGHT = 20;
    private static final int CANVAS_WIDTH = 400; // pixel
    private static final int CANVAS_HEIGHT = 400; // pixel

    public List<Integer[]> snakeBody = new ArrayList<>();

    private int cols;
    private int rows;
    private int colsWidth;
    private int rowsHeight;

    public SnakeView(int cols, int rows) throws InterruptedException {
        super("Java Frame Example");

        this.cols = cols;
        this.rows = rows;

        this.colsWidth = CANVAS_WIDTH / cols;
        this.rowsHeight = CANVAS_HEIGHT / rows;

        setSize(CANVAS_WIDTH, CANVAS_HEIGHT + WINDOW_BAR_HEIGHT);
        setResizable(false);
    }

    public void paint(Graphics g) {
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                g.setColor(Color.WHITE);
                g.fillRect(colsWidth * i, (rowsHeight * j) + WINDOW_BAR_HEIGHT, colsWidth, rowsHeight);
                g.setColor(Color.BLACK);
                g.drawRect(colsWidth * i, (rowsHeight * j) + WINDOW_BAR_HEIGHT, colsWidth, rowsHeight);
            }
        }


        boolean isHead = true;
        // Draw snake
        // g.setColor(nextColor);
        for (Integer[] part : snakeBody) {
            if(isHead){
                g.setColor(Color.RED);
                isHead = false;
            }else{
                g.setColor(Color.GREEN);
            }
            g.fillRect(part[0]*colsWidth, part[1]*rowsHeight + WINDOW_BAR_HEIGHT, colsWidth, rowsHeight);
        }
    }

    public void refresh(List<Integer[]> snakeBody) {
        this.snakeBody = snakeBody;

        repaint();
    }
}

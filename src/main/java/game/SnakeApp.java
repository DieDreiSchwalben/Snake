package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SnakeApp {

    public static final int DELAY = 10; // milliseconds
    public static final int COLS = 10; // number of columns
    public static final int ROWS = 10; // number of rows

    public static void main(String[] args) throws InterruptedException {
        SnakeView snakeView = new SnakeView(ROWS, COLS);
        SnakeModel snakeModel = new SnakeModel();
        SnakeController snakeController = new SnakeController(snakeView, snakeModel);

        snakeView.refresh();

        snakeView.setVisible(true);

    }
}

package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SnakeGame extends JFrame implements KeyListener {

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

    private Color nextColor = Color.BLACK;

    // Integer[] head = {20,80};
    public List<Integer[]> snakeBody = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        SnakeGame wnd = new SnakeGame();
    }

    public SnakeGame() throws InterruptedException {
        super("Java Frame Example");
        addKeyListener(this);
        setSize(CANVAS_WIDTH, CANVAS_HEIGHT + WINDOW_BAR_HEIGHT);
        setVisible(true);
        setResizable(false);
        gameLoop();
    }

    public void paint(Graphics g) {

        // Draw grit
        for(int i = 0; i < ROWS; i++) {
            for(int j = 0; j < COLS; j++) {
                g.drawRect(COLUMN_WIDTH * i, (ROW_HEIGHT * j) + WINDOW_BAR_HEIGHT, COLUMN_WIDTH, ROW_HEIGHT);
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
            g.fillRect(part[0], part[1] + WINDOW_BAR_HEIGHT, COLUMN_WIDTH, ROW_HEIGHT);
        }
    }

    public void gameLoop() throws InterruptedException {
        int l = 0;
        while(true) {
            TimeUnit.SECONDS.sleep(1);
            l++;
            System.out.println("Loop:" + l);

            // repaint();

        }

    }

    public void keyPressed(KeyEvent event) {

        int keyCode = event.getKeyCode();
        switch( keyCode ) {
            case KeyEvent.VK_UP:
                // handle up
                System.out.println("up");
                break;
            case KeyEvent.VK_DOWN:
                // handle down
                System.out.println("up");
                break;
            case KeyEvent.VK_LEFT:
                // handle left
                System.out.println("up");
                break;
            case KeyEvent.VK_RIGHT :
                // handle right
                System.out.println("up");
                break;
        }


        switch(event.getKeyChar())  {
            case 's':
                nextColor = Color.PINK;

                for(int i = 0; i < 4; i++) {
                    Integer[] bodypart = {COLUMN_WIDTH * i,ROW_HEIGHT * i};
                    snakeBody.add(bodypart);
                }

                break;

            case 'd':
                nextColor = Color.RED;

                for(int i = 3; i < 8; i++) {
                    Integer[] bodypart = {COLUMN_WIDTH * i,ROW_HEIGHT * 3};
                    snakeBody.add(bodypart);
                }
                break;
        }

        repaint();

    }

    public void keyReleased(KeyEvent event) {
    }

    public void keyTyped(KeyEvent event) {
    }
}

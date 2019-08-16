package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SnakeGame extends JFrame implements KeyListener {

    // All constants back in the main class - To be separated to where they belong

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

    boolean foundEgg = false;

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
        Integer[] head = {1, ROWS/2};
        Integer[] body = {0, ROWS/2};
        snakeBody.add(head);
        snakeBody.add(body);
        gameLoop();
    }

    public void paint(Graphics g) {

        setVisible(true);
        // Draw grit
        for(int i = 0; i < ROWS; i++) {
            for(int j = 0; j < COLS; j++) {
                g.setColor(Color.WHITE);
                g.fillRect(COLUMN_WIDTH * i, (ROW_HEIGHT * j) + WINDOW_BAR_HEIGHT, COLUMN_WIDTH, ROW_HEIGHT);
                g.setColor(Color.BLACK);
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
            g.fillRect(part[0]*COLUMN_WIDTH, part[1]*ROW_HEIGHT + WINDOW_BAR_HEIGHT, COLUMN_WIDTH, ROW_HEIGHT);
        }
    }

    public void gameLoop() throws InterruptedException {
        while(true) {
            TimeUnit.MILLISECONDS.sleep(1000);

            System.out.println("Before size=" + snakeBody.size() + " / COL (head) = " +snakeBody.get(0)[0] + " / COL (body) = " + snakeBody.get(1)[0]);

            // Remove tail
            System.out.println("Removing at: " + snakeBody.get(snakeBody.size() - 1)[0]);

            if(foundEgg) {
                snakeBody.remove(snakeBody.size() - 1);
                foundEgg = false;
            }

            System.out.println("New size=" + snakeBody.size() + " - COL (old head -> new body) = " + snakeBody.get(0)[0]);

            // Calculate and add new head
            Integer[] headcut = {0,0};
            headcut[0] = snakeBody.get(0)[0] + 1;
            headcut[1] = snakeBody.get(0)[1];

            // Add calculated head position
            snakeBody.add(0, headcut);
            System.out.println("Added at COL: " + snakeBody.get(1)[0]);

            System.out.println("After size=" + snakeBody.size() + " / COL (head) = " +snakeBody.get(0)[0] + " / COL (body) = " + snakeBody.get(1)[0]);
            repaint();
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
                System.out.println("down");
                break;
            case KeyEvent.VK_LEFT:
                // handle left
                System.out.println("left");
                break;
            case KeyEvent.VK_RIGHT :
                // handle right
                System.out.println("right");
            case KeyEvent.VK_P:
                //handle "pause"
                System.out.println("pause");
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


    }

    public void keyReleased(KeyEvent event) {
    }

    public void keyTyped(KeyEvent event) {
    }
}

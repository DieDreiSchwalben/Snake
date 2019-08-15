package game;

import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SnakeGame extends JFrame implements KeyListener, Constants {

    private Color nextColor = Color.BLACK;

    Integer[] head = {20,80};
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
        for(int i = 0; i < COLS; i++) {
            for(int j = 0; j < COLS; j++) {
                g.drawRect(COLUMN_WIDTH * i, (ROW_HEIGHT * j) + WINDOW_BAR_HEIGHT, COLUMN_WIDTH, ROW_HEIGHT);
            }
        }

        boolean isHead = true;
        // Draw snake
        g.setColor(nextColor);
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
        }
    }

    public void keyPressed(KeyEvent event) {

        switch(event.getKeyChar())  {
            case 'r':
                nextColor = Color.RED;
                break;
            case 'b':
                nextColor = Color.BLUE;
                break;
            case 's':
                nextColor = Color.PINK;

                for(int i = 0; i < 4; i++) {
                    Integer[] bodypart = {40 * i,40 * i};
                    snakeBody.add(bodypart);
                }

                break;

            case 'd':
                nextColor = Color.RED;

                for(int i = 3; i < 8; i++) {
                    Integer[] bodypart = {40 * i,40 * i};
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

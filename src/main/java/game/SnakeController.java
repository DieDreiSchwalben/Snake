package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SnakeController implements KeyListener {

    private SnakeView snakeView;
    private SnakeModel snakeModel;
    public List<Integer[]> snakeBody = new ArrayList<>();
    boolean foundEgg = false;

    public SnakeController(SnakeView snakeView, SnakeModel snakeModel) {
        this.snakeView = snakeView;
        this.snakeModel = snakeModel;

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
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

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

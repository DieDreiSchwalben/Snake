package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Snake extends JFrame implements KeyListener, Constants {

    private DrawCanvas canvas;

    public Snake() {
        canvas = new DrawCanvas();
        canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));

        Container cp = getContentPane();
        cp.add(canvas);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setTitle("game.Snake");
        setVisible(true);

        addKeyListener(this);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Snake();
            }
        });
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

package game;

import javax.swing.*;
import java.awt.*;

public class DrawCanvas extends JPanel implements Constants {

    private Graphics g;

    public DrawCanvas(Graphics g) {
        this.g = g;

        super.paintComponent(g);

        setBackground(Color.WHITE);
        g.setColor(Color.RED); // set the drawing color
        g.drawLine(0,0,40, 40);
    }
    //@Override
    public void paintComponent() {
        super.paintComponent(g);

        setBackground(Color.WHITE);
        g.setColor(Color.RED); // set the drawing color
    }
}

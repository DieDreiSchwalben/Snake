package game;

import javax.swing.*;
import java.awt.*;

public class DrawCanvas extends JPanel {

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);


        setBackground(Color.BLACK);
        g.setColor(Color.YELLOW);    // set the drawing color
        g.drawLine(30, 40, 100, 200);

    }
}
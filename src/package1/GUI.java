package package1;

import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 * Created by tyleranson on 2/15/16.
 */
public class GUI extends JPanel {

    public static void main(String args[]) {
        GUI g = new GUI();
    }

    public GUI() {
        Player s = new Player();
        Asteroid a = new Asteroid();
        JFrame f = new JFrame();
        f.add(s);
        //f.add(a);
        f.setSize(600, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        f.setTitle("ASTROYED!");
    }

}

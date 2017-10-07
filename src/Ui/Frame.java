package Ui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by amirpez on 10/7/17.
 */
public class Frame extends JFrame {
    JFrame frame;

    public Frame() {
        this.frame = new JFrame("University");
        this.frame.setVisible(true);
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.frame.setBackground(new Color(60, 63, 65));
    }
}
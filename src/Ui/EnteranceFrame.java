package Ui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by amirpez on 10/7/17.
 */
public class EnteranceFrame extends Frame {


    public EnteranceFrame() {
        JFrame frame = new JFrame();
        GridLayout gridLayout = new GridLayout();
        JTextField userName = new JTextField();
        JPasswordField password = new JPasswordField();
        JLabel usernameLable = new JLabel("Username");
        JLabel passwordLable = new JLabel("Password");

        this.frame.add(userName);
        this.frame.add(password);
        this.frame.add(usernameLable);
        this.frame.add(passwordLable);

        gridLayout.
    }
}
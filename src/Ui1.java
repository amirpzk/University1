import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by amirpez on 10/7/17.
 */
public class Ui1 extends JFrame {
    JFrame frame = new JFrame();
    Data d1 = new Data();

    public Ui1(){
        frame.setVisible(true);
//        frame.setSize(600,600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        GridLayout gridLayout = new GridLayout(5,2);
        frame.setLayout(gridLayout);
        JTextField username = new JTextField("UserName");
        JPasswordField password = new JPasswordField("PassWord");
        JButton b1 = new JButton("Sign up");
        JButton b2 = new JButton("Sign in");
        frame.add(username);
        frame.add(password);
        frame.add(b1);
        frame.add(b2);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Student s = new Student(username.getText(),password.getText());
                d1.students.add(s);
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ()
            }
        });

    }
}

import javax.swing.*;
import java.awt.*;

/**
 * Created by amirpez on 10/10/17.
 */
public class Ui2 {
    JFrame frame = new JFrame();
    Data d1 = new Data();

    public Ui2(){
        frame.setVisible(true);
        frame.setTitle("AdminPanel");
        frame.setSize(500,700);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        GridLayout gridLayout = new GridLayout(2,3);
        frame.setLayout(gridLayout);
        JTextField courseName = new JTextField ("set Course");
        JButton b1 = new JButton("Set Course");
        frame.add(b1);
        frame.add(courseName);
    }
}

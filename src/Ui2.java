import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Created by amirpez on 10/10/17.
 */
public class Ui2 {
    JFrame frame ;
    JTable table ;
    Data d1 ;

    Object[] cloumns = {"Course" , "Module" };
    DefaultTableModel model = new DefaultTableModel();


    public Ui2(){
        JButton b1 = new JButton("Set Course");
        GridLayout gridLayout = new GridLayout(5,3);
        JTextField courseName = new JTextField ("set Course");
        model.setColumnIdentifiers(cloumns);
        table.setModel(model);
        table.setBackground(Color.lightGray);
        this.d1 = new Data();
        this.table = new JTable();
        this.frame = new JFrame();
        this.frame.setVisible(true);
        this.frame.setTitle("AdminPanel");
        this.frame.setSize(800,700);
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.frame.setLayout(gridLayout);
        this.frame.add(table);
        this.frame.add(b1);
        this.frame.add(courseName);

    }
}

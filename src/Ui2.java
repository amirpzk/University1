import com.sun.tools.javah.Util;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 * Created by amirpez on 10/10/17.
 */
public class Ui2 {
    JFrame frame ;
    JTable table ;
    Data d1 ;

    Object[] columns = {"Course" , "Module" };
    DefaultTableModel model = new DefaultTableModel();
    JScrollPane pane ;



    public Ui2(){
        JButton b1 = new JButton("AddCourse");
        JButton b2 = new JButton("Delete");
        JButton b3 = new JButton("Update");
        JButton b4 = new JButton("EXIT");
        b1.setBounds(150,220,100,25);
        b2.setBounds(150,265,100,25);
        b3.setBounds(150,310,100,25);
        b4.setBounds(750,10,40,20);
//        GridLayout gridLayout = new GridLayout(5,3);
        this.d1 = new Data();
        this.table = new JTable();
        this.frame = new JFrame();
        this.frame.setVisible(true);
        this.frame.setTitle("AdminPanel");
        this.frame.setSize(800,400);
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.frame.setLayout(null);
        this.frame.add(b1);
        this.frame.add(b2);
        this.frame.add(b3);
        this.frame.add(b4);
        this.pane = new JScrollPane(table);
        model.setColumnIdentifiers(columns);
        table.setModel(model);
        table.setBackground(Color.YELLOW);
//        table.setForeground(Color.DARK_GRAY);
//        Font font = new Font("Tahoma",1,22);
        table.setRowHeight(20);
        JTextField courseName = new JTextField ("Course");
        JTextField courseNumber = new JTextField("Module");
        courseName.setBounds(20,220,100,25);
        courseNumber.setBounds(20,265,100,25);
        this.frame.add(courseName);
        this.frame.add(courseNumber);
        this.frame.setResizable(false);
        this.frame.add(table);
        pane.setBounds(0,0,880,200);
        Object[] row = new Object[2];


        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Course c1 = new Course(courseName.getText(),courseNumber.getText());
                d1.courses.add(c1);
                d1.makeCourseList();

                try {
                    FileOutputStream fileOutputStream = new FileOutputStream("Courses.txt");
                    System.out.println("LVL -1");
                    ObjectOutputStream os = new ObjectOutputStream(fileOutputStream);
                    System.out.println("LVL -0-");
                    os.writeObject(d1.courseNameHolder);
                    System.out.println("LVL 1");
//                    os.flush();
                    System.out.println("LVL 2");
                    os.close();
//                    System.out.println("LVL 3");
                    System.out.println("Course stored in text file ...");
                }catch (Exception e1){
                    System.out.println("WE have Problem in storing Courses list in Text file ...");
                }

                row[0]=courseName.getText();
                row[1]=courseNumber.getText();
                model.addRow(row);

            }
        });
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ui1 ui1 = new Ui1();
                frame.dispose();
            }
        });

    }

}

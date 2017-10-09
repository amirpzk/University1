import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * Created by amirpez on 10/7/17.
 */
public class Ui1 extends JFrame implements Serializable {
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
                System.out.println(password.getText());
                d1.students.add(s);
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream("t.ser");
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
//                    s.objectOutputStream = objectOutputStream;
                    objectOutputStream.writeObject(s);
                    objectOutputStream.flush();
//                    objectOutputStream.close();

                    System.out.println("PASS AND USER IS SAVED INTO TEXTFILE");
                } catch (Exception e1){
                    System.out.println("We Have Some Problem in TRY AND CATCH");
                }
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try{
                   ObjectInputStream objectOutputStream = new ObjectInputStream(
                           new FileInputStream("t.ser")
                   );

                    Student s1 = (Student) objectOutputStream.readObject();
                    System.out.println("Read name =" + s1.getName() + "password" + s1.getPassword());
                    if (s1.getName().equalsIgnoreCase(username.getText())&&s1.getPassword().equalsIgnoreCase(password
                    .getText())){
                        System.out.println("SIGNIN SUCCSES");
                    } else {

                    }

                    /**
                     * Admin signIn
                     */

                    if (s1.getName().equalsIgnoreCase("admin")&&
                            s1.getPassword().equalsIgnoreCase(password.getText())){

                    }else {

                    }
                }catch (Exception e1){
                    System.out.println("Problem in readObject ..");

                }


            }
        });

    }
}

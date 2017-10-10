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
        frame.setTitle("University System");
        frame.setSize(600,600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        GridLayout gridLayout = new GridLayout(5,2);
        frame.setLayout(gridLayout);
        JTextField username = new JTextField("UserName");
        JPasswordField password = new JPasswordField("PassWord");
        JButton b1 = new JButton("Sign up");
        JButton b2 = new JButton("Sign in");
        JCheckBox checkBox = new JCheckBox("Is admin");
        frame.add(username);
        frame.add(password);
        frame.add(b1);
        frame.add(b2);
        frame.add(checkBox);




        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // set role to users < ADMIN or STUDENT >
                if (checkBox.isSelected()){
                    System.out.println("choiceBox is Selected and the user have adminAccesses");
                    UsersAndRoles user = new UsersAndRoles(username.getText(),password.getText(),true);
                    d1.usersAndRoles.add(user);
                }else {
                    System.out.println("choiceBox is not selected so user have studentAccesses");
                    UsersAndRoles user = new UsersAndRoles(username.getText(),password.getText(),false);
                    d1.usersAndRoles.add(user);
                }

                UsersAndRoles u1 = d1.usersAndRoles.get(d1.usersAndRoles.size()-1);

                d1.makeLists();

                System.out.println(u1.getName()+u1.getPassword());

                // store object in file
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream("Users1.txt");
//                    System.out.println("PASS AND USER IS SAVED INTO TEXTFILE 9");
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
//                    System.out.println("PASS AND USER IS SAVED INTO TEXTFILE8");
//                    s.objectOutputStream = objectOutputStream;
                    objectOutputStream.writeObject(d1.usernameHolder);
//                    System.out.println("PASS AND USER IS SAVED INTO TEXTFILE7");
                    objectOutputStream.flush();
//                    System.out.println("PASS AND USER IS SAVED INTO TEXTFILE6");
                    objectOutputStream.close();
//                    System.out.println("PASS AND USER IS SAVED INTO TEXTFILE5");
                } catch (Exception e1){
                    System.out.println("We Have Some Problem in TRY AND CATCH");
                }

                // CheckBox //
//                checkBox.addActionListener(new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent e) {
//                        if(checkBox.isSelected()){
//                            System.out.println("CHECKBOX is SELECTED");
//                            // set Admin permission
//
//
//                        }
//                    }
//                });

            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                d1.makeLists();

                // Read Object from file
                try{
                   ObjectInputStream objectOutputStream = new ObjectInputStream(
                           new FileInputStream("Users1.txt")
                   );
                    d1.usernameHolder = (String[]) objectOutputStream.readObject();
                    System.out.println("1");
                    System.out.println("Read name => " + d1.usernameHolder[d1.usernameHolder.length-1] + " password => " +
                           d1.passwordHolder[d1.passwordHolder.length-1] );
                    System.out.println("2");
                    if (d1.searchUserames(username.getText())!=(-1)&&d1.passwordHolder[
                            d1.searchUserames(username.getText())].equals(password.getText())){

                        System.out.println("SIGNIN SUCCSES" + " UserAndPass >> "
                        + d1.passwordHolder[
                                d1.searchUserames(username.getText())] );


                        UsersAndRoles userInSystem = d1.usersAndRoles.get
                                (d1.searchUsernameArrayList(username.getText()));
                        if(userInSystem.isAdmin()==true){
                            Ui2 ui2 = new Ui2();
                            frame.dispose();
                        }

                        objectOutputStream.close();
                    } else {
                        System.out.println("Invalid Username or Password");
                        objectOutputStream.close();
                    }
                }catch (Exception e1){
                    System.out.println("Problem in readObject ..");

                }


            }
        });

    }
}

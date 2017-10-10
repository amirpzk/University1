import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * Created by amirpez on 10/7/17.
 */
public class Ui1 extends JFrame implements Serializable {
    JFrame frame;
    Data d1 ;


    public Ui1(){

        GridLayout gridLayout = new GridLayout(5,2);
        this.frame = new JFrame();
        this.d1 = new Data();
        this.frame.setVisible(true);
        this.frame.setTitle("University System");
        this.frame.setSize(600,600);
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.frame.setLayout(gridLayout);
        JTextField username = new JTextField("UserName");
        JTextField password = new JTextField("PassWord");
        JButton b1 = new JButton("Sign up");
        JButton b2 = new JButton("Sign in");
        JCheckBox checkBox = new JCheckBox("Is admin");
        this.frame.add(username);
        this.frame.add(password);
        this.frame.add(b1);
        this.frame.add(b2);
        this.frame.add(checkBox);
//        this.frame.setResizable(false);




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

                System.out.println(u1.getName()+ "   " +u1.getPassword());

                // store object in file
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream("Users1.txt");
                    FileOutputStream fileOutputStream1 = new FileOutputStream("Passwords1.txt");
                    FileOutputStream fileOutputStream2 = new FileOutputStream("UsersAndRoles.ser");
//                    System.out.println("PASS AND USER IS SAVED INTO TEXTFILE 9");
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                    ObjectOutputStream objectOutputStream1 = new ObjectOutputStream(fileOutputStream1);
                    ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(fileOutputStream2);
//                    System.out.println("PASS AND USER IS SAVED INTO TEXTFILE8");
                    objectOutputStream.writeObject(d1.usernameHolder);
                    System.out.println("PASS AND USER IS SAVED INTO Files");
                    objectOutputStream1.writeObject(d1.passwordHolder);
                    System.out.println("PASS AND USER IS SAVED INTO Files1");
                    objectOutputStream2.writeObject(d1.usersAndRoles);
//                    objectOutputStream.flush();
//                    objectOutputStream1.flush();
//                    System.out.println("PASS AND USER IS SAVED INTO TEXTFILE6");
                    objectOutputStream.close();
                    objectOutputStream1.close();
                    objectOutputStream2.close();
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
                           new FileInputStream("Users1.txt"));

                    ObjectInputStream objectOutputStream1 = new ObjectInputStream(
                            new FileInputStream("Passwords1.txt"));


                    d1.usernameHolder = (String[]) objectOutputStream.readObject();
                    d1.passwordHolder = (String[]) objectOutputStream1.readObject();

                    System.out.println("1");

                    System.out.println("Read name => " + d1.usernameHolder[d1.usernameHolder.length-1]
                            + " password => " +
                           d1.passwordHolder[d1.passwordHolder.length-1] );

                    d1.makeLists();
                    d1.makePasswordList();
                    System.out.println("2   >> " + d1.passwordHolder[2]+"  "+d1.passwordHolder[1]+
                    "  3   >>  "+d1.usernameHolder[1]);


                    if (d1.searchUserames(username.getText())!=(-1)&&d1.passwordHolder[
                            d1.searchUserames(username.getText())].equals(password.getText())){

                        System.out.println("SIGNIN SUCCSES" + " UserAndPass >> "
                        + d1.passwordHolder[
                                d1.searchUserames(username.getText())] );


                        d1.makeLists();
                        d1.makeUsernameList();

                        UsersAndRoles userInSystem = d1.usersAndRoles.get
                                (d1.searchUsernameArrayList(username.getText()));
                        System.out.println("W0o0o0oo0o0o0o0o0o0W >>>" +
                                d1.searchUsernameArrayList(username.getText()));
//                        System.out.println("LVL1");
                        if(userInSystem.isAdmin()==true){
//                            System.out.println("LVL2");
                            Ui2 ui2 = new Ui2();
//                            System.out.println("LVL3");
                            frame.dispose();
//                            System.out.println("LVL4");
                        }
                        objectOutputStream.close();
                        objectOutputStream1.close();
//                        System.out.println("Lvl5");
                    } else {
                        System.out.println("Invalid Username or Password");
                        objectOutputStream.close();
                        objectOutputStream1.close();
                    }
                }catch (Exception e1){
                    System.out.println("Problem in readObject ..");

                }


            }
        });

    }
}

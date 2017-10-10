import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by amirpez on 10/7/17.
 */
public class Main {
 public static void main(String arg[]){
     Data data = new Data();
     Course cTest = new Course("Test","0");
     UsersAndRoles admin = new UsersAndRoles("admin","admin",true);
     data.usersAndRoles.add(admin);
     data.courses.add(cTest);
     data.makeLists();
     try
     {
         FileOutputStream fileOutputStream = new FileOutputStream("Passwords1.txt");
         FileOutputStream fileOutputStream1 = new FileOutputStream("Users1.txt");
         FileOutputStream fileOutputStream2 = new FileOutputStream("courses.txt");
         ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
         ObjectOutputStream objectOutputStream1 = new ObjectOutputStream(fileOutputStream1);
         ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(fileOutputStream2);
         objectOutputStream.writeObject(data.passwordHolder);
         objectOutputStream1.writeObject(data.usernameHolder);
         objectOutputStream2.writeObject(data.courseNameHolder);
//         objectOutputStream.flush();
//         objectOutputStream1.flush();
//         objectOutputStream2.flush();
         objectOutputStream.close();
         objectOutputStream1.close();
         objectOutputStream2.close();
     } catch (Exception e) {
         System.out.println("Problem in Reading From Files is Main class in start Main");
     }

     Ui1 ui1 = new Ui1();

 }
}

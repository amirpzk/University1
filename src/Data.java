import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by amirpez on 10/7/17.
 */
public class Data implements Serializable {
    public static ArrayList<Course> courses = new ArrayList<>();
    public static ArrayList<UsersAndRoles> usersAndRoles = new ArrayList<>();
    public static String[] courseNameHolder = new String[100];
    public static String[] usernameHolder = new String[100];
    public static String[] passwordHolder = new String[100];

    public Data(){

       try {
           FileInputStream fileInputStream = new FileInputStream("Users1.txt");
           System.out.println("DATA 1");
           FileInputStream fileInputStream1 = new FileInputStream("courses.txt");
           System.out.println("data 2");
           FileInputStream fileInputStream2 = new FileInputStream("Passwords1.txt");
           System.out.println("DATA 3");
           FileInputStream fileInputStream3 = new FileInputStream("UsersAndRoles.ser");
           ObjectInputStream os1 = new ObjectInputStream(fileInputStream);
           System.out.println("DATA LVL 1");
           ObjectInputStream os2 = new ObjectInputStream(fileInputStream1);
           System.out.println("DATA LVL 2");
           ObjectInputStream os3 = new ObjectInputStream(fileInputStream2);
           System.out.println("DATA LVL 3");
           ObjectInputStream os4 = new ObjectInputStream(fileInputStream3);
           this.usernameHolder = (String[]) os1.readObject();
           System.out.println("usernameHolder loaded users1.txt");
           this.courseNameHolder = (String[]) os2.readObject();
           System.out.println("CourseHolder loaded courses.txt");
           this.passwordHolder = (String[]) os3.readObject();
           System.out.println("Passwords loaded passwords1.txt");
           this.usersAndRoles = (ArrayList<UsersAndRoles>) os4.readObject();
           System.out.println("UsersAndRolesArrayList IS loaded");
           os1.close();
           os2.close();
           os3.close();
           os4.close();
       } catch (Exception e){
           System.out.println("We Have Problem In reading Files in starting ...");
       }

    }

    public void makeCourseList(){
        System.out.println("courseList");
        for(int i=0;i<courses.size();i++)
        {
            courseNameHolder[i] = courses.get(i).getName();
        }
        System.out.println("CourseList MAKED >>>");
    }

    public void makePasswordList(){
        System.out.println("makePassword");
        for(int i=0;i<usersAndRoles.size();i++)
        {
            this.passwordHolder[i] = usersAndRoles.get(i).getPassword();
        }
        System.out.println("password list maked");
    }

    public void makeUsernameList (){
        System.out.println("make student list");
        for (int i=0;i<usersAndRoles.size();i++)
        {
            this.usernameHolder[i]=usersAndRoles.get(i).getName();
        }
    }

    public int searchUserames(String search)
    {
        System.out.println("searching for student name ...");
        for (int i=0;i<usernameHolder.length;i++)
        {
            System.out.println("hereee " + usernameHolder[i]);
            if (usernameHolder[i].equals(search)){

                return i;
            }
        }
        System.out.println("NO RESULT .......");
        return -1;
    }

    public int searchCourseNameHolder(String search)
    {
        System.out.println("Search is started ...");
        for (int i=0;i<courseNameHolder.length;i++)
        {
            System.out.println("forrrrrr");
            if (courseNameHolder[i] == search)
            {
                System.out.println(i);
                return i;
            }
        }
        System.out.println("Your File is not Found."); return -1;
    }

    public int searchPasswordHolder(String search){
        System.out.println("Search is started ...");
        for (int i=0;i<passwordHolder.length;i++){
            if (passwordHolder[i] == search){
                return i;
            }
        }
        System.out.println("Your File is not Found."); return -1;
    }

    public int searchUsernameArrayList(String username)
    {
        for (int i = 0; i < this.usersAndRoles.size(); i++)
        {
            if (this.usersAndRoles.get(i).getName().equals(username))
            {
                return i;
            }
        }
        System.out.println("This UserName");
        return -1;
    }

    public void makeLists()
    {
        makeUsernameList();
        makeCourseList();
        makePasswordList();
    }
}

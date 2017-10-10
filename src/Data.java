import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by amirpez on 10/7/17.
 */
public class Data {
    public static ArrayList<Course> courses = new ArrayList<>();
    public static ArrayList<UsersAndRoles> usersAndRoles = new ArrayList<>();
    public static String[] courseNameHolder = new String[100];
    public static String[] usernameHolder = new String[100];
    public static String[] passwordHolder = new String[100];

    public void makeCourseList(){
        System.out.println("courseList");
        for(int i=0;i<courses.size();i++){
            courseNameHolder[i] = courses.get(i).getName();
        }
    }

    public void makePasswordList(){
        System.out.println("Password");
        for(int i=0;i<usersAndRoles.size();i++){
            passwordHolder[i] = usersAndRoles.get(i).getPassword();
        }
    }

    public void makeUsernameList (){
        System.out.println("make student list");
        for (int i=0;i<usersAndRoles.size();i++){
            usernameHolder[i]=usersAndRoles.get(i).getName();
        }
    }

    public int searchUserames(String search){
        System.out.println("searching for student name ...");
        for (int i=0;i<usernameHolder.length;i++){
            System.out.println("hereee " + usernameHolder[i]);
            if (usernameHolder[i].equals(search)){
                return i;
            }
        }
        System.out.println("NO RESULT .......");
        return -1;
    }

    public int searchCourseNameHolder(String search){
        System.out.println("Search is started ...");
        for (int i=0;i<courseNameHolder.length;i++){
            System.out.println("forrrrrr");
            if (courseNameHolder[i] == search){
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

    public int searchUsernameArrayList(String username) {
        for (int i = 0; i < this.usersAndRoles.size(); i++) {
            if (this.usersAndRoles.get(i).getName().equals(username)) {
                return i;
            }
        }
        System.out.println("This UserName");
        return -1;
    }

    public void makeLists(){
        makeUsernameList();
        makeCourseList();
        makePasswordList();
    }
}

import java.util.ArrayList;

/**
 * Created by amirpez on 10/7/17.
 */
public class Data {
    public static ArrayList<Course> courses = new ArrayList<>();
    public static String[] nameHolder = new String[100];
    public static ArrayList<UsersAndRoles> usersAndRoles = new ArrayList<>();
    public static String[] studentNameHolder = new String[100];

    public void MakeCourseList(){
        System.out.println("courseList");
        for(int i=0;i<courses.size()-1;i++){
            nameHolder[i] = courses.get(i).getName();
        }
    }

    public int searchNameHolder(String search){
        System.out.println("Search is started ...");
        for (int i=0;i<=nameHolder.length;i++){
            if (nameHolder[i] == search){
                return i;
            }
        }
        System.out.println("Your File is not Found."); return -1;
    }

    public void makeStudentNameList (){
        System.out.println("make student list");
        for (int i=0;i<=usersAndRoles.size()-1;i++){
            studentNameHolder[i]=usersAndRoles.get(i).getName();
        }
    }

    public int searchStudentName(String search){
        System.out.println("searching for student name ...");
        for (int i=0;i<=studentNameHolder.length;i++){
            if (studentNameHolder[i]== search){
                return i;
            }
        }
        System.out.println("NO RESULT .......");
        return -1;
    }
}

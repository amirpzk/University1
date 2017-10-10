import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by amirpez on 10/9/17.
 */
public class UsersAndRoles implements Serializable {


    private String name;
    private String password;
    private String idNumber;
//    private ArrayList<Course> courses;
    private boolean isAdmin;
    static int counter = 0;

    Data d1 = new Data();

    public UsersAndRoles(String name , String password , boolean isAdmin) {
        this.name = name;
        this.password = password;
//        this.courses = new ArrayList<Course>();
        this.isAdmin = isAdmin;

    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public boolean isAdmin(){
        if (isAdmin==true){
            return true;
        }
        return false;
    }

    public void setCourse(String courseName){
        if (isAdmin=true){
            System.out.println("setCourse");
            counter++;
            Course c = new Course(courseName,counter+"");
            d1.courses.add(c);
        } else {
            System.out.println("this role is planed to admin");
        }

    }

    public void deleteCourse(String name){
        if (isAdmin=true){
            System.out.println("DeleteCourse");
            counter--;
            d1.makeCourseList();
            d1.courses.set(d1.searchCourseNameHolder(name),null);
        } else {
            System.out.println("this role is planed to admin");
        }

    }

}

/**
 * Created by amirpez on 10/7/17.
 */
public class Admin {
    private String Username = "Admin";
    private String Password = "Admin";
    static int counter = 0;

    Data d1 = new Data();


    public void setCourse(String courseName){
        System.out.println("setCourse");
        counter++;
        Course c = new Course(courseName,counter+"");
        d1.courses.add(c);
    }

    public void deleteCourse(String name){
        System.out.println("DeleteCourse");
        counter--;
        d1.makeCourseList();
        d1.courses.set(d1.searchCourseNameHolder(name),null);
    }

}

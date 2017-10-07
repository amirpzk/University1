import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by amirpez on 10/7/17.
 */
public class Student {

    private String name;
    private String password;
    private String idNumber;
    private ArrayList<Course> courses;
    private String directHolder;
    private static int counter = 0;



    public Student(String name, String password) {
        this.name = name;
        this.password = password;
        this.idNumber = idNumber;
        this.courses = new ArrayList<>();
        this.counter++;
        this.idNumber = Integer.toString(100000+counter);
        fileCreator();
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private void fileCreator(){
        String filename = "File" + counter + ".txt";
        directHolder = filename;

        try {
            File file = new File("\\Users\\amirpez\\Desktop\\uni\\"+filename);
            file.createNewFile();
            System.out.println("FileCREATED");
        } catch (Exception e){
            System.out.println("CHanchiCHanchi");
        }
    }

}

import java.util.ArrayList;

public class Student
{
    private String name;
    private String id;
    private ArrayList<Course> courses;

    public Student(String name, String id, ArrayList<Course> courses)
    {
        this.name = name;
        this.id = id;
        this.courses = courses;
    }

    public String getName()
    {
        return name;
    }

    
    public String getId()
    {
        return id;
    }

    public ArrayList<Course> getCourses()
    {
        return courses;
    }

}

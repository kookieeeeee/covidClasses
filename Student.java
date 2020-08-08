import java.util.ArrayList;

public class Student
{
    private String name;
    private String id;
    private Course course1;
    private Course course2;
    private Course course3;

    public Student(String name, String id, Course course1, Course course2, Course course3)
    {
        this.name = name;
        this.id = id;
        this.course1 = course1;
        this.course2 = course2;
        this.course3 = course3;
    }

    public String getName()
    {
        return name;
    }

    
    public String getId()
    {
        return id;
    }
    
    public Course getCourse1()
    {
        return course1;
    }

    public Course getCourse2()
    {
        return course2;
    }
    
    public Course getCourse3()
    {
        return course3;
    }
}

import java.util.ArrayList;

public class Course {

    private String courseCode;   
    private boolean needComputer;
    private int tac;            //number of TA per course section
    private int duration;
    private int totalStudentCount;
    private ArrayList<CourseSection> sections;

    public Course(String code, boolean useComputer, int numberOfTA, int duration)
    {
        courseCode = code;
        needComputer = useComputer;
        this.duration = duration;
        tac = numberOfTA;
        totalStudentCount = 0; //default value
        sections = new ArrayList<>(); //default value
    }

    public String getCourseCode()
    {
        return courseCode;
    }

    public boolean needComputer()
    {
        return needComputer;
    }

    public int getNumberOfTA()
    {
        return tac;
    }
    
    public int getDuration()
    {
        return duration;
    }


    public void setTotalStudentCount(int numberOfStudents)
    {
        totalStudentCount = numberOfStudents;
    }
    
    public void removeStudents(int numOfStudents)
    {
        totalStudentCount -= numOfStudents;
    }

    /** 
    * Goes through all student objects and returns number of students in this course.
    * @param	students    Arraylist of all student objects
    * @return               Number of students in this course
    */
    public int updateStudentCount (ArrayList<Student> students)
    {
        int sCount = 0;
        for (int i = 0; i < students.size(); i++)
        {
            Student s = students.get(i);
            ArrayList<Course> allCourses = s.getCourses();
            for (Course c : allCourses)
            {
                if (c.getCourseCode().equalsIgnoreCase(this.courseCode)) sCount ++;
            }
        }
        return sCount;
    }
    
    
}

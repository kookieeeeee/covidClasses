import java.util.TreeMap;

public class Course {

    private String courseCode;   
    private boolean needComputer;
    private int tac;            //number of TA per course section
    private String day;         //ex. "Mon", ..., "Thu", ...
    private int startTime;      //in hours (ex. 14 = "2:00 PM")
    private int endTime;
    private int totalStudentCount;
    private ArrayList<CourseSection> sections;

    public Course(String code, boolean useComputer, int numberOfTA, int startTime, int endTime)
    {
        courseCode = code;
        needComputer = useComputer;
        tac = numberOfTA;
        this.startTime = startTime;
        this.endTime = endTime;
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
            if(s.getCourse1().equals(this.courseCode) || s.getCourse2().equals(this.courseCode) || s.getCourse3().equals(this.courseCode))
            {
                sCount+=1;
            }
        }
        return sCount;
    }
    
    
}

import java.util.TreeMap;

public class Course {

    private String courseCode;   
    private boolean needComputer;
    private int tac;            //number of TA
    private int duration;       //in hours (bc counting minutes is a little cursed)
    private int totalStudentCount;
    //private TreeMap<String, CourseSection> labSections; //to support multiple course sections
                   //Treemap : String (section name? ex. 01, 02) -> CourseSection (course section details)

    public Course(String code, boolean useComputer, int numberOfTA, int labDuration)
    {
        courseCode = code;
        needComputer = useComputer;
        tac = numberOfTA;
        duration = labDuration;
        totalStudentCount = 0; //
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

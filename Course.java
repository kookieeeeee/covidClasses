import java.util.TreeMap;

public class Course {

    private String courseCode;   
    private boolean needComputer;
    private int tac;            //number of TA
    private int duration;       //in hours (bc counting minutes is a little cursed)
    private TreeMap<String, CourseSection> labSections; //to support multiple course sections
                   //Treemap : String (section name? ex. 01, 02) -> CourseSection (course section details)

    public Course(String code, boolean useComputer, int numberOfTA, int labDuration)
    {
        courseCode = code;
        needComputer = useComputer;
        tac = numberOfTA;
        duration = labDuration;
        labSections = new TreeMap<>();
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

}

import java.util.TreeMap;

public class Course {

    private String courseCode;   
    private boolean needComputer;
    private int tac;            //number of TA
    private int duration;       //in minutes (???)
    private TreeMap<String, Classroom> labSections;
    // private String labSection; //not sure if labSection should be in Course
                                //because we can have different lab sections for the same Course

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
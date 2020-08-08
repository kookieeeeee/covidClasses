import java.util.ArrayList;

public class CourseSection extends Course
{
    int sectionNumber; //could be string ex. Section 1 vs "01"
    String day; //days (Mon, Fri)
    int startTime; //hours (0-24)
    int studentCount;
    String roomName;

    public CourseSection(String courseCode, boolean needsComputer, int TAC, int labDuration, int sectionNumber, String day, int startTime)
    {
        super(courseCode, needsComputer, TAC, labDuration); //in Course constructor
        this.sectionNumber = sectionNumber;
        this.day = day;
        this.startTime = startTime;
        this.studentCount = 0; //looking for this value in updateStudentCount function
        this.roomName = ""; //looking for this value in findRoom function
    }

    public int getSectionNumber() //could be string
    {
        return sectionNumber;
    }
    
    public String getDay()
    {
        return day;
    }
    
    public int getStartTime()
    {
        return this.startTime;
    }
    
    public int getStudentCount()
    {
        return this.studentCount;
    }
    
    public String getRoomName()
    {
        return this.roomName;
    }
    
    /** 
    * Finds the end time of the lab section.
    * @return    Lab end time (in hours ex. 14 for 2:00 PM)
    */
    public int getEndTime ()
    {
        return this.getStartTime() + super.getDuration();
    }

    /** 
    * Goes through all student objects and returns number of students in this course section.
    * @param	students    Arraylist of all student objects
    * @return               Number of students in this course
    */
    private int updateStudentCount (ArrayList<Student> students)
    {
        int sCount = 0;
        for (int i = 0; i < students.size(); i++)
        {
         // if student is in this course
            // sCount+=1
        }
        return sCount;
    }

    /** 
    * Goes through all room objects and returns name of valid classroom for this course section.
    * @param	rooms    Arraylist of all room objects
    * @return            Name of valid classroom for this lab
    */
    private String findRoom (ArrayList<Classroom> rooms)
    {
        for (int i = 0; i < rooms.size(); i++)
        {
            if (rooms.get(i).isCompatible(this))
            {
                rooms.get(i).addSection(this);
                return rooms.get(i).getRoomNumber();
            }
        }
        return "";
    }

}

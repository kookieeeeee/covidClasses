import java.util.ArrayList;

public class CourseSection extends Course
{
    int sectionNumber; //could be string ex. Section 1 vs "01"
    int studentCount; //not in constructor
    private String room; //not in constructor
    private int startTime;      //in hours (ex. 14 = "2:00 PM")
    private int endTime;
    private String day;         //ex. "Mon", ..., "Thu", ...

    public CourseSection(Course course, String day, int startTime, int endTime, int sectionNumber)
    {
        super(course.getCourseCode(), course.needComputer(), course.getNumberOfTA(), course.getDuration()); //in Course constructor
        this.startTime = startTime;
        this.endTime = endTime;
        this.sectionNumber = sectionNumber;
        this.studentCount = 0; //default value
        this.room = ""; //default value
    }

    public int getSectionNumber() //could be string
    {
        return sectionNumber;
    }
    
    public int getStudentCount()
    {
        return this.studentCount;
    }
    
    public String getRoomName()
    {
        return this.room;
    }
    public String getDay()
    {
        return day;
    }
    
    public int getStartTime()
    {
        return startTime;
    }
    
    public int getEndTime()
    {
        return endTime;
    }

    public void setRoomName(String roomName)
    {
        this.room = roomName;
    }

    /** 
    * Goes through all room objects and returns name of valid classroom for this course section.
    * @param	rooms    Arraylist of all room objects
    * @return            Name of valid classroom for this lab
    */
    public String findRoom (ArrayList<Classroom> rooms)
    {
        for (int i = 0; i < rooms.size(); i++)
        {
            this.studentCount = rooms.get(i).getMaxOccupancy() - super.getNumberOfTA(); //TEMPORARILY set num of students in section as room max occupancy minus TA count (only need 1 TA for one section)
            if (rooms.get(i).isCompatible(this)) //if it works
            {
                rooms.get(i).addSection(this);
                removeStudents(this.studentCount); //remove students in this course section from course total student count
                this.room.equalsIgnoreCase(rooms.get(i).getRoomNumber());
                return rooms.get(i).getRoomNumber(); //this room is available
            }
        }
        this.studentCount = 0; //no suitable room, this course section should not exist
        return "";
    }

}

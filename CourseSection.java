import java.util.ArrayList;

public class CourseSection extends Course
{
    int sectionNumber; //could be string ex. Section 1 vs "01"
    int studentCount; //not in constructor
    String room; //not in constructor

    public CourseSection(String courseCode, boolean needsComputer, int TAC, String day, int startTime, int endTime, int sectionNumber)
    {
        super(courseCode, needsComputer, TAC, day, startTime, endTime); //in Course constructor
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
        return this.roomName;
    }

    public String setRoomName(String roomName)
    {
        this.roomName = roomName;
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
            this.studentCount = rooms.get(i).getMaxOccupancy() - this.getNumberOfTA(); //TEMPORARILY set num of students in section as room max occupancy minus TA count
            if (rooms.get(i).isCompatible(this)) //if it works
            {
                rooms.get(i).addSection(this);
                super.totalStudentCount-=this.studentCount; //remove students in this course section from course total student count
                return rooms.get(i).getRoomNumber(); //this room is available
            }
        }
        this.studentCount = 0; //no suitable room, this course section should not exist
        return "";
    }

}

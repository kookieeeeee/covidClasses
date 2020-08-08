import java.util.ArrayList;

public class Classroom {
    
    private String roomNum;
    private int length;
    private int width;
    private boolean hasComputer;
    private ArrayList<CourseSection> sectionsInRoom; //keep track of which lab sections are already occupying this room 

    public Classroom(String roomNum, int length, int width, boolean hasComputer)
    {
        this.roomNum = roomNum;
        this.length = length;
        this.width = width;
        this.hasComputer = hasComputer;
        this.sectionsInRoom = new ArrayList<CourseSection>(); //guys is this the syntax??? :(
    }

    public String getRoomNumber()
    {
        return roomNum;
    }

    public boolean hasComputer()
    {
        return hasComputer;
    }

    public void addSection (CourseSection section)
    {
        sectionsInRoom.add(section); //syn t t t ax?
    }
    
    /** 
    * Using length and width, you can find the amount of students to fit in this room.
    * @return       Maximum amount of students/TA's that can fit into this classroom.
    */
    public int getMaxOccupancy()
    {
        return length*width/4;
    }
    
    /** 
    * Goes through all sections occupying this room and compares times with parameters to ensure no overlap.
    * @param	day         
    * @param    startTime   
    * @param    endTime     
    * @return               True if room is occupied at the given day, start time, and end time.
    */
    public boolean isOccupied(String day, int startTime, int endTime)
    {
        for (int i = 0; i < sectionsInRoom.size(); i++) 
        {
            CourseSection sectionToCompare = sectionsInRoom.get(i); //is this the syntax to grab smth from arraylist? :(((
            if (sectionToCompare.getDay().equalsIgnoreCase(day))
            {
                //if (sectionToCompare times overlap with start and end times)
                //{
                    return true; //room IS occupied
                //}
            }
        }
        return false; //no overlap, room is not occupied between start and endtime of given day
    }
    
    /** 
    * Assesses whether or not this classroom can host the given lab (check if resources, maxOccupancy match)
    * @param	labSection   CourseSection object containing information
    * @return                True if classroom can host the lab, False if requirements are not met.
    */
    public boolean isCompatible(CourseSection labSection)
    {
        String day = labSection.getDay();
        int start = labSection.getStartTime();
        int end = labSection.getEndTime();
        
        if (this.isOccupied(day, start, end))
        {
            return false; //this room is in use, therefore not compatible
        }
        if (labSection.getStudentCount() > this.getMaxOccupancy())
        {
            return false; //too many students for classroom, therefore not compatible
        }
        if (labSection.needComputer() == true)
        {
            if (this.hasComputer() == false)
            {
                return false;
            }
        }
        
        //any other missing cases 
            //go here
        
        
        return true; //lab section CAN be hosted in here
    }
    
}

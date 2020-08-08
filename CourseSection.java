public class CourseSection extends Course
{
    int sectionNumber;
    String day; //days (Mon, Fri)
    int startTime; //hours (0-24)
    int studentCount;
    String roomName;

    public class CourseSection(int courseCode, boolean needsComputer, int TAC, int labDuration, int sectionNumber, String day, int startTime)
    {
        super(courseCode, needsComputer, TAC, labDuration); //in Course constructor
        this.sectionNumber = sectionNumber
        this.day = day;
        this.startTime = startTime;
        this.studentCount = 0; //default value upon initialization, will be looking for this value
        this.roomName = ""; //default value upon initialization
    }

    /** 
    * Finds the end time of the lab section.
    * @return    Lab end time (in hours ex. 14 for 2:00 PM)
    */
    private int getEndTime ()
    {
        return this.startTime + super.getDuration();
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
            //if room suits all course needs (time, materials, availability):
                // return rooms.getRoomNumber()
        }
        return "";
    }

}

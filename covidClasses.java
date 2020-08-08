import java.util.TreeMap;
import sun.awt.www.content.audio.basic;

public class covidClasses {

    public Student(String name, String id)
  {
	 this.name = name;
	 this.id   = id;
	 courses   = new ArrayList<Course>();
  }
 
  //get student id
  public String getId()
  {
	  return id;
  }
  
  //get student name
  public String getName()
  {
	  return name;
  }
     
  //instance variables
    private String name;
    private String id;
    private String courseInfo;
    private String courseCode;   
    private boolean materials;
    private int TAC;
    private int roomNum;
    private int length;
    private int width;
    private boolean hasComputer;
    private boolean open;
    
    //student, course and classroom objects
    Student student = new Student(name, id, courseInfo);
    Course course = new Course(courseCode, labSection, materials, TAC, duration);
    Classroom class = new Classroom(roomNum, length, width, hasComputer);


    //course method constructor (it will be in seperate file possible called CovidCourse)
    public Course(String coursecode, String labSection, boolean materials, int TAC, int duration)
    {
 
        this.coursecode;
        this.labSection;
        this.materials;
        this.TAC;
        this.duration;

         public String getSemester()
        {
	        return semester;
        }       

        public String getLectureDay()
        {
            return lectureDay;
        }

        public int getLectureDuration()
        {
            return lectureDuration;
        }
   
        public int getLectureStart()
        {
            return lectureStart;
        }    

        public String findRoom()
        {
            return roomNum;
        }


    }


    public Classroom(String roomNum, int length, int width, boolean hasComputer)
    {
        //classroom method constructor
        public boolean isAvailable()
        {
            //returns true if the class is available by looping through course list and finding what course is taking place at that time 
            //if course is being taken in that room at the same time 
            return false;
            
        }

        public int getmaxOccupancy()
        {
            //using length and width, you can find the amount of students to fit in this room
            return length * width / 4 ;
        }

        public boolean compatable(Course c)
        {
            //returns if the room is compatable with the course
            return true;
        }



    }
    

      

}
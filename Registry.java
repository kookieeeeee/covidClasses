import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Exception;
import java.io.File;
import java.io.IOException;

public class Registry {
    private static ArrayList<Student> students;
    private static ArrayList<Course> courses;
    private static ArrayList<Classroom> rooms;
    public static void main(String[] args) throws IOException{
        students = new ArrayList<Student>();
        courses = new ArrayList<Course>();
        rooms = new ArrayList<Classroom>();
        //read courses file
        try {
            Scanner scanner = new Scanner(new File("courses.txt"));
            while (scanner.hasNextLine())
            {
                String line = scanner.nextLine();
                Scanner sc = new Scanner(line);
                String code = sc.next(); //class code eg. cps209
                String sign = sc.next(); //for yes or no
                boolean needComp = false;
                if (sign.equalsIgnoreCase("yes"))
                {
                    needComp = true;
                }
                int tac = sc.nextInt();
                int duration = sc.nextInt();
                courses.add(new Course(code, needComp, tac, duration));
                sc.close();
                
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        //read students file
        try {
            Scanner scanner = new Scanner(new File("studentInfo.txt"));
            while (scanner.hasNextLine())
            {
                String newline = scanner.nextLine();
                Scanner sc = new Scanner(newline);
                String name = sc.next();
                String id = sc.next();
                ArrayList<Course> takenCourses = new ArrayList<Course>();
                for (int i = 1; i <= 3; i++)
                {
                    String code = sc.next();
                    for (Course c: courses)
                    {
                        if (code.equalsIgnoreCase(c.getCourseCode()))
                        {
                            takenCourses.add(c);
                        }
                    }
                }
                
                students.add(new Student(name, id, takenCourses)); 
                sc.close();
            }
        } catch (Exception e) {
            System.out.println("studentInfo.txt: "+ "File Not Found Exception");        
        }
        

    try {
        Scanner scanner = new Scanner(new File("rooms.txt"));
        while (scanner.hasNextLine())
        {
            String line = scanner.nextLine();
            Scanner sc = new Scanner(line);
            String classroom = sc.next();
            int length = sc.nextInt();
            int width = sc.nextInt();
            String sign = sc.next(); //for yes or no
            boolean needComp = false;
        
            if (sign.equalsIgnoreCase("yes"))
                {
                    needComp = true;
                }
            rooms.add(new Classroom(classroom, length, width, needComp)); 
            sc.close();
        }

    } 
    catch (Exception e) {
        System.out.println("rooms.txt: "+ "File Not Found Exception");        
    }

    for(Course c: courses)
    {
        c.updateStudentCount(students);
    }
    ArrayList<String> days = new ArrayList<String>();
    days.add("Mon");
    days.add("Tue");
    days.add("Wed");
    days.add("Thu");
    days.add("Fri");
    for (Course c: courses)
    {
        int secNum = 1;
        countingloop: while(c.getTotalStudentCount() > 0)
        {
            dayloop: for (String day: days)
            {
                for (int hour = 800; hour <= 1800 - c.getDuration(); hour += 100)
                {
                    CourseSection cSection = new CourseSection(c, day, hour, hour + c.getDuration(), secNum);
                    String roomNum = cSection.findRoom(rooms);
                    System.out.println(roomNum);
                    System.out.println(hour);
                    if (!roomNum.equalsIgnoreCase(""))
                    {
                        secNum++;
                        addSectionToRoom(cSection, roomNum);
                        c.addSection(cSection);
                        continue countingloop;
                    }

                }
                

            }
        }
    }
}

    public static void addSectionToRoom(CourseSection s, String roomNum)
    {
        for (Classroom room: rooms)
        {
            if (roomNum.equalsIgnoreCase(room.getRoomNumber()))
            {
                room.addSection(s);
            }
        }
    }
}


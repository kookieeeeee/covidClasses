import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.lang.Exception;
import java.io.File;
import java.io.IOException;

public class Registry {
    public static void main(String[] args) throws IOException{
        ArrayList<Student> students = new ArrayList<Student>();
        ArrayList<Course> courses = new ArrayList<Course>();
        ArrayList<Classroom> rooms = new ArrayList<Classroom>();
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
                        if (code.equalsIgnoreCase(c.getCourseCode()) && isStringOnlyAlpha(code) == true) takenCourses.add(c);
                    }
                }
                if (isNumeric(id) && isStringOnlyAlpha(name))
                {
                students.add(new Student(name, id, takenCourses)); 
                }
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
        System.out.println("studentInfo.txt: "+ "File Not Found Exception");        
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
        for (String day: days)
        {
            for (int hour = 800; hour <= 1800 - c.getDuration(); hour += 100)
            {
                while(this.totalStudentCount > 0)
                {
                    CourseSection cSection = new CourseSection(c, day, hour, hour + c.getDuration(), secNum);
                    cSection.findroom(rooms);
                    secNum ++;
                }
                

            }
        }
        
    }
}
    public static boolean isStringOnlyAlpha(String str) 
    { 
        for (int i = 0; i < str.length(); i = i + 1)
        {
            if ((Character.isLetter(str.charAt(i))== false))
            {
                System.out.println("Invalid characters in Name " + str);
                return false;
            }
        }
        return true;
    } 

    public static boolean isNumeric(String str)
    { 
      if (str.length() != 5)
      {
          System.out.println("ID: " + str + " must be 5 numbers long" );
          return false;
      } 
      for (int i = 0; i < str.length(); i = i + 1)
      {
          if ((Character.isDigit(str.charAt(i)) == false))
          {
              
              System.out.println("Invalid characters in ID " + str);
              return false;
          }
      }
        return true;
    }
}

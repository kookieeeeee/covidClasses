import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Exception;
import java.io.File;
import java.io.IOException;

public class Registry {
    public static void main(String[] args) throws IOException{
        ArrayList<Student> students = new ArrayList<Student>();
        ArrayList<Course> courses = new ArrayList<Course>();
        //read courses file
        try {
            Scanner scanner = new Scanner(new File("courses.txt"));
            while (scanner.hasNextLine())
            {
                String line = scanner.nextLine();
                Scanner sc = new Scanner(line);
                String code = sc.next();
                boolean needComp = false;
                if (sc.next().equalsIgnoreCase("yes"))
                {
                    needComp = true;
                }
                int tac = sc.nextInt();
                int duration = sc.nextInt();
                courses.add(new Course(code, needComp, tac, duration));

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
                        if (code.equalsIgnoreCase(c.getCourseCode())) takenCourses.add(c);
                    }
                }
                students.add(new Student(name, id, takenCourses));
                /**
                Student s = registrynew.nextStudent(newline);
                if(!s.equals(new Student("","", "", "", "")))
                   {
                       students.add(s.getId(), s.getName(), s.getCourse1(), s.getCourse2(), s.getCourse3());
                   } 
                   **/  
            }
        } catch (Exception e) {
            System.out.println("studentInfo.txt: "+ "File Not Found Exception");        }


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

    public Student nextStudent(String line) throws IOException
    {
        
     Scanner line2 = new Scanner(line);
     if (line2.hasNext())
     {
     String name = line2.next();
     if (!line2.hasNext()) 
     {
         line2.close();
         throw new IOException();  
     }
     if(line2.hasNext())
     {
     String id = line2.next();
     }
     if (line2.hasNext())
     {
         String course1 = line2.next();
     }
 
     if (line2.hasNext())
     {
         String course2 = line2.next();
     }
 
     if (line2.hasNext())
     {
         String course3 = line2.next();
     }
 
     if (isStringOnlyAlpha(name) && isNumeric(id))
         {
             line2.close();
             return new Student(name, id, course1, course2, course3);
         }
     else {
             line2.close();
             return new Student("", "", "", "", ""); 
         }
 
     }
 
     line2.close();
     return new Student("", "", "", "", "");
    }


}

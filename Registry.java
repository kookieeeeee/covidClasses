import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Exception;
import java.io.File;

public class Registry {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File("studentInfo.txt"));
            while (scanner.hasNextLine())
            {
                String line = scanner.nextLine();
                Scanner sc = new Scanner(line);
                String name = sc.next();
                String id = sc.next();
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
        }


    }
}
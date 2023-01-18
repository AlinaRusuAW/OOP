import model.Employee;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args){
        // read file
        String filePath = "src/resources/employee.txt";
        List<Employee> employee = readFile(filePath);
    }

    public static List<Employee> readFile(String filePath){
        List<Employee> employee = new Employee();
        File file = new File(filePath);
        FileInputStream fileInputStream = null;
        try{
            fileInputStream = new FileInputStream(file);
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
            Scanner scanner = new Scanner(fileInputStream);
            while (scanner.hasNext()){
                String line = scanner.nextLine ();
                String[] lineSplit = line.split ("\\|");
                ((Employee) employee).setId(Long.valueOf(lineSplit[0]));
                ((Employee) employee).setName(lineSplit[1]);
                ((Employee) employee).setPrenume(lineSplit[2]);
                ((Employee) employee).setSalariu(Long.valueOf(lineSplit[4]));
                System.out.println(employee);
            }
        return employee;
    }
}
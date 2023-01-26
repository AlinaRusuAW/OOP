import model.Employee;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args){
        String filePath = "src/resources/employee.txt";
        List<Employee> employee = readFile(filePath); //read file
        displayEmployee(employee);
        System.out.println("-----------sort-employee------------");
        sortEmployee(employee);
        System.out.println("---------calculate-sum-of-employee---------");
        sumEmployee(employee);
        System.out.println("-------update-salary-------");
        upSalaryEmployeeById(employee);
        System.out.println("--------details-employee-after-ID-----");
        idEmployee(employee);
    }
    private static void idEmployee(List<Employee> employee) {
        Scanner scanner = new Scanner(System.in);
        Long nume;
        System.out.println("Introduceti Id angajat ");
        nume = scanner.nextLong();
        List<Employee> newEmployee = employee.stream()
                .filter(e -> e.getId() == nume)
                .map(e -> e).collect(Collectors.toList());
        newEmployee.forEach(System.out::println);
    }
    /*Metoda care afiseaza detalii despre angajat dupa ce introducem de la tastiera Id-ul angajatului.
      P.S. dupa cum era in task trebuia sa introducem numele angajatului,
       dar asa posibilitate nu am reusit sa realizezi.*/
    private static void upSalaryEmployeeById(List<Employee> employee) {
        Scanner scanner = new Scanner(System.in);
        Long num, num2;
        System.out.println("Introduceti Id Employee: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Error, introduceti o valoare numerica: ");
            scanner.next();
        }
        num = scanner.nextLong();
            if (num <= employee.size()) {
                System.out.println("Introduceti salariu nou: ");
                num2 = scanner.nextLong();
                Long finalNum = num2;
                List<Employee> newEmployee = employee.stream().
                        filter(e -> e.getId() == num)
                        .map(e ->
                        {
                            e.setSalariu(finalNum);
                            return e;
                        }).collect(Collectors.toList());
                newEmployee.forEach(System.out::println);
                System.out.println("Salariu a fost actualizat");
            } else System.out.println("Angajat cu asa ID nu exista");
    }
        /*Metoda care actualizeaza salariului pentru angajatul Id-ului care il introducem de la tastiera.*/
    private static void sumEmployee(List<Employee> employee) {
        long total = employee.stream().collect(Collectors.summingLong(Employee::getSalariu));
        System.out.println("Suma totala de bani a tuturor angajatilor: " + total);
        System.out.println("----------calculate-procentage-----------");
        Scanner scanner = new Scanner(System.in);
        long num;
        System.out.println("Introduceti Id-ul angajatului pentru a afla procentul din suma totala: ");
        num = scanner.nextLong();
        List<Employee> employeeList = employee.stream().
                filter(e -> e.getId() == num)
                .map(e ->
                {
                    e.setSalariu(e.getSalariu()*100/total);
                    return e;
                }).collect(Collectors.toList());
        employeeList.forEach(System.out::print);
        System.out.println(" %");

    }
        /*Metoda care calculeaza salaru total al tuturor angajatilor. si procentul angajatului din suma totala.*/
    private static void sortEmployee(List<Employee> employee) {
        Collections.sort(employee, Comparator.comparing(Employee::getName));
        employee.stream().forEach(System.out::println);
    }
    /*Metoda care sorteaza angajati dupa nume.*/
    private static void displayEmployee(List<Employee> employee) {
        employee.forEach(System.out::println);
    }
    /*Metoda care afiseaza lista angajatilor.*/
    private static List<Employee> readFile(String filePath) {
        //Employee employee = new Employee();
        List<Employee> employeeList = new ArrayList<Employee>();
        File file = new File(filePath);
        FileInputStream fileInputStream = null;
        try{
            fileInputStream = new FileInputStream(file);
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        Scanner scanner = new Scanner(fileInputStream);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            Employee employee = new Employee();
            String[] lineSplit = line.split("\\|");
            employee.setId(Long.valueOf(lineSplit[0]));
            employee.setName(lineSplit[1]);
            employee.setPrenume(lineSplit[2]);
            employee.setPosition_id(Long.valueOf(lineSplit[3]));
            employee.setSalariu(Long.valueOf(lineSplit[4]));
            employeeList.add(employee);
        }
        return employeeList;
    }
    /*Metoda care citeste datele din fisier.*/
}
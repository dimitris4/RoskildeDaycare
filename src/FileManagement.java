import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileManagement {

    public ArrayList<Object> readFromFiles() {

        ArrayList<Object> objectList = new ArrayList<>();
        // needs to return an ArrayList of Objects in the CORRECT order (very important)
        // 0 : ArrayList of Admin users
        // 1 : ArrayList of Employees
        // 2 : ArrayList of Workschedules
        // 3 : ArrayList of Children
        // 4 : ArrayList of Parents
        // 5 : ArrayList of Integers (personID's telephoneList)
        // 6 : ArrayList of Integers (childID's for waitingList)

        //Scanners for each file
        Scanner admins = new Scanner("");
        Scanner employees = new Scanner("");
        Scanner workschedules = new Scanner("");
        Scanner children = new Scanner("");
        Scanner parents = new Scanner("");
        Scanner telephoneList = new Scanner("");
        Scanner waitingList = new Scanner("");

        //read all files and throw exception
        try {
            admins = new Scanner(new File(""));
            employees = new Scanner(new File(""));
            workschedules = new Scanner(new File(""));
            children = new Scanner(new File(""));
            parents = new Scanner(new File(""));
            telephoneList = new Scanner(new File(""));
            waitingList = new Scanner(new File(""));

        } catch (FileNotFoundException e) {
            System.out.println("** Files not found **");
        }

        return objectList;
    }

    public void writeToFiles(ArrayList<Object> objectList) {

        // 0 : Admin user
        // 1 : ArrayList of Employees
        // 2 : ArrayList of Workschedules
        // 3 : ArrayList of Children
        // 4 : ArrayList of Parents
        // 5 : ArrayList of Integers
        // 6 : ArrayList of Integers

        Admin admin = (Admin) objectList.get(0);
        ArrayList<Employee> employees = (ArrayList<Employee>) objectList.get(1);
        ArrayList<WorkSchedule> workSchedules = (ArrayList<WorkSchedule>) objectList.get(2);
        ArrayList<Child> children = (ArrayList<Child>) objectList.get(3);
        ArrayList<Parent> parents = (ArrayList<Parent>) objectList.get(4);
        ArrayList<Integer> telephoneList = (ArrayList<Integer>) objectList.get(5);
        ArrayList<Integer> waitingList = (ArrayList<Integer>) objectList.get(6);

    }
}

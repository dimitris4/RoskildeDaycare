import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class FileManagement {

    public ArrayList<Object> readFromFiles() {

        ArrayList<Object> objectList = new ArrayList<>();
        // needs to return an ArrayList of Objects in the CORRECT order (very important)
        // 0 : ArrayList of Admins
        // 1 : ArrayList of Employees
        // 2 : ArrayList of Workschedules
        // 3 : ArrayList of Children
        // 4 : ArrayList of Parents
        // 5 : Integer for People count

        //Scanners for each file
        Scanner admins = new Scanner("");
        Scanner employees = new Scanner("");
        Scanner workschedules = new Scanner("");
        Scanner children = new Scanner("");
        Scanner parents = new Scanner("");
        Scanner telephoneList = new Scanner("");
        Scanner waitingList = new Scanner("");
        Scanner peopleCount = new Scanner("");

        //read all files and throw exception
        try {
            admins = new Scanner(new File("/Users/teodorjonasson/Desktop/RoskildeDaycare/admins.txt"));
            employees = new Scanner(new File(""));
            workschedules = new Scanner(new File(""));
            children = new Scanner(new File(""));
            parents = new Scanner(new File(""));
            telephoneList = new Scanner(new File(""));
            waitingList = new Scanner(new File(""));
            peopleCount = new Scanner("");
        } catch (FileNotFoundException e) {
            System.out.println("** Files not found **");
        }

        return objectList;
    }

    public void writeToFiles(ArrayList<Object> objectList) throws FileNotFoundException {

        PrintStream adm = new PrintStream("/Users/teodorjonasson/Desktop/RoskildeDaycare/admins.txt");
        PrintStream emp = new PrintStream("/Users/teodorjonasson/Desktop/RoskildeDaycare/employees.txt");
        PrintStream work = new PrintStream("/Users/teodorjonasson/Desktop/RoskildeDaycare/workSchedules.txt");
        PrintStream ch = new PrintStream("/Users/teodorjonasson/Desktop/RoskildeDaycare/children.txt");
        PrintStream pa = new PrintStream("/Users/teodorjonasson/Desktop/RoskildeDaycare/parents.txt");
        PrintStream counts = new PrintStream("/Users/teodorjonasson/Desktop/RoskildeDaycare/peopleCount.txt");

        // 0 : ArrayList of Admins
        // 1 : ArrayList of Employees
        // 2 : ArrayList of Workschedules
        // 3 : ArrayList of Children
        // 4 : ArrayList of Parents
        // 5 : Integer array for People count

        ArrayList<Admin> admins = (ArrayList<Admin>) objectList.get(0);
        ArrayList<Employee> employees = (ArrayList<Employee>) objectList.get(1);
        ArrayList<WorkSchedule> workSchedules = (ArrayList<WorkSchedule>) objectList.get(2);
        ArrayList<Child> children = (ArrayList<Child>) objectList.get(3);
        ArrayList<Parent> parents = (ArrayList<Parent>) objectList.get(4);
        int[] peopleCount = (int[]) objectList.get(5);

        for (Admin admin : admins ) {
            adm.println( admin.toStringFile() );
        }
        for (Employee employee : employees ) {
            emp.println( employee.toStringFile() );
        }
        for (WorkSchedule workSchedule : workSchedules ) {
            work.println( workSchedule.toStringFile() );
        }
        for (Child child : children ) {
            ch.println( child.toStringFile() );
        }
        for (Parent parent : parents ) {
            pa.println( parent.toStringFile() );
        }
        for (int i = 0; i < 3; i++ ) {
            counts.println( peopleCount.get(i) );
        }

    }

    public ArrayList<WorkSchedule> readWorkSchedulesFromFile() throws FileNotFoundException, ParseException {
        ArrayList<WorkSchedule> workSchedules = new ArrayList<WorkSchedule>();
        Scanner input = new Scanner(new File("workSchedules.txt"));
        while (input.hasNextLine()) {
            WorkSchedule workSchedule = new WorkSchedule();
            String line = input.nextLine();
            Scanner data = new Scanner(line);
            workSchedule.setEmployeeID(data.nextInt());
            ArrayList<Shift> shifts = new ArrayList<Shift>();
            while (data.hasNext()) {
                Shift shift = new Shift();
                String startingTime = "";
                for (int i = 0; i < 2; i++) {
                    startingTime += data.next();
                }
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                shift.setStartingTime(sdf.parse(startingTime));
                String endingTime = "";
                for (int i = 0; i < 2; i++) {
                     endingTime += data.next();
                }
                shift.setEndingTime(sdf.parse(endingTime));
                shifts.add(shift);
            }
            workSchedule.setShifts(shifts);
            workSchedules.add(workSchedule);
        }
        return workSchedules;
    }
}

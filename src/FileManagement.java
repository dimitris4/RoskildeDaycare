import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class FileManagement {

    public FileManagement() { }

    public ArrayList<Admin> readAdminsFromFile() {
        Scanner input = null;
        try {
            input = new Scanner(new File("admins.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
        ArrayList<Admin> admins = new ArrayList<Admin>();
        while (input.hasNextLine()) {
            String line = input.nextLine();
            System.out.println(line);
            Scanner data = new Scanner(line);
            Admin admin = new Admin();
            while (data.hasNext()) {
                admin.setAdminID(Integer.parseInt(data.next()));
                admin.setEmployeeID(Integer.parseInt(data.next()));
                admin.setWorkSchedule(Integer.parseInt(data.next()));
                admin.setUsername(data.next());
                admin.setPassword(data.next());
                admin.setAccessLevel(Integer.parseInt(data.next()));
                admin.setPersonID(Integer.parseInt(data.next()));
                admin.setFirstName(data.next());
                admin.setLastName(data.next());
                admin.setTelephone(data.next());
            }
            admins.add(admin);
            data.close();
        }
        return admins;
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


/*
    public ArrayList<Employee> readEmployeesFromFile() {
    }

    public ArrayList<Child> readChildrenFromFile() {
    }

    public ArrayList<Parent> readParentsFromFile() {
    }   */
}

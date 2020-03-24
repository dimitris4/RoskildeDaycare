import java.util.ArrayList;
import java.util.Date;

public class WorkSchedule {
    private static int workScheduleIDCounter = 0; // auto-increment ID
    private int workScheduleID;
    private int employeeID;
    private ArrayList<Shift> shifts;

    // constructor
    public WorkSchedule() {
        this.workScheduleID = workScheduleIDCounter++;
    }

    public int getWorkScheduleID() {
        return workScheduleID;
    }

    public void setWorkScheduleID(int workScheduleID) {
        this.workScheduleID = workScheduleID;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public ArrayList<Shift> getShifts() {
        return shifts;
    }

    public void setShifts(ArrayList<Shift> shifts) {
        this.shifts = shifts;
    }

    @Override
    public String toString() {
        return workScheduleID + " " + employeeID;
    }

    public void displayWorkScheduleOfEmployee(int employeeID) {
        System.out.println("Display Marias schedule!");
    }

    public void displayWorkScheduleWithinDateRange(Date date) {
        System.out.println("Today's schedule is.....!");
    }

    public void createNewWorkSchedule() {
        System.out.println("Create a brand new schedule!");
    }

    public void deleteWorkSchedule() {
    }

    public void createWeeklyWorkSchedule(int checkInt) {
        System.out.println("This is your weekly schedule Mister!");
    }

    public void addShift(int checkInt) {
        System.out.println("Add a shift");
    }

    public void removeShift(int checkInt) {
        System.out.println("Remove a shift");
    }

    public void changeStartingTime(Date insertDate) {
        System.out.println("Change Starting time!");
    }

    public void changeEndingTime() {
        System.out.println("Change ending time!");
    }
}


import java.util.ArrayList;
import java.util.Date;

public class WorkSchedule {
    public static final double HOURLY_WAGE = 150.00;
    static int WorkScheduleID; // auto-increment ID
    private int employeeID;
    private ArrayList<Shift> shifts;
    private double totalHours;

    // constructor
    public WorkSchedule() {}

    public int getWorkScheduleID() {
        return WorkScheduleID;
    }

    public void setWorkScheduleID(int workScheduleID) {
        WorkScheduleID = workScheduleID;
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

    public double getTotalHours() {
        return totalHours;
    }

    public void calculateTotal_hours() {
        int totalHours=0;
        for (int i=0; i<= shifts.size(); i++) {
            //totalHours =+ shifts.get(i).workingHours;
        }
    }
}


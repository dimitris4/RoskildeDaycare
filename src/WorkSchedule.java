import java.util.ArrayList;
import java.util.Date;

public class WorkSchedule {
    public static final double WORKING_TIME_IN_A_DAY = 7.50;
    public static final double BRAKE_TIME_IN_A_DAY = 0.50;
    private int WorkScheduleID;
    private int EmployeeID;
    private ArrayList<Date> days;

    public int getWorkScheduleID() {
        return WorkScheduleID;
    }

    public void setWorkScheduleID(int workScheduleID) {
        WorkScheduleID = workScheduleID;
    }

    public int getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(int employeeID) {
        EmployeeID = employeeID;
    }

    public ArrayList<Date> getDays() {
        return days;
    }

    public void setDays(ArrayList<Date> days) {
        this.days = days;
    }

    @Override
    public String toString() {
        return "WorkSchedule{" +
                "WorkScheduleID=" + WorkScheduleID +
                ", EmployeeID=" + EmployeeID +
                ", days=" + days +
                '}';
    }
}


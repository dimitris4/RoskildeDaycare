import java.util.ArrayList;

public class WorkSchedule {
    private int WorkScheduleID;
    private int EmployeeID;
    private ArrayList<String> days;

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

    public ArrayList<String> getDays() {
        return days;
    }

    public void setDays(ArrayList<String> days) {
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


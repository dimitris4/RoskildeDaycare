import java.util.ArrayList;
import java.util.Date;

// Working time for dagplejer (caretaker) in Denmark is 48 hours a week within kl. 06.00-18.00
// source: http://www.dagplejen.dk/loen-og-arbejdsforhold

public class WorkSchedule {
    public static final int WORKING_HOURS_WEEK_FULL_TIME = 48;
    public static final int WORKING_HOURS_WEEK_PART_TIME = 15;
    public static final double HOURLY_WAGE = 150.00;
    static int WorkScheduleID; // auto-increment ID
    private int employeeID;
    private Date startingDate;
    private Date endingDate;
    private ArrayList<Date> days;
    private double total_hours;
    private boolean isFullTime;

    // constructor for creating work schedule for full time employees
    public WorkSchedule(int employeeID, boolean isFullTime) {
        this.employeeID = employeeID;
        total_hours = WORKING_HOURS_WEEK_FULL_TIME;
        this.isFullTime = isFullTime;
    }

    // constructor for creating work schedule for part time employees (given the amount of hours they want to commit)
    public WorkSchedule(int employeeID, boolean isFullTime, int total_hours) {
        this.employeeID = employeeID;
        this.total_hours = total_hours;
        this.isFullTime = isFullTime;
    }

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

    public ArrayList<Date> getDays() {
        return days;
    }

    public void setDays(ArrayList<Date> days) {
        this.days = days;
    }

    public Date getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(Date startingDate) {
        this.startingDate = startingDate;
    }

    public Date getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(Date endingDate) {
        this.endingDate = endingDate;
    }

    @Override
    public String toString() {
        return "WorkSchedule{" +
                "WorkScheduleID=" + WorkScheduleID +
                ", EmployeeID=" + employeeID +
                ", days=" + days +
                '}';
    }
}


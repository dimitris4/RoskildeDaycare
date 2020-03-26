import java.util.ArrayList;

public class WorkSchedule {

    private int employeeID;
    private ArrayList<Shift> shifts = new ArrayList<>();

    // constructor
    public WorkSchedule() {

    }

    /*public int getWorkScheduleID() {
        return workScheduleID;
    }*/

    /*public void setWorkScheduleID(int workScheduleID) {
        this.workScheduleID = workScheduleID;
    }*/

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
        return employeeID + " " + formatArray(shifts);
    }

    public void printNicely() {
        System.out.println(employeeID);
        System.out.println();
        for (Shift shift : shifts) {
            System.out.println(shift);
        }
    }

    //removes brackets and commas from the ArrayList representation as a string.
    public StringBuilder formatArray(ArrayList<Shift> shifts) {
        StringBuilder builder = new StringBuilder();
        for (Shift shift : shifts) {
            builder.append(shift);
        }
        return builder;
    }
}


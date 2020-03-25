import java.util.ArrayList;

public class WorkSchedule {
    //private static int workScheduleIDCounter = 0; // auto-increment ID
    //public Object printNicely;
    //private int workScheduleID;
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

    /*public void displayWorkScheduleOfEmployee(int employeeID) {
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
    }*/

    /*public void repeatWorkScheduleWeekly(Date lastDay) {
        Calendar cal1 = null;
        Calendar cal2 = null;
        Date newStartingTime;
        Date newEndingTime;
        for (Shift shift : shifts) {
            while (shift.getStartingTime().compareTo(lastDay) <= 0) {
                cal1.setTime(shift.getStartingTime());
                cal2.setTime(shift.getEndingTime());
                cal1.add(Calendar.DATE, 7);
                cal2.add(Calendar.DATE, 7);
                newStartingTime = cal1.getTime();
                newEndingTime = cal2.getTime();
                shifts.add(new Shift(newStartingTime, newEndingTime));
            }
        }
    }*/
}


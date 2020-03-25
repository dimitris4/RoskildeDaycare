public class WorkSchedule {
    private static int workScheduleIDCounter = 0; // auto-increment ID
    private int workScheduleID;
    private int employeeID;

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

    @Override
    public String toString() {
        return workScheduleID + " " + employeeID;
    }


}


public class Employee extends Person {
    private int employeeID;
    private static int employeeIDCounter = 1;
    private int workScheduleID = -1; // set -1 by default until the given employee is assigned a work schedule
    private String username;
    private String password;

    // constructor
    public Employee() {
        super();
        this.employeeID = employeeIDCounter++;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public int getWorkSchedule() {
        return workScheduleID;
    }

    public void setWorkSchedule(int workScheduleID) {
        this.workScheduleID = workScheduleID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return employeeID + " " + getPersonID() + " " + workScheduleID  + " " + username + " " +
                password;
    }
}

public class Employee extends Person {
    private int employeeID;
    private static int employeeIDCounter = 1;
    private WorkSchedule workSchedule;
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

    public WorkSchedule getWorkSchedule() {
        return workSchedule;
    }

    public void setWorkSchedule(WorkSchedule workSchedule) {
        this.workSchedule = workSchedule;
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
        return "Employee{" +
                "employeeID=" + employeeID +
                ", workSchedule=" + workSchedule +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

public class Employee extends Person {

    private int employeeID;
    private static int employeeIDCounter = 0;
    private int workScheduleID = -1; // set -1 by default until the given employee is assigned a work schedule
    private String username;
    private String password;
    private int accessLevel;

    // constructor
    public Employee(String firstName, String lastName, String telephone, String username, String password) {
        super(firstName, lastName, telephone);
        this.employeeID = employeeIDCounter++;
        super.setPersonID(super.getPersonID());
        this.accessLevel = 1;
        this.username = username;
        this.password = password;
    }

    public Employee (int employeeID) {
        this.employeeID = employeeID;
        employeeIDCounter++;
        super.setPersonID(super.getPersonID());
        this.accessLevel = 1;
    }

    public Employee () {
        this.employeeID = employeeIDCounter++;
        super.setPersonID(super.getPersonID());
        this.accessLevel = 1;
    }

    //Getters and setters
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

    public int getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
    }

    //toStrings for print, string return and account info
    @Override
    public String toString() {
        return employeeID + " " + getPersonID() + " " + workScheduleID  + " " + username + " " +
                password;
    }

    public void toStringPrint() {
        System.out.printf( "\t %-35s | %-30s | %s \n\t %-35s | %s \n",
                "Full name   : " + super.getFirstName() + " " + super.getLastName(), "Username    : " + username, "Phone nr    : " + super.getTelephone(),
                "Person ID   : " + super.getPersonID(), "Employee ID : " + employeeID );
    }
    public void toStringSimplePrint() {
        System.out.printf( "\t %-35s | %-30s | %s \n",
                "Full name   : " + super.getFirstName() + " " + super.getLastName(), "Username    : " + username, "Phone nr    : " + super.getTelephone());
    }
}

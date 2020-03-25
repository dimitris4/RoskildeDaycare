public class Employee extends Person {

    //private static FileManagement fm = new FileManagement();
    private static int employeeIDCounter = 1;
    private int employeeID;
    private String username;
    private String password;
    private int accessLevel;

    // constructor
    public Employee() {
        super();
        employeeID = employeeIDCounter++;
    }

    public Employee(int employeeID, String username, String password, int accessLevel, int personID, String firstName, String lastName, String telephone) {
        super(firstName, lastName, telephone);
        this.employeeID = employeeID;
        this.username = username;
        this.password = password;
        this.accessLevel = accessLevel;
    }

    public Employee(String firstName, String lastName, String telephone, String username, String password) {
        super(firstName, lastName, telephone);
        this.employeeID = employeeIDCounter++;
        super.setPersonID(super.getPersonID());
        this.accessLevel = 1;
        this.username = username;
        this.password = password;
    }


    public Employee (Person person) {
        super(person.getFirstName(), person.getLastName(), person.getTelephone());
        this.employeeID = employeeIDCounter++;
        super.setPersonID(person.getPersonID());
        this.accessLevel = 1;
    }


    //Getters and setters
    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
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
        return        username +
                " " + password +
                " " + accessLevel +
                " " + super.toString();
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

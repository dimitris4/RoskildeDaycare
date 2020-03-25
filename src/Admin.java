public class Admin extends Employee {

    //private static FileManagement fm = new FileManagement();
    private static int adminIDCounter = 1;
    private int adminID;

    // constructors
    public Admin() {
        super();
        adminID = adminIDCounter++;
    }

    public Admin(int adminID, int employeeID, String username, String password, int accessLevel, int personID, String firstName, String lastName, String telephone) {
        super(employeeID, username, password, accessLevel, personID, firstName, lastName, telephone);
        this.adminID = adminID;
    }

    public Admin(String firstName, String lastName, String telephone, String username, String password) {
        super(firstName, lastName, telephone, username, password);
        this.adminID = adminIDCounter++;
        this.setAccessLevel(2);
    }

    public Admin(Employee emp) {
        super(emp.getFirstName(), emp.getLastName(), emp.getTelephone(), emp.getUsername(), emp.getPassword());
        this.adminID = adminIDCounter++;
        this.setAccessLevel(2);
    }

	//getters and setters
    public int getAdminID() {
        return adminID;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public void toStringPrint() {
        System.out.printf( "\t %-35s | %-30s | %s \n\t %-35s | %-30s | %s \n",
                "Full name  : " + super.getFirstName() + " " + super.getLastName(), "Username    : " + super.getUsername(), "Phone nr    : " + super.getTelephone(),
                "Person ID  : " + super.getPersonID(), "Employee ID : " + super.getEmployeeID(), "Admin ID    : " + adminID );
    }
}

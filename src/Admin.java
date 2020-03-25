public class Admin extends Employee {

    private static int adminIDCounter = 100;
    private int adminID;

    // constructors
    public Admin(String firstName, String lastName, String telephone, String username, String password, int personID, int emplyeeID, int adminID) {
        super(firstName, lastName, telephone, username, password, personID, emplyeeID);
        this.adminID = adminID;
        this.setAccessLevel(2);
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

    public Admin(int adminID) {
        this.adminID = adminID;
        adminIDCounter++;
    }

    public Admin() {
        this.adminID = adminIDCounter++;
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
        return  adminID + " " + getEmployeeID() + " " + getPersonID();
    }

    public String toStringFile() {
        return  adminID + " " + getEmployeeID() + " " + getPersonID();
    }

    public void toStringPrint() {
        System.out.printf( "\t %-35s | %-30s | %s \n\t %-35s | %-30s | %s \n",
                "Full name  : " + super.getFirstName() + " " + super.getLastName(), "Username    : " + super.getUsername(), "Phone nr    : " + super.getTelephone(),
                "Person ID  : " + super.getPersonID(), "Employee ID : " + super.getEmployeeID(), "Admin ID    : " + adminID );
    }
}

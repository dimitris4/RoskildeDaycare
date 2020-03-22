public class Admin extends Employee {

    private static int adminIDCounter = 100;
    private int adminID;

    // constructor
    public Admin(String firstName, String lastName, String telephone, String username, String password) {
        super(firstName, lastName, telephone, username, password);
        this.adminID = adminIDCounter++;
        this.setAccessLevel(2);
    }

    public Admin() {}

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

    public void toStringPrint() {
        System.out.printf( "\t %-35s | %-25s | %s \n\t %-35s | %-25s | %s \n",
                "Full name   : " + super.getFirstName() + " " + super.getLastName(), "Username : " + super.getUsername(), "Phone nr    : " + super.getTelephone(),
                "Person ID   : " + super.getPersonID(), "Employee ID : " + super.getEmployeeID(), "Admin ID    : " + adminID );
    }
}

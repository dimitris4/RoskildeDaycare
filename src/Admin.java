public class Admin extends Employee {

    private static int adminIDCounter = 1;
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
        System.out.println( "First name  : " + super.getFirstName() +
                            "\nLast name   : " + super.getLastName() +
                            "\nPhone nr    : " + super.getTelephone() +
                            "\nPerson ID   : " + super.getPersonID() +
                            "\nEmployee ID : " + super.getEmployeeID() +
                            "\nAdmin ID    : " + adminID);
    }
}

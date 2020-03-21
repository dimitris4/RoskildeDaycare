public class Administrator extends Employee {
    private static int adminIDCounter = 1;
    private int adminID;

    // constructor
    public Administrator() {
        super();
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
}

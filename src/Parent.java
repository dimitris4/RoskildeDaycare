public class Parent extends Person {

    //private static FileManagement fm = new FileManagement();
    private static int parentIDCounter = 1;
    private int parentID;

    // constructor
    public Parent() {
        parentID = parentIDCounter++;
    }

    public Parent(String firstName, String lastName, String telephone) {
        super(firstName, lastName, telephone);
        this.setPersonID(super.getPersonID());
        this.parentID = parentIDCounter++;
    }

    /*public Parent() {
        super(getFirstName(), getLastName(), getTelephone());
        this.parentID = parentIDCounter++;
    }*/

    public int getParentID() {
        return parentID;
    }

    public void setParentID(int parentID) {
        this.parentID = parentID;
    }

    @Override
    public String toString() {
        return  super.toString();
    }

    public void toStringSimplePrintParent(){
        System.out.printf( "\t %-35s | %-30s | \n",
                "Full name   : " + super.getFirstName() + " " + super.getLastName(), "Parent ID    : " + getParentID());
    }
}

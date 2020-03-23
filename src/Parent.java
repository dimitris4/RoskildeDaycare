import java.util.ArrayList;

public class Parent extends Person {

    private int parentID;
    private static int parentIDCounter = 0;

    // constructor
    public Parent(String firstName, String lastName, String telephone) {
        super(firstName, lastName, telephone);
        this.setPersonID(super.getPersonID());
        this.parentID = parentIDCounter++;
    }

    public Parent() {
        this.parentID = parentIDCounter++;
    }

    public int getParentID() {
        return parentID;
    }

    public void setParentID(int parentID) {
        this.parentID = parentID;
    }

    @Override
    public String toString() {
        return parentID + " " + getPersonID();
    }
}

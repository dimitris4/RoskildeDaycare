import java.sql.SQLOutput;
import java.util.ArrayList;

public class Child extends Person{

    private int childID;
    private static int childIDCounter = 1;
    private int parentID;
    private String firstName;
    private String lastName;
    private boolean onWaitingList;

    // constructor
    public Child(String firstName, String lastName, int parentID) {
        super(firstName, lastName, null);
        this.childID = childIDCounter++;
        this.setPersonID(super.getPersonID());
        this.parentID = parentID;
    }

    public void addChildFromConsole(){
        String tempFirstName;
        String tempLastName;
        int tempParentID;

        //get first name
        System.out.println("First Name : ");
        tempFirstName = Input.checkName();

        //get last name
        System.out.println("Last Name : ");
        tempLastName = Input.checkName();

    }

    public int getChildID() {
        return childID;
    }

    public void setChildID(int childID) {
        this.childID = childID;
    }

    public int getParentID() {
        return parentID;
    }

    public void setParentID(int parentID) {
        this.parentID = parentID;
    }

    public boolean isOnWaitingList() {
        return onWaitingList;
    }

    public void setOnWaitingList(boolean onWaitingList) {
        this.onWaitingList = onWaitingList;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return childID + " " + parentID + " " + firstName + " " + lastName + " " +onWaitingList;
    }

    public void toStringPrint() {
        System.out.println( "First name        : " + super.getFirstName() +
                            "\nLast name         : " + super.getLastName() +
                            "\nParent ID         : " + parentID +
                            "\nChild ID          : " + childID +
                            "\nIs on waitinglist : " + onWaitingList );
    }

    public void toStringSimpleChild(){
        System.out.printf( "\t %-35s | %-30s | \n",
                "Full name   : " + super.getFirstName() + " " + super.getLastName(), "Parent ID    : " + parentID);
    }
}
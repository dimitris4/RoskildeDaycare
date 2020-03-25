public class Child extends Person {

    private int childID;
    private static int childIDCounter = 1;
    private int parentID;
    private boolean onWaitingList;

    // constructors

    public Child() {}

    public Child(String firstName, String lastName, int parentID) {
        super(firstName, lastName, null);
        this.childID = childIDCounter++;
        this.setPersonID(super.getPersonID());
        this.parentID = parentID;
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

    @Override
    public String toString() {
        return        childID +
                " " + parentID +
                " " + onWaitingList +
                " " + super.getPersonID() +
                " " + super.getFirstName() +
                " " + super.getLastName();
    }

    public void toStringPrint() {
        System.out.println( "First name        : " + super.getFirstName() +
                            "\nLast name         : " + super.getLastName() +
                            "\nParent ID         : " + parentID +
                            "\nChild ID          : " + childID +
                            "\nIs on waitinglist : " + onWaitingList );
    }

    public void toStringSimpleChild(){
        System.out.printf("\t%-35s | %-30s | %-35s \n",
                "Full name   : " + super.getFirstName() + " " + super.getLastName(), "Child ID    : " + childID , "Parent ID    : " + parentID);
    }

}
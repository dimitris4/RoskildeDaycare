import java.util.ArrayList;

public class Child {
    private int childID;
    private static int childIDCounter = 1;
    private int parentID;
    private boolean onWaitingList;

    // constructor
    public Child(int parentID) {
        this.childID = childIDCounter++;
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
}
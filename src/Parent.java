import java.util.ArrayList;

public class Parent extends Person {
    private int parentID;
    private ArrayList<Child> children;

    public int getParentID() {
        return parentID;
    }

    public void setParentID(int parentID) {
        this.parentID = parentID;
    }

    public ArrayList<Child> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<Child> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Parent{" +
                "parentID=" + parentID +
                ", children=" + children +
                '}';
    }
}

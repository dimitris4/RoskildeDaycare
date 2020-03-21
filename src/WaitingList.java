import java.util.ArrayList;

// we don't need a waiting list object, we can just display the children who have a false isOnWaitingList value.
public class WaitingList {
    private ArrayList<Child> waitingList;

    public ArrayList<Child> getWaitingList() {
        return waitingList;
    }

    public void setWaitingList(ArrayList<Child> waitingList) {
        this.waitingList = waitingList;
    }

    @Override
    public String toString() {
        return "WaitingList{" +
                "waitingList=" + waitingList +
                '}';
    }
}

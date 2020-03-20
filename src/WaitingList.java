import java.util.ArrayList;

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

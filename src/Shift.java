import java.util.Date;

public class Shift {
    private int shiftID;
    private static int shiftIDCounter = 1;
    private int workScheduleID;
    private Date startingTime;
    private Date endingTime;

    // constructor
    public Shift(int workScheduleID) {
        this.workScheduleID = workScheduleID;
        this.shiftID = shiftIDCounter++;
    }

    public Shift(Date startingTime, Date endingTime) {
        this.startingTime = startingTime;
        this.endingTime = endingTime;
    }

    public void setDate(Date date) {
        this.startingTime = date;
    }

    public Date getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(Date startingTime) {
        this.startingTime = startingTime;
    }

    public Date getEndingTime() {
        return endingTime;
    }

    public void setEndingTime(Date endingTime) {
        this.endingTime = endingTime;
    }

    @Override
    public String toString() {
        return shiftID + " " + workScheduleID + " " + startingTime + " " + endingTime;
    }
}

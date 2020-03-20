import java.util.Date;

// break time is 0.5 hours and if the shift is equal or more than 12 hours, then break time is 1 hour.

public class Shift {
    private int shiftID;
    private static int shiftIDCounter = 1;
    private int workScheduleID;
    private Date startingTime;
    private Date endingTime;
    //private double workingHours = endingTime - startingTime;

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
        return "Shift{" +
                "startingTime=" + startingTime +
                ", endingTime=" + endingTime +
                '}';
    }
}

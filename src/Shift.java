import java.text.SimpleDateFormat;
import java.util.Date;

public class Shift {
    //private int shiftID;
    //private static int shiftIDCounter = 1;
    //private int workScheduleID;
    private Date startingTime;
    private Date endingTime;

    // constructor
    public Shift(Date startingTime, Date endingTime) {
        this.startingTime = startingTime;
        this.endingTime = endingTime;
        //this.shiftID = shiftIDCounter++;
    }

    public Shift() {

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
        return formatDate(startingTime) + " " + formatDate(endingTime);
    }

    //converts date to string with this format: dd/mm/yyyy
    public String formatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        return sdf.format(date);
    }
}

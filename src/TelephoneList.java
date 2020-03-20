import java.util.ArrayList;

public class TelephoneList {
    private ArrayList<Person> telephoneList;

    public ArrayList<Person> getTelephoneList() {
        return telephoneList;
    }

    public void setTelephoneList(ArrayList<Person> telephoneList) {
        this.telephoneList = telephoneList;
    }

    public void add(Person person) {
        telephoneList.add(person);
    }

    @Override
    public String toString() {
        return "TelephoneList{" +
                "telephoneList=" + telephoneList +
                '}';
    }
}

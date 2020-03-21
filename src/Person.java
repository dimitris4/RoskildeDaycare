public class Person {
    private static int personIDCounter = 1;
    private int personID;
    private String firstName;
    private String lastName;
    private int telephone;

    // constructor
    public Person() {
        this.personID = personIDCounter++;
    }

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
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

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return personID + " " + firstName + " " + lastName + " " + telephone;
    }
}

public class Person {

    private static int personIDCounter = 1;
    private int personID;
    private String firstName;
    private String lastName;
    private String telephone;

    // constructor
    public Person(String firstName, String lastName, String telephone) {
        this.personID = personIDCounter++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephone = telephone;
    }

    public Person() {}

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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return personID + " " + firstName + " " + lastName + " " + telephone;
    }

    public void toStringPrint() {
        System.out.println( "First name  : " + firstName +
                            "\nLast name   : " + lastName +
                            "\nPhone nr    : " + telephone +
                            "\nPerson ID   : " + personID );
    }
}

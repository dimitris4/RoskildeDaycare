import java.util.ArrayList;

public class MyApp {

    private static Person currentUser = new Employee();
    private static ArrayList<Admin> admins = new ArrayList<>();
    private static ArrayList<Employee> employees = new ArrayList<>();
    private static ArrayList<WorkSchedule> workSchedules = new ArrayList<>();
    private static ArrayList<Child> children = new ArrayList<>();
    private static ArrayList<Parent> parents = new ArrayList<>();
    private static ArrayList<Integer> telephoneList = new ArrayList<>();
    private static ArrayList<Integer> waitingList = new ArrayList<>();

    public static void main(String[] args) {

        //loads the files into MyApp attributes
        loadInfo();

        //starts logInUI
        UserInterface UI = new UserInterface();
        currentUser = UI.logInMenu();
        if (currentUser instanceof Admin) {
            UI.adminMenu();
        } else {
            UI.employeeMenu();
        }

    }

    //populate information attributes of class MyApp
    public static void loadInfo () {

        FileManagement fileManagement = new FileManagement();
        ArrayList<Object> loadedLists = fileManagement.readFromFiles();
        // needs to read an ArrayList of Objects in the CORRECT order
        // 0 : Admin user
        // 1 : ArrayList of Employees
        // 2 : ArrayList of Workschedules
        // 3 : ArrayList of Children
        // 4 : ArrayList of Parents
        // 5 : ArrayList of Integers
        // 6 : ArrayList of Integers
        admins = (ArrayList<Admin>) loadedLists.get(0);
        employees = (ArrayList<Employee>) loadedLists.get(1);
        workSchedules = (ArrayList<WorkSchedule>) loadedLists.get(2);
        children = (ArrayList<Child>) loadedLists.get(3);
        parents = (ArrayList<Parent>) loadedLists.get(4);
        telephoneList = (ArrayList<Integer>) loadedLists.get(5);
        waitingList = (ArrayList<Integer>) loadedLists.get(6);
    }

    //Getters n Setters
    //returns a list of personIDs for each phone nr
    public static ArrayList<Integer> getTelephoneList() {
        return telephoneList;
    }


    public static void setTelephoneList(ArrayList<Integer> telephoneList) {
        MyApp.telephoneList = telephoneList;
    }

    public static ArrayList<Integer> getWaitingList() {
        return waitingList;
    }

    public static void setWaitingList(ArrayList<Integer> waitingList) {
        MyApp.waitingList = waitingList;
    }

    public static ArrayList<Employee> getEmployees() {
        return employees;
    }

    public static void setEmployees(ArrayList<Employee> employees) {
        MyApp.employees = employees;
    }

    public static ArrayList<Child> getChildren() {
        return children;
    }

    public static void setChildren(ArrayList<Child> children) {
        MyApp.children = children;
    }

    public static ArrayList<Parent> getParents() {
        return parents;
    }

    public static void setParents(ArrayList<Parent> parents) {
        MyApp.parents = parents;
    }

    public static ArrayList<Admin> getAdmin() {
        return admins;
    }

    public static void setAdmin(ArrayList<Admin> admins) {
        MyApp.admins = admins;
    }

    public static ArrayList<WorkSchedule> getWorkSchedules() {
        return workSchedules;
    }

    public static void setWorkSchedules(ArrayList<WorkSchedule> workSchedules) {
        MyApp.workSchedules = workSchedules;
    }
}

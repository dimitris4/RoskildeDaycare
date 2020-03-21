import java.util.ArrayList;

public class MyApp {

    private static Employee currentUser = new Employee();
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
        Employee user = UI.logInMenu();

        //Selects menu based on acceslevel
        if (user.getAccessLevel() == 2) {
            UI.adminMenu();
        } else if ( user.getAccessLevel() == 1 ){
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
        // 7 : HashMap< String username, String password >

        //FOR USE
        /*admins = (ArrayList<Admin>) loadedLists.get(0);
        employees = (ArrayList<Employee>) loadedLists.get(1);
        workSchedules = (ArrayList<WorkSchedule>) loadedLists.get(2);
        children = (ArrayList<Child>) loadedLists.get(3);
        parents = (ArrayList<Parent>) loadedLists.get(4);
        telephoneList = (ArrayList<Integer>) loadedLists.get(5);
        waitingList = (ArrayList<Integer>) loadedLists.get(6);
        userLogIn = (HashMap<String, String>) loadedLists.get(7);*/

        //FOR TESTING MAIN ADMIN
        Admin testUser = new Admin("teodor", "jonasson", "26192327", "teodor", "teodor");
        admins.add(testUser);

        Employee test1 = new Employee("mark", "jackson", "23232323", "mark", "mark");
        employees.add(test1);
    }

    //Getters n Setters

    //get an Employee OR Admin object with Username
    public static Employee getEmployee (String username) {

        Employee user = null;

        //check if username matches admin usernames
        for (int i = 0; i < admins.size(); i++) {
            if (admins.get(i).getUsername().equals(username)) {
                user = admins.get(i);
            }
        }

        //only runs if the username doenst match an admin username
        if (user == null) {

            //check if username matches employee usernames
            for (int j = 0; j < employees.size(); j++) {

                if (employees.get(j).getUsername().equals(username)) {
                    user = employees.get(j);
                }
            }
        }

        return user;
    }

    public static Employee getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(Employee currentUser) {
        MyApp.currentUser = currentUser;
    }

    //Returns full Admin list
    public static ArrayList<Admin> getAdmins() {
        return admins;
    }

    //Returns 1 Admin Object
    public static Admin getAdmin(int adminID) {

        Admin admin = null;

        for (int i = 0; i < admins.size(); i++){

            if ( admins.get(i).getAdminID() == adminID ){
                admin = admins.get(i);
            }
        }
        if (admin == null) {
            System.out.println("** no match was found **");
        }
        return admin;
    }

    //Set full adminlist
    public static void setAdmins(ArrayList<Admin> admins) {
        MyApp.admins = admins;
    }

    public static void setAdmins(Admin admin, int adminID) {
        admins.set(adminID, admin);
    }

    public static ArrayList<Employee> getEmployees() {
        return employees;
    }

    public static void setEmployees(ArrayList<Employee> employees) {
        MyApp.employees = employees;
    }

    public static ArrayList<WorkSchedule> getWorkSchedules() {
        return workSchedules;
    }

    public static void setWorkSchedules(ArrayList<WorkSchedule> workSchedules) {
        MyApp.workSchedules = workSchedules;
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

}

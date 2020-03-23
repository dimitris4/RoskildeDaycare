import java.util.ArrayList;

public class MyApp {

    //Management object attributes
    private static Employee currentUser = new Employee();
    private static FileManagement FM = new FileManagement();

    //Information attributes
    private static ArrayList<Admin> admins = new ArrayList<>();
    private static ArrayList<Employee> employees = new ArrayList<>();
    private static ArrayList<WorkSchedule> workSchedules = new ArrayList<>();
    private static ArrayList<Child> children = new ArrayList<>();
    private static ArrayList<Parent> parents = new ArrayList<>();
    private static ArrayList<Integer> telephoneList = new ArrayList<>();
    private static ArrayList<Integer> waitingList = new ArrayList<>();

    //ID counts
    private static int personID = 4;
    private static int employeeID = 4;
    private static int adminID = 100;

    // START OF PROGRAM
    public static void main(String[] args) {

        //loads the files into MyApp attributes
        loadInfo();

        //starts UI
        login();
    }

    public static void login() {
        //starts logInUI
        UserInterface UI = new UserInterface();
        currentUser = UI.logInMenu();

        //Selects menu based on acceslevel
        if (currentUser.getAccessLevel() == 2) {
            UI.adminMenu();
        } else {
            UI.employeeMenu();
        }
    }

    //populate information attributes of class MyApp
    public static void loadInfo () {

        ArrayList<Object> loadedLists = FM.readFromFiles();
        // needs to read an ArrayList of Objects in the CORRECT order
        // 0 : ArrayList of Admins
        // 1 : ArrayList of Employees
        // 2 : ArrayList of Workschedules
        // 3 : ArrayList of Children
        // 4 : ArrayList of Parents
        // 5 : ArrayList of Integers
        // 6 : ArrayList of Integers
        // 7 : Integer for People count

        //FOR USE
        /*admins = (ArrayList<Admin>) loadedLists.get(0);
        employees = (ArrayList<Employee>) loadedLists.get(1);
        workSchedules = (ArrayList<WorkSchedule>) loadedLists.get(2);
        children = (ArrayList<Child>) loadedLists.get(3);
        parents = (ArrayList<Parent>) loadedLists.get(4);
        telephoneList = (ArrayList<Integer>) loadedLists.get(5);
        waitingList = (ArrayList<Integer>) loadedLists.get(6);

        //FOR ID COUNTS
        adminID = admins.get(admins.size()-1).getAdminID();
        employeeID = employees.get(employees.size()).getEmployeeID();
        personID = loadedLists.get(7);
        */



        //FOR TESTING MAIN ADMIN
        Admin testUser = new Admin("teodor", "jonasson", "26192327", "teodor", "jonasson");
        admins.add(testUser);

        Parent testParent1 = new Parent("mother", "mom", "11111111");
        parents.add(testParent1);
        Parent testParent2 = new Parent("father", "dad", "22222222");
        parents.add(testParent2);
        Parent testParent3 = new Parent("moose", "max", "33333333");
        parents.add(testParent3);

        Child testChild1 = new Child("child", "lack", testParent1.getParentID());
        children.add(testChild1);
        Child testChild2 = new Child("what", "luck", testParent2.getParentID());
        children.add(testChild2);
        Child testChild3 = new Child("ever", "laack", testParent3.getParentID());
        children.add(testChild3);

        Employee test1 = new Employee("mark", "jackson", "23232323", "mark", "jackson");
        employees.add(test1);
        Employee test2 = new Employee("loui", "lack", "88776655", "loui", "lack");
        employees.add(test2);
        Employee test3 = new Employee("solvei", "markson", "11223344", "solvei", "markson");
        employees.add(test3);
    }

    //EXIT PROGRAM     -- Upload all data from attributes to FileManagement --
    public static void exit() {

        //Create ArrayList for all system info so it can be loaded into FileManagement
        ArrayList<Object> systemInfo = new ArrayList<>();

        //Add infoList in CORRECT order
        systemInfo.add(admins);
        systemInfo.add(employees);
        systemInfo.add(workSchedules);
        systemInfo.add(children);
        systemInfo.add(parents);
        systemInfo.add(telephoneList);
        systemInfo.add(waitingList);

        //Send ArrayList to FileManagement to update files.
        FM.writeToFiles(systemInfo);
    }

    //REMOVE ADMIN with adminID
    public static void removeAdmin(int adminID) {

        //Verification that action went through
        boolean check = false;

        //Loop thorugh full admin list to find match
        for (int i = 0; i < admins.size(); i++ ) {

            //Removes admin when adminID match is found
            if (admins.get(i).getAdminID() == adminID) {
                admins.remove(i);
                System.out.println("** Admin removed **");
                check = true;
            }
        }
        //informs if action failed
        if (check) {
            System.out.println("** Admin not found (not removed) **");
        }
    }

    //REMOVE EMPLOYEE with employeeID
    public static void removeEmployee(int employeeID) {

        //Verification that action went through
        boolean check = false;

        //Loop thorugh full admin list to find match
        for (int i = 0; i < employees.size(); i++ ) {

            //Removes admin when adminID match is found
            if (employees.get(i).getEmployeeID() == employeeID) {
                employees.remove(i);
                System.out.println("** Employee removed **");
                check = true;
            }
        }
        //informs if action failed
        if (!check) {
            System.out.println("** Employee not found (not removed) **");
        }
    }

    //GETTERS AND SETTERS

    public static int getPersonID() {
        return personID;
    }

    public static void setPersonID(int personID) {
        MyApp.personID = personID;
    }

    public static int getEmployeeID() {
        return employeeID;
    }

    public static void setEmployeeID(int employeeID) {
        MyApp.employeeID = employeeID;
    }

    public static int getAdminID() {
        return adminID;
    }

    public static void setAdminID(int adminID) {
        MyApp.adminID = adminID;
    }

    //get an Employee OR Admin object from Username
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

    //Add Employee to list
    public static void addEmployee(Employee emp) {
        employees.add(emp);
        System.out.println("** Employee added to system **");
    }

    //Add Admin to list
    public static void addAdmin(Admin adm) {
        admins.add(adm);
        System.out.println("** Admin added to system **");
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

    //Set 1 Admin object depending on adminID
    public static void setAdmin(Admin admin, int adminID) {
        boolean check = false;
        for (int i = 0; i < admins.size(); i++ ) {
            if (admins.get(i).getAdminID() == adminID) {
                admins.set(i, admin);
                System.out.println("** Admin updated **");
                check = true;
            }
        }
        if (!check) {
            System.out.println("** Admin not found (not updated) **");
        }
    }

    //Returns 1 Employee Object
    public static Employee getEmployee(int employeeID) {

        Employee employee = null;

        //Looks though the full Employee list to find match
        for (int i = 0; i < employees.size(); i++){
            //when match is found
            if ( employees.get(i).getEmployeeID() == employeeID ){
                employee = employees.get(i);
            }
        }
        //Just for verification that the employee was found
        if (employee == null) {
            System.out.println("** no match was found **");
        }
        return employee;
    }

    public static ArrayList<Employee> getEmployees() {
        return employees;
    }

    public static void setEmployees(ArrayList<Employee> employees) {
        MyApp.employees = employees;
    }

    //Set 1 Employee object depending on employeeID
    public static void setEmployee(Employee employee, int employeeID) {
        boolean check = false;
        for (int i = 0; i < employees.size(); i++ ) {
            if (employees.get(i).getEmployeeID() == employeeID) {
                employees.set(i, employee);
                System.out.println("** Employee updated **");
                check = true;
            }
        }
        if (!check) {
            System.out.println("** Employee not found (not updated) **");
        }
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

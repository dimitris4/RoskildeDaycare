import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class MyApp {

    //Management object attributes
    private static Employee currentUser = new Employee();
    private static FileManagement FM = new FileManagement();
    private static Scanner console = new Scanner(System.in);

    //Information attributes
    private static ArrayList<Admin> admins = new ArrayList<>();
    private static ArrayList<Employee> employees = new ArrayList<>();
    private static ArrayList<WorkSchedule> workSchedules = new ArrayList<>();
    private static ArrayList<Child> children = new ArrayList<>();
    private static ArrayList<Parent> parents = new ArrayList<>();
    private static ArrayList<Person> people = new ArrayList<>();
    //private static ArrayList<Integer> waitingList = new ArrayList<>();

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
        //systemInfo.add(telephoneList);
        //systemInfo.add(waitingList);

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



    /*******************************************************
    /*      Work Schedule related methods (Dimitris)       */
    /*******************************************************/

    public void createNewWorkSchedule() {
        UserInterface ui = new UserInterface();
        ui.printEmployees();
        String str = "";
        WorkSchedule wc = new WorkSchedule();
        wc.setEmployeeID(checkEmployeeID());
        ArrayList<Shift> arrayList = new ArrayList<Shift>();
        boolean a = false;
        while (!a) {
            System.out.println();
            System.out.print("Enter 'add shift' to add a shift, or 'quit' to exit: ");
            str = console.nextLine();
            if (str.equals("add shift")) {
                System.out.println();
                System.out.print("The shift starts at (use format: dd-MM-yyyy HH:mm): ");
                Date startingTime = Input.insertDate();
                System.out.println();
                System.out.print("The  shift  ends at (use format: dd-MM-yyyy HH:mm): ");
                Date endingTime = Input.insertDate();
                Shift shift = new Shift(startingTime, endingTime);
                arrayList.add(shift);
                System.out.println();
                System.out.print("Does this shift repeat weekly? (yes/no): ");
                String choice = console.nextLine();
                boolean flag = false;
                while (!flag) {
                    switch (choice) {
                        case "yes":
                            System.out.println();
                            System.out.print("Ends on day (use format: dd-MM-yyyy): ");
                            Date endsOnDate = Input.insertDateWithoutTime();
                            Calendar cal1 = Calendar.getInstance();
                            Calendar cal2 = Calendar.getInstance();
                            cal1.setTime(shift.getStartingTime());
                            cal2.setTime(shift.getEndingTime());
                            //System.out.println(Input.diffInDays(shift.getStartingTime(), endsOnDate));
                            while (Input.diffInDays(shift.getStartingTime(), endsOnDate) >= 7) {
                                cal1.add(Calendar.DATE, 7);
                                cal2.add(Calendar.DATE, 7);
                                arrayList.add(new Shift(cal1.getTime(), cal2.getTime()));
                                shift = new Shift(cal1.getTime(), cal2.getTime());
                            }
                            flag = true;
                            wc.setShifts(arrayList);
                            //workSchedules.add(wc);
                            //System.out.println("Employee ID: " + wc.getEmployeeID());
                            //System.out.println("Shifts: " + wc.getShifts());
                            break;
                        case "no":
                            wc.setShifts(arrayList);
                            //workSchedules.add(wc);
                            flag = true;
                            break;
                        default:
                            System.out.print("Incorrect input. Enter value (yes/no): ");
                            choice = console.nextLine();
                            break;
                    }
                }
            } else if (str.equals("quit")) {
                if (wc.getShifts().size() == 0) {
                    workSchedules.remove(wc);
                } else {
                    workSchedules.add(wc);
                }
                a = true;
            } else {
                System.out.print("Incorrect input. ");
            }
        }
    }


    public int checkEmployeeID() {
        int employeeID = 0;
        while (employeeID == 0) {
            System.out.print("Enter employee ID: ");
            employeeID = Input.checkInt(1, 999);
            for (Employee employee : employees) {
                if (employee.getEmployeeID() == employeeID) {
                    return employeeID;
                }
            }
            for (Admin admin : admins) {
                if (admin.getEmployeeID() == employeeID) {
                    return  employeeID;
                }
            }
            System.out.print("Please enter a valid employee id: ");
            employeeID = Input.checkInt(1, 999);
        }
        return 0;
    }


    public void displayWorkScheduleWithinDateRange() {
        System.out.println();
        System.out.println("'This function displays the employee IDs and their shifts between two dates.'");
        System.out.println();
        System.out.print("Enter start date (use format: dd-MM-yyyy): ");
        Date date1 = Input.insertDateWithoutTime();
        System.out.print("Enter  end  date (use format: dd-MM-yyyy): ");
        Date date2 = Input.insertDateWithoutTime();
        for (WorkSchedule wc : getWorkSchedules()) {
            for (int i = 0; i < wc.getShifts().size(); i++) {
                if (wc.getShifts().get(i).getStartingTime().compareTo(date1) > 0
                    && wc.getShifts().get(i).getStartingTime().compareTo(date2) < 0) {
                    System.out.println(wc.getShifts().get(i));
                }
            }
        }
    }

    public void displayWorkScheduleOfEmployee() {
        int employeeID = checkEmployeeID();
        for (WorkSchedule wc : workSchedules) {
            System.out.println("Employee ID: " + wc.getEmployeeID());
            if (wc.getEmployeeID() == employeeID) {
                for (int i = 0; i < wc.getShifts().size(); i++) {
                    System.out.println(wc.getShifts().get(i));
                }
            }
        }
    }

    public void deleteWorkSchedule() {
        int employeeID = checkEmployeeID();
        workSchedules.removeIf(wc -> wc.getEmployeeID() == employeeID);
    }

    public void addShift() {
        int employeeID = checkEmployeeID();
        for (WorkSchedule wc : workSchedules) {
            if (wc.getEmployeeID() == employeeID) {
                System.out.print("The shift starts at (use format: dd-MM-yyyy HH:mm): ");
                Date startingTime = Input.insertDate();
                System.out.print("The shift ends at (use format: dd-MM-yyyy HH:mm): ");
                Date endingTime = Input.insertDate();
                if (shiftsDoNotOverlap(startingTime, wc.getEmployeeID())) {
                    Shift shift = new Shift(startingTime, endingTime);
                    wc.getShifts().add(shift);
                    System.out.println();
                    System.out.print("Does this shift repeat weekly? (yes/no): ");
                    String choice = console.nextLine();
                    boolean flag = false;
                    while (!flag) {
                        switch (choice) {
                            case "yes":
                                System.out.print("Ends on day (use format: dd-MM-yyyy): ");
                                Date endsOnDate = Input.insertDateWithoutTime();
                                Calendar cal1 = Calendar.getInstance();
                                Calendar cal2 = Calendar.getInstance();
                                cal1.setTime(shift.getStartingTime());
                                cal2.setTime(shift.getEndingTime());
                                System.out.println(Input.diffInDays(shift.getStartingTime(), endsOnDate));
                                while (Input.diffInDays(shift.getStartingTime(), endsOnDate) >= 7) {
                                    cal1.add(Calendar.DATE, 7);
                                    cal2.add(Calendar.DATE, 7);
                                    wc.getShifts().add(new Shift(cal1.getTime(), cal2.getTime()));
                                    shift = new Shift(cal1.getTime(), cal2.getTime());
                                }
                                flag = true;
                                break;
                            case "no":
                                flag = true;
                                break;
                            default:
                                System.out.print("Incorrect input. Enter value (yes/no): ");
                                choice = console.nextLine();
                                break;
                        }
                    }
                } else {
                    System.out.println("The shift cannot be added because it overlaps with another one.");
                }
            } else {
                while (true) {
                    System.out.print("The employee with ID" + employeeID + "does not have a work schedule yet. Do you want to create it now? (yes/no): ");
                    String answer = "";
                    answer = console.next();
                    if (answer.equals("yes")) {
                        createNewWorkSchedule();
                    } else if (answer.equals("no")) {
                        return;
                    } else {
                        System.out.print("Selection incorrect. Enter a valid value (yes/no): ");
                        answer = console.next();
                    }
                }
            }
        }
    }

    public boolean shiftsDoNotOverlap(Date startingTime, int employeeID) {
        for (int i = 0; i < workSchedules.size(); i++) {
            if (workSchedules.get(i).getEmployeeID() == employeeID) {
                for (int j = 0; j < workSchedules.get(i).getShifts().size(); j++) {
                    if (workSchedules.get(i).getShifts().get(j).getStartingTime().compareTo(startingTime) == 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void removeShift() {
        int employeeID = checkEmployeeID();
        for (WorkSchedule wc : workSchedules) {
            if (wc.getEmployeeID() == employeeID) {
                Date date = Input.insertDate();
                for (Shift shift : wc.getShifts()) {
                    if (shift.getStartingTime().compareTo(date) == 0) {
                        wc.getShifts().remove(shift);
                    }
                }
            }
        }
    }

    public void changeStartingTime() {
        int employeeID = checkEmployeeID();
        for (WorkSchedule wc : workSchedules) {
            if (wc.getEmployeeID() == employeeID) {
                Date date = Input.insertDate();
                for (Shift shift : wc.getShifts()) {
                    if (shift.getStartingTime().compareTo(date) == 0) {
                        System.out.print("Enter new starting time (use format: dd-MM-yyyy HH:mm): ");
                        shift.setStartingTime(Input.insertDate());
                    }
                }
            }
        }
    }

    public void changeEndingTime() {
        int employeeID = checkEmployeeID();
        for (WorkSchedule wc : workSchedules) {
            if (wc.getEmployeeID() == employeeID) {
                Date date = Input.insertDate();
                for (Shift shift : wc.getShifts()) {
                    if (shift.getEndingTime().compareTo(date) == 0) {
                        System.out.print("Enter new ending time (use format: dd-MM-yyyy HH:mm): ");
                        shift.setStartingTime(Input.insertDate());
                    }
                }
            }
        }
    }



    /*//returns a list of personIDs for each phone nr
    public static ArrayList<Integer> getTelephoneList() {
        return telephoneList;
    }*/

    /*public static void setTelephoneList(ArrayList<Integer> telephoneList) {
        MyApp.telephoneList = telephoneList;
    }*/

    /*public static ArrayList<Integer> getWaitingList() {
        return waitingList;
    }*/

    /*public static void setWaitingList(ArrayList<Integer> waitingList) {
        MyApp.waitingList = waitingList;
    }*/

}

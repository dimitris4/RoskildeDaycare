import java.io.FileNotFoundException;
import java.text.DateFormat;
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


    // START OF PROGRAM
    public static void main(String[] args) throws FileNotFoundException {

        //loads the files into MyApp attributes
        loadInfo();

        //starts UI
        login();
    }

    public static void login() throws FileNotFoundException {
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
        admins = FM.readAdminsFromFile();
        employees = FM.readEmployeesFromFile();
        workSchedules = FM.readWorkSchedulesFromFile();
        children = FM.readChildrenFromFile();
        parents = FM.readParentsFromFile();
        people = FM.readPeopleFromFile();
    }


    //EXIT PROGRAM     -- Upload all data from attributes to FileManagement --
    public static void exit() throws FileNotFoundException {
        FM.saveAdminsToFile(admins);
        FM.saveEmployeesToFile(employees);
        FM.saveWorkSchedulesToFile(workSchedules);
        FM.saveChildrenToFile(children);
        FM.saveParentsToFile(parents);
        FM.savePeopleToFile(people);
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


    /*******************************************************************/
    /*      Work Schedule related methods (written by Dimitrios)       */
    /*******************************************************************/

    public void createNewWorkSchedule() {
        UserInterface ui = new UserInterface(); // in class user interface we have the println statements for the menus.
        ui.printEmployees();   // this method just prints employees and admins to the console
        String str = "";
        WorkSchedule wc = new WorkSchedule();
        wc.setEmployeeID(checkEmployeeID());
        ArrayList<Shift> arrayList = new ArrayList<Shift>();  // initialize an array list that holds all shifts of an employee object
        boolean a = false;
        while (!a) {  // i have a boolean value here because i want the loop to run until the user enter a valid value.
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
                while (!flag) {   // i want the loop to run until the user enters either yes or no
                    switch (choice) {
                        case "yes":
                            System.out.println();
                            System.out.print("Ends on day (use format: dd-MM-yyyy): ");
                            Date endsOnDate = Input.insertDateWithoutTime();
                            Calendar cal1 = Calendar.getInstance(); // i use the add days function of the calendar class
                            Calendar cal2 = Calendar.getInstance(); // in order to manipulate date objects
                            cal1.setTime(shift.getStartingTime());
                            cal2.setTime(shift.getEndingTime());
                            // custom method diffInDays calculates the difference between two dates in days
                            // if the end day is more than a week ahead, then create a new shift for next week (i.e. increase current date by 7 days).
                            while (Input.diffInDays(shift.getStartingTime(), endsOnDate) >= 7) {
                                cal1.add(Calendar.DATE, 7);
                                cal2.add(Calendar.DATE, 7);
                                arrayList.add(new Shift(cal1.getTime(), cal2.getTime()));
                                shift = new Shift(cal1.getTime(), cal2.getTime());
                            }
                            flag = true;
                            wc.setShifts(arrayList);
                            break;
                        case "no":
                            wc.setShifts(arrayList);
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
                    workSchedules.remove(wc);  // if the user quits the session before even adding one shift, i remove the work schedule object.
                } else {
                    workSchedules.add(wc); // if user quits session after adding some shifts, add the work schedule object to static variable
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
        System.out.printf("%-25s %-25s  %-25s \n", " Employee ID ", " Starting Time ", " Ending Time ");
        for (WorkSchedule wc : workSchedules) {
            for (int i = 0; i < wc.getShifts().size(); i++) {
                if (wc.getShifts().get(i).getStartingTime().compareTo(date1) > 0
                    && wc.getShifts().get(i).getStartingTime().compareTo(date2) < 0) {
                    System.out.printf("%-25s %-25s  %-25s \n", wc.getEmployeeID(), formatDate(wc.getShifts().get(i).getStartingTime()),
                            formatDate(wc.getShifts().get(i).getEndingTime()));
                }
            }
        }
    }

    public void displayWorkScheduleOfEmployee(int employeeID) {
        //System.out.println(workSchedules.get(0).getShifts());
        System.out.printf("%-25s %-25s\n", " Starting Time ", " Ending Time ");
        for (WorkSchedule wc : workSchedules) {
            if (wc.getEmployeeID() == employeeID) {
                for (int i = 0; i < wc.getShifts().size(); i++) {
                    System.out.printf("%-25s %-25s\n", formatDate(wc.getShifts().get(i).getStartingTime()),
                            formatDate(wc.getShifts().get(i).getEndingTime()));
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
        System.out.print("The shift starts at (use format: dd-MM-yyyy HH:mm): ");
        Date startingTime = Input.insertDate();
        System.out.print("The shift ends at (use format: dd-MM-yyyy HH:mm): ");
        Date endingTime = Input.insertDate();
        for (WorkSchedule wc : workSchedules) {
            if (wc.getEmployeeID() == employeeID) {
                for (Shift shift : wc.getShifts()) {
                    if (Input.diffInDays(shift.getStartingTime(), startingTime) == 0) {
                        System.out.println("The shift cannot be added since the employee has a shift on that day.");
                    } else {
                        Shift newShift = new Shift(startingTime, endingTime);
                        wc.getShifts().add(newShift);
                    }
                }
            }
        }
        // if this employee does not have any shifts yet, then create a new work schedule
        WorkSchedule newWc = new WorkSchedule();
        newWc.setEmployeeID(employeeID);
        ArrayList<Shift> shifts = new ArrayList<Shift>();
        Shift newShift = new Shift(startingTime, endingTime);
        shifts.add(newShift);
        newWc.setShifts(shifts);
        workSchedules.add(newWc);
    }

    public void removeShift() {
        int employeeID = checkEmployeeID();
        displayWorkScheduleOfEmployee(employeeID);
        for (WorkSchedule wc : workSchedules) {
            if (wc.getEmployeeID() == employeeID) {
                System.out.print("Enter the date to remove a shift (use format dd-mm-yyyy): ");
                Date date = Input.insertDateWithoutTime();
                for (int i = 0; i < wc.getShifts().size(); i++) {
                    if (Input.diffInDays(date, wc.getShifts().get(i).getStartingTime()) == 0) {
                        wc.getShifts().remove(i);
                    }
                }
            }
        }
    }

    public void changeStartingTime() {
        int employeeID = checkEmployeeID();
        for (WorkSchedule wc : workSchedules) {
            if (wc.getEmployeeID() == employeeID) {
                System.out.print("Enter the date to find the shift you want to update (use format dd-mm-yyyy): ");
                Date date = Input.insertDateWithoutTime();
                for (int i = 0; i < wc.getShifts().size(); i++) {
                    if (Input.diffInDays(date, wc.getShifts().get(i).getStartingTime()) == 0) {
                        System.out.print("Enter new starting time (use format: dd-MM-yyyy HH:mm): ");
                        Date newStartingTime = Input.insertDateWithoutTime();
                        wc.getShifts().get(i).setStartingTime(newStartingTime);
                    }
                }
            }
        }
    }

    public void changeEndingTime() {
        int employeeID = checkEmployeeID();
        for (WorkSchedule wc : workSchedules) {
            if (wc.getEmployeeID() == employeeID) {
                System.out.print("Enter the date to find the shift you want to update (use format dd-mm-yyyy): ");
                Date date = Input.insertDateWithoutTime();
                for (int i = 0; i < wc.getShifts().size(); i++) {
                    if (Input.diffInDays(date, wc.getShifts().get(i).getStartingTime()) == 0) {
                        System.out.print("Enter new ending time (use format: dd-MM-yyyy HH:mm): ");
                        Date newEndingTime = Input.insertDateWithoutTime();
                        wc.getShifts().get(i).setEndingTime(newEndingTime);
                    }
                }
            }
        }
    }

    public String formatDate(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm");
        String strDate;
        strDate = dateFormat.format(date);
        return strDate;
    }
}

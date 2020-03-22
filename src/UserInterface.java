import java.util.ArrayList;

public class UserInterface {

    private int space = 110;

    public Employee logInMenu() {

        Employee user = null;
        String username = "";
        String password = "";
        Boolean login = false;

        printText("- LOGIN -");

        while (!login){
            System.out.print("Username : ");
            //Get username
            username = Input.checkUsername();
            //find match from username : returns null if there was no match
            //otherwise return Employee object of user.
            user = MyApp.getEmployee(username);
            //checks to see if there was a user match with username
            if (user == null) {
                System.out.println("** no matching username **");
            } else {
                //asks for password matching username
                System.out.print("Password : ");
                password = Input.checkUsername();
                //Check password match
                if (user.getPassword().equals(password)) {
                    //Match found
                    login = true;
                } else {
                    //Match not found
                    System.out.println("** Wrong password **");
                }
            }
        }
        //return user after username + password match
        return user;
    }

    public void adminMenu() {

        printText("- ADMIN MENU - ");
        System.out.println();
            //Print menu options
        System.out.printf("\t%-20s | %-25s | %-24s | %-20s\n", "> 1. Employees", "> 3. Waiting list", "> 5. Children", "> 0. Exit" );
        System.out.printf("\t%-20s | %-25s | %-24s \n\n", "> 2. Schedules", "> 4. Telephone list", "> 6. Change account" );
            //Select option
        print();
        System.out.print("Select: ");
        int choice = -1;
        do {
            choice = Input.checkInt(0, 7);
            switch (choice) {
                case 0:
                    MyApp.exit();
                    printText("- EXIT PROGRAM -");
                    choice = -1;
                    break;
                case 1:
                    employees();
                    break;
                case 2:
                    schedules();
                    break;
                case 3:
                    waitingList();
                    break;
                case 4:
                    telephoneList();
                    break;
                case 5:
                    children();
                    break;
                case 6:
                    choice = -1;
                    MyApp.login();
                    break;
                default:

            }
        } while (choice != -1);
    }

    public void employees() {

            //create an ArrayList of all regular employees
        ArrayList<Employee> employeeList = MyApp.getEmployees();
            //used to specify what accounts are admin / employee
        int employees = employeeList.size() - 1;
            //add all admins
        employeeList.addAll(MyApp.getAdmins());
            //takes the full list of employees + number of employees to determine admins in list
            //prints all first and last names of employees in correct order
        employeeListPrint(employeeList, employees);

        int choice = -1;
        do {
                //employee menu
            printText("- Employees -");
            System.out.printf("\n\t%-20s | %-25s | %-24s\n",   "> 1. See all info", "> 3. Fire employee", "> 5. Back");
            System.out.printf(  "\t%-20s | %-25s \n\n",        "> 2. Change info",  "> 4. Hire new");
            print();
                //select option
            System.out.print("Select: ");
            choice = Input.checkInt(1, 5);
            print();
            switch (choice) {
                //See all info on employees
                case 1:
                    for (int a = 0; a < employeeList.size(); a++) {
                        employeeList.get(a).toStringPrint();
                        if (a < employeeList.size()-1)
                            print();
                    }
                    break;
                //Change info of an employee
                case 2:
                        //prints all employee names in Employee and Admin groups
                    employeeListPrint(employeeList, employees);
                    print();
                        //Select what employee you want to change from the list with both Employees + Admins
                    System.out.print("Select: ");
                    int empSelection = Input.checkInt(0, employeeList.size()-1);
                    print();
                        //Print employee selection to verify it was the right selection
                    employeeList.get(empSelection).toStringPrint();
                    print();
                    System.out.print("Correct selection? \n1. yes, 2. no : ");
                    int assurance = Input.checkInt(1, 2);
                    if (assurance == 1) {
                        changeInfo(employeeList.get(empSelection));
                    }
                    break;
                //Fire employee
                case 3:
                    employeeListPrint(employeeList, employees);
                    print();
                    System.out.print("Select: ");
                    int empFire = Input.checkInt(0, employeeList.size()-1);
                    print();
                    employeeList.get(empFire).toStringPrint();
                    print();
                    System.out.print("Correct selection? \n1. yes, 2. no : ");
                    int check = Input.checkInt(1, 2);

                    if (check == 1) {
                        Employee emp = employeeList.get(empFire);
                            //checks if employee is admin or reg employee
                            //Admin removal
                        if (emp instanceof Admin) {
                            MyApp.removeAdmin( ((Admin) emp).getAdminID() );
                            employees--;
                        }
                            //Employee removal
                        else {
                            MyApp.removeEmployee( emp.getEmployeeID() );
                            employees--;
                        }
                    }
                    break;
                //Hire new employee
                case 4:

                    break;
                //back to admin menu / end do while
                case 5:
                    choice = -1;
            }
        } while (choice != -1);
    }

    public void changeInfo(Employee emp) {
            //create new Employee object to check for differences
        Employee newEmp = emp;
        Boolean infoChanged = false;

        while ( !infoChanged ) {
            print();
            System.out.println("\tWhat would you like to change? ");
            System.out.printf("\n\t%-20s | %-25s | %-24s | %-20s\n", "> 1. First name", "> 3. Last Name", "> 5. Phone number", "> 7. Back");
            System.out.printf("\t%-20s | %-25s | %-24s\n", "> 2. Username", "> 4. Password", "> 6. See info");
            print();
            System.out.print("Select: ");
            int choice = Input.checkInt(1, 7);
            print();

            switch (choice) {
                //Change first name
                case 1:
                    System.out.println("Current name : " + emp.getFirstName());
                    System.out.print("New name     : ");
                    String newName = Input.checkName();
                    System.out.print("Correct name: " + newName + "?\n1. yes, 2. no : ");
                    int assurance = Input.checkInt(1, 2);
                    if (assurance == 1) {
                        newEmp.setFirstName(newName);
                        System.out.println("** First name changed **");
                    }
                    break;
                //Change username
                case 2:
                    System.out.println("Current username : " + emp.getUsername());
                    System.out.print("New username     : ");
                    String newUsername = Input.checkName();
                    System.out.print("new username : " + newUsername + "?\n1. yes, 2. no : ");
                    assurance = Input.checkInt(1, 2);
                    if (assurance == 1) {
                        newEmp.setUsername(newUsername);
                        System.out.println("** Username changed **");
                    }
                    break;
                //Change last name
                case 3:
                    System.out.println("Current last name : " + emp.getLastName());
                    System.out.print(  "New last name     : ");
                    String newLastName = Input.checkName();
                    System.out.print("New last name : " + newLastName + "?\n1. yes, 2. no : ");
                    assurance = Input.checkInt(1, 2);
                    if (assurance == 1) {
                        newEmp.setLastName(newLastName);
                        System.out.println("** Last name changed **");
                    }
                    break;
                //Change password
                case 4:
                    System.out.println("Current password : ********** ");
                    System.out.print(  "New password     : ");
                    String newPassword = Input.checkName();
                    System.out.print("New password : " + newPassword + "?\n1. yes, 2. no : ");
                    assurance = Input.checkInt(1, 2);
                    if (assurance == 1) {
                        newEmp.setPassword(newPassword);
                        System.out.println("** Password changed **");
                    }
                    break;
                //Change phoneNr
                case 5:
                    System.out.println("Current phoneNr : " + newEmp.getTelephone());
                    System.out.print(  "New phoneNr     : ");
                    String newTelephone = Input.checkPhoneNr();
                    System.out.print("New phoneNR : " + newTelephone + "?\n1. yes, 2. no : ");
                    assurance = Input.checkInt(1, 2);
                    if (assurance == 1) {
                        newEmp.setTelephone(newTelephone);
                        System.out.println("** Telephone nr changed **");
                    }
                    break;
                //Print current Employee info
                case 6:
                    newEmp.toStringPrint();
                    break;
                //back to admin menu
                case 7:
                    text("Save changes?");
                    print();
                    //Print new employee info
                    newEmp.toStringPrint();
                    print();
                    System.out.print("Updated Employee info?\n1. yes, 2. no : ");
                    int save = Input.checkInt(1, 2);
                    //only saves if user approves
                    if (save == 1) {
                        //checks if employee is admin or reg employee
                        //Admin removal
                        if (emp instanceof Admin) {
                            MyApp.setAdmin((Admin) newEmp, ((Admin) emp).getAdminID());
                        }
                        //Employee removal
                        else {
                            MyApp.setEmployee(newEmp, emp.getEmployeeID());
                        }
                    }
                    infoChanged = true;
            }
        }
    }

    public void employeeListPrint(ArrayList<Employee> employeeList, int employees ){
        //display full employee list
        text(" - Employee list -");
        for (int i = 0; i < employeeList.size(); i++) {
            System.out.println("\t> " + i + ". " + employeeList.get(i).getFirstName() + " " + employeeList.get(i).getLastName());
            if (i == employees) {
                text(" - Admins -");
            }
        }
    }

    public void schedules() {

    }

    public void waitingList() {

    }

    public void telephoneList() {

    }

    public void children() {

    }

    public void updateAccount() {

    }

    public void employeeMenu() {
        printText("- EMPLOYEE MENU - ");
    }

    //FORMATTING
    public void printText(String text) {

        int startSpace = ( space - text.length() ) / 2;
        String stripe = "";
        String startSpaceString = "";
        for (int j = 0; j < space; j++) {
            stripe += "-";
        }
        for (int i = 0; i < startSpace; i++ ){
           startSpaceString += " ";
        }
        System.out.println( stripe + "\n" + startSpaceString + text + "\n" + stripe );
    }

    public void text(String text) {

        int startSpace = ( space - text.length() ) / 2;
        String startSpaceString = "";
        for (int i = 0; i < startSpace; i++ ){
            startSpaceString += " ";
        }
        System.out.println(startSpaceString + text);
    }

    public void print() {

        String stripe = "";
        for (int i = 0; i < space; i++) {
            stripe += "-";
        }
        System.out.println(stripe);
    }
}

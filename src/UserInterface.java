import java.util.ArrayList;

class UserInterface {

    private int space = 110;
    private ArrayList<Employee> emp = MyApp.getEmployees();
    private ArrayList<Admin> adm = MyApp.getAdmins();

    private int empSize = emp.size();
    private int admSize = adm.size();
    private int sumSize = empSize + admSize;

    Employee logInMenu() {
        Employee user = null;
        String username = "";
        String password = "";
        boolean login = false;
        printText("- LOGIN -");
        while (!login){
            System.out.print("Username : ");
            username = Input.checkUsername();
            user = MyApp.getEmployee(username);
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

    void adminMenu() {
        int choice = -1;
        do {
            //Print menu options
            printText("- ADMIN MENU - ");
            System.out.println();
            System.out.printf("\t%-20s | %-25s | %-24s | %-20s\n", "> 1. Employees", "> 3. Waiting list", "> 5. Children", "> 0. Exit" );
            System.out.printf("\t%-20s | %-25s | %-24s \n\n", "> 2. Schedules", "> 4. Telephone list", "> 6. Change account" );
            //Select option
            print();
            System.out.print("Select: ");
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
                    workScheduleMenu();
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

    private void employees() {

        //prints all first and last names of employees in correct order
        employeeListPrint();

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
                    for (int a = 0; a < empSize; a++) {
                        emp.get(a).toStringPrint();
                        print();
                    }
                    for (int b = 0; b < admSize; b++) {
                        adm.get(b).toStringPrint();
                        if (b < admSize-1)
                            print();
                    }
                    break;
                //Change info of an employee
                case 2:
                    //prints all employee names in Employee and Admin groups
                    employeeListPrint();
                    print();

                    //Select what employee you want to change from the list with both Employees + Admins
                    System.out.print("Select: ");
                    int empSelection = Input.checkInt(0, sumSize-1);
                    print();

                    boolean type = false;
                    //Regular employee
                    if (empSelection > empSize) {
                        //Print employee selection to verify it was the right selection
                        emp.get(empSelection).toStringPrint();
                    }
                    //Admin employee
                    else {
                        adm.get(empSelection - empSize).toStringPrint();
                        type = true;
                    }

                    print();
                    System.out.print("Correct selection? \n1. yes, 2. no : ");
                    int assurance = Input.checkInt(1, 2);
                    if (assurance == 1 && !type) {
                        changeInfo(emp.get(empSelection));
                    } else {
                        changeInfo(adm.get(empSelection - empSize));
                    }
                    break;
                //Fire employee
                case 3:
                    fireEmployee();
                    break;
                //Hire new employee
                case 4:
                    hireEmployee();
                    break;
                //back to admin menu / end do while
                case 5:
                    choice = -1;
            }
        } while (choice != -1);
    }

    private Boolean fireEmployee() {

        Employee employeeFired = null;
        boolean empRemoved = false;
        employeeListPrint();
        print();
        System.out.print("Select: ");
        int empFire = Input.checkInt(0, sumSize-1);
        print();
        if (empFire < empSize) {
            employeeFired = emp.get(empFire);
            employeeFired.toStringPrint();
        } else {
            employeeFired = adm.get(empFire - empSize);
            employeeFired.toStringPrint();
        }
        print();
        System.out.print("Correct selection? \n1. yes, 2. no : ");
        int check = Input.checkInt(1, 2);

        if (check == 1) {
            //checks if employee is admin or reg employee
            //Admin removal
            if (employeeFired instanceof Admin) {
                MyApp.removeAdmin( ((Admin) employeeFired).getAdminID() );
            }
            //Employee removal
            else {
                MyApp.removeEmployee( employeeFired.getEmployeeID() );
            }
            empRemoved = true;
            updateEmpList();
        }
        return empRemoved;
    }

    private void hireEmployee() {

        Employee newEmp = new Employee();
        boolean check = false;

        printText("- Hire new employee - ");
        System.out.println("\tWhat type of employee are you creating?");
        System.out.printf("\n\t%-20s | %s", "> 1. Regular Employee", "> 2. Administartor \n\n");
        print();
        System.out.print("Select: ");
        int select = Input.checkInt(1, 2);
            //only occurs if user selects administrator, otherwise newEmp remains an Employee object
        if (select==2) {
            newEmp = new Admin(MyApp.getAdminID()+1);
            MyApp.setAdminID(MyApp.getAdminID()+1);
            text(" - Administrator - ");
        } else {
            text(" - Employee - ");
        }

        //Get first name
        System.out.print("First name       : ");
        String firstName = Input.checkName();
        newEmp.setFirstName(firstName);

        //Get last name
        System.out.print("Last name        : ");
        String lastName = Input.checkName();
        newEmp.setLastName(lastName);

        //Get PhoneNr
        System.out.print("Phone nr         : ");
        String phoneNr = Input.checkPhoneNr();
        newEmp.setTelephone(phoneNr);

        //Get Username
        System.out.print("Username         : ");
        String username = Input.checkUsername();
        newEmp.setUsername(username);

        //Get password
        String pass1 = "";
        String pass2 = "";
        int checkNr = 2;
        do {
            System.out.print("Create password  : ");
            pass1 = Input.checkUsername();
            System.out.print("Verify password  : ");
            pass2 = Input.checkUsername();
            if ( !pass1.equals(pass2) ) {
                System.out.println("** Passwords didnt match **");
            } else {
                newEmp.setPassword(pass1);
            }
        } while ( !pass1.equals(pass2) && checkNr == 1 );

        //All info recieved
        //Print info to and ask to save
        print();
        newEmp.toStringPrint();
        print();
        System.out.print("Save profile?\n1. yes, 2. no    : ");
        checkNr = Input.checkInt(1, 2);
        if (checkNr == 1) {

            //Add new employee to MyApp and update UI employee lists
            if (newEmp instanceof Admin) {
                MyApp.addAdmin( (Admin) newEmp);
            } else {
                MyApp.addEmployee(newEmp);
            }
            updateEmpList();
        }
    }

    private void updateEmpList() {
        emp = MyApp.getEmployees();
        adm = MyApp.getAdmins();
        empSize = emp.size();
        admSize = adm.size();
        sumSize = empSize + admSize;
    }

    private void changeInfo(Employee emp) {
            //create new Employee object to check for differences
        boolean infoChanged = false;

        while ( !infoChanged ) {

            printText("- Change info -");
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
                    System.out.println("Current name   : " + emp.getFirstName());
                    System.out.print("New name         : ");
                    String newName = Input.checkName();
                    System.out.print("Correct name     : " + newName + "?\n1. yes, 2. no    : ");
                    int assurance = Input.checkInt(1, 2);
                    if (assurance == 1) {
                        emp.setFirstName(newName);
                        System.out.println("** First name changed **");
                    }
                    break;
                //Change username
                case 2:
                    System.out.println("Current username  : " + emp.getUsername());
                    System.out.print(  "New username      : ");
                    String newUsername = Input.checkName();
                    System.out.print(  "new username      : " + newUsername + "?\n1. yes, 2. no     : ");
                    assurance = Input.checkInt(1, 2);
                    if (assurance == 1) {
                        emp.setUsername(newUsername);
                        System.out.println("** Username changed **");
                    }
                    break;
                //Change last name
                case 3:
                    System.out.println("Current last name : " + emp.getLastName());
                    System.out.print(  "New last name     : ");
                    String newLastName = Input.checkName();
                    System.out.print("New last name : " + newLastName + "?\n1. yes, 2. no     : ");
                    assurance = Input.checkInt(1, 2);
                    if (assurance == 1) {
                        emp.setLastName(newLastName);
                        System.out.println("** Last name changed **");
                    }
                    break;
                //Change password
                case 4:
                    System.out.println("Current password  : ********** ");
                    System.out.print(  "New password      : ");
                    String newPassword = Input.checkUsername();
                    System.out.print("New password : " + newPassword + "?\n1. yes, 2. no     : ");
                    assurance = Input.checkInt(1, 2);
                    if (assurance == 1) {
                        emp.setPassword(newPassword);
                        System.out.println("** Password changed **");
                    }
                    break;
                //Change phoneNr
                case 5:
                    System.out.println("Current phoneNr   : " + emp.getTelephone());
                    System.out.print(  "New phoneNr       : ");
                    String newTelephone = Input.checkPhoneNr();
                    System.out.print("New phoneNR : " + newTelephone + "?\n1. yes, 2. no     : ");
                    assurance = Input.checkInt(1, 2);
                    if (assurance == 1) {
                        emp.setTelephone(newTelephone);
                        System.out.println("** Telephone nr changed **");
                    }
                    break;
                //Print current Employee info
                case 6:
                    emp.toStringPrint();
                    break;
                //back to admin menu
                case 7:
                    text("Save changes?");
                    print();
                    //Print new employee info
                    emp.toStringPrint();
                    print();
                    System.out.print("Updated Employee info?\n1. yes, 2. no     : ");
                    int save = Input.checkInt(1, 2);
                    //only saves if user approves
                    if (save == 1) {
                        //checks if employee is admin or reg employee
                        //Admin removal
                        if (emp instanceof Admin) {
                            MyApp.setAdmin((Admin) emp, ((Admin) emp).getAdminID());
                        }
                        //Employee removal
                        else {
                            MyApp.setEmployee(emp, emp.getEmployeeID());
                        }
                    }
                    infoChanged = true;
            }
        }
    }

    private void employeeListPrint(){

        //display full employee list
        text(" - Employee list -");
        for (int i = 0; i < empSize; i++) {
            System.out.println("\t> " + i + ". " + emp.get(i).getFirstName() + " " + emp.get(i).getLastName());
        }
        text(" - Admins -");
        for (int i = empSize; i < admSize + empSize; i++) {
            System.out.println("\t> " + i + ". " + adm.get(i-empSize).getFirstName() + " " + adm.get(i-empSize).getLastName());
        }
    }

    private void workScheduleMenu() {
        while (true) {
            WorkSchedule wc = new WorkSchedule();
            printText("- Schedules - ");
            System.out.println();
            System.out.printf("\t%-45s | %-30s | %-30s | %-25s \n", "> 1. Display work schedule of employee", "> 3. Create new work schedule", "> 5. Delete work schedule", "> 0. Exit");
            System.out.printf("\t%-45s | %-30s | %-30s \n\n", "> 2. Display work schedule within date range", "> 4. Update work schedule", "> 6. Back");
            //Select option
            print();
            System.out.print("Select: ");
            int choice = Input.checkInt(0, 6);
            switch (choice) {
                case 0:
                    MyApp.exit();
                    printText("- EXIT PROGRAM -");
                    break;
                case 1:
                    System.out.print("Enter employee ID: ");
                    wc.displayWorkScheduleOfEmployee(Input.checkInt(1,9999));
                    break;
                case 2:
                    wc.displayWorkScheduleWithinDateRange(Input.insertDate());
                    break;
                case 3:
                    wc.createNewWorkSchedule();
                    break;
                case 4:
                    updateWorkScheduleMenu();
                    break;
                case 5:
                    System.out.println("This operation will permanently remove all shifts assigned to an employee.");
                    wc.deleteWorkSchedule();
                    break;
                case 6:
                    choice = -1;
                    MyApp.login();
                    break;
                default:
            }
        }
    }

    private void updateWorkScheduleMenu() {
        while (true) {
            WorkSchedule wc = new WorkSchedule();
            printText("- Update Work Schedule - ");
            System.out.println();
            System.out.printf("\t%-17s | %-37s | %-25s \n", "> 1. Add shift", "> 3. Change starting time of a shift", "> 5. Back");
            System.out.printf("\t%-17s | %-37s | %-25s \n\n", "> 2. Remove shift", "> 4. Change ending time of a shift", "> 6. Exit");
            print();
            System.out.print("Select: ");
            int choice = Input.checkInt(0, 5);
            switch (choice) {
                case 0:
                    MyApp.exit();
                    printText("- EXIT PROGRAM -");
                    //choice = -1;
                    break;
                case 1:
                    System.out.print("Enter Employee ID: ");
                    wc.addShift(Input.checkInt(1,9999));
                    break;
                case 2:
                    System.out.print("Enter Employee ID: ");
                    wc.removeShift(Input.checkInt(1,9999));
                    break;
                case 3:
                    wc.changeStartingTime(Input.insertDate());
                    break;
                case 4:
                    wc.changeEndingTime();
                    break;
                case 5:
                    updateWorkScheduleMenu();
                    break;
                case 6:
                    workScheduleMenu();
                    break;
                default:
            }
        }
    }

    private void waitingList() {

    }

    private void telephoneList() {

    }

    private void children() {

    }

    void employeeMenu() {
        printText("- EMPLOYEE MENU - ");
    }

    //FORMATTING  -- ONLY USED WITHIN THE CLASS --
    private void printText(String text) {

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

    private void text(String text) {

        int startSpace = ( space - text.length() ) / 2;
        String startSpaceString = "";
        for (int i = 0; i < startSpace; i++ ){
            startSpaceString += " ";
        }
        System.out.println(startSpaceString + text);
    }

    private void print() {

        String stripe = "";
        for (int i = 0; i < space; i++) {
            stripe += "-";
        }
        System.out.println(stripe);
    }
}

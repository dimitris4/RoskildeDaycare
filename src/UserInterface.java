import java.io.FileNotFoundException;
import java.util.ArrayList;

class UserInterface {

    //TEST
    private int space = 110;
    private int space_schedule = 150;
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
        while (!login) {
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

    void adminMenu() throws FileNotFoundException {
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
            print();
            switch (choice) {
                case 0:
                    MyApp.exit();
                    System.exit(0);
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
                    if (empSelection < empSize) {
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

        //Create person with firstName, lastName and phoneNr
        Employee newEmp = new Employee(createPerson(false));
        boolean check = false;

        //Admin / Employee choice
        print();
        System.out.println("\tWhat type of employee are you creating?");
        System.out.printf("\n\t%-20s | %s", "> 1. Regular Employee", "> 2. Administartor \n\n");
        print();
        System.out.print("Select: ");
        int selectType = Input.checkInt(1, 2);
            //only occurs if user selects administrator, otherwise newEmp remains an Employee object
        if (selectType==2) {
            System.out.println(" - Administrator - ");
        } else {
            System.out.println(" - Employee - ");
        }

        //Create Username
        System.out.print("Username         : ");
        String username = Input.checkUsername();
        newEmp.setUsername(username);

        //Create password
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
        newEmp.toStringSimplePrint();
        print();
        System.out.print("Save profile?\n1. yes, 2. no    : ");
        checkNr = Input.checkInt(1, 2);
        if (checkNr == 1) {
            //Add new employee to MyApp and update UI employee lists
            if (selectType == 2) {
                newEmp = new Admin(newEmp);
                MyApp.addAdmin( (Admin) newEmp);
            } else {
                MyApp.addEmployee(newEmp);
            }
            updateEmpList();
        } else {
            System.out.println("** Cancelled new employee ** ");
        }
    }

    private Person createPerson(boolean isChild) {

        Person newPerson = new Person();

        //Get first name
        System.out.print("First name       : ");
        String firstName = Input.checkName();
        newPerson.setFirstName(firstName);

        //Get last name
        System.out.print("Last name        : ");
        String lastName = Input.checkName();
        newPerson.setLastName(lastName);

        if (!isChild) {
            //Get PhoneNr
            System.out.print("Phone nr         : ");
            String phoneNr = Input.checkPhoneNr();
            newPerson.setTelephone(phoneNr);
        } else {
            newPerson.setTelephone(null);
        }
        return newPerson;
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
                    emp.setFirstName(newInfo("name     : ", emp.getFirstName(), 1));
                    break;
                //Change username
                case 2:
                    emp.setUsername(newInfo("username : ", emp.getUsername(), 2));
                    break;
                //Change last name
                case 3:
                    emp.setLastName(newInfo("last name: ", emp.getLastName(), 1));
                    break;
                //Change password
                case 4:
                    emp.setPassword(newInfo("password  : ", emp.getPassword(), 2));
                    break;
                //Change phoneNr
                case 5:
                    emp.setTelephone(newInfo("phoneNr  : ", emp.getTelephone(), 3));
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

    private String newInfo(String comment, String info, int type) {

        String newInfo = "";
        System.out.println("Current " + comment + info);
        System.out.print(  "New info         : ");
        if(type == 1 ) {
            newInfo = Input.checkName();
        } else if ( type == 2 ) {
            newInfo = Input.checkUsername();
        } else {
            newInfo = Input.checkPhoneNr();
        }
        System.out.print("Correct info     : " + newInfo + "?\n1. yes, 2. no    : ");
        int assurance = Input.checkInt(1, 2);
        if (assurance == 1) {
            System.out.println("** Profile changed **");
            return newInfo;
        } else {
            System.out.println("** Profile change cancelled **");
            return info;
        }
    }

    private void employeeListPrint(){
        //display full employee list
        printText(" - Employee list -");
        for (int i = 0; i < empSize; i++) {
            System.out.print("\t> " + i + ". " );
            emp.get(i).toStringSimplePrint();
        }
        printText(" - Admins -");
        for (int i = empSize; i < admSize + empSize; i++) {
            System.out.print("\t> " + i + ". " );
            adm.get(i-empSize).toStringSimplePrint();
        }
    }

    /**********************************************************/
    /*    Dimitrios - Methods for the Work schedules menu     */
    /**********************************************************/

    public void printEmployees() {
        System.out.println("---------------------------Employees-----------------------------------");
        System.out.printf("%-25s %-25s  %-25s \n", " Employee ID ", " First Name ", " Last Name ");
        for (Employee employee : emp) {
            System.out.printf("%-25s %-25s %-25s", employee.getEmployeeID(), employee.getFirstName(), employee.getLastName());
            System.out.println();
        }
        System.out.println();
        System.out.println("-----------------------------Admins------------------------------------");
        System.out.printf("%-25s %-25s  %-25s \n", " Employee ID ", " First Name ", " Last Name ");
        for (Admin admin : adm) {
            System.out.printf("%-25s %-25s  %-25s", admin.getEmployeeID(), admin.getFirstName(), admin.getLastName());
            System.out.println();
        }
    }


    private void workScheduleMenu() throws FileNotFoundException {
        while (true) {
            MyApp myApp = new MyApp();
            //printScheduleMenuLine();
            printTextSchedule("- Schedules - ");
            //printScheduleMenuLine();
            System.out.println();
            System.out.printf("\t%-45s | %-40s | %-30s | %-30s \n", "> 1. Create new work schedule", "> 3. Display work schedule of employee", "> 5. Delete work schedule", "> 0. Exit");
            System.out.printf("\t%-45s | %-40s | %-30s \n\n", "> 2. Display work schedule within date range", "> 4. Update work schedule", "> 6. Back");
            printScheduleMenuLine();
            System.out.print("Select: ");
            int choice = Input.checkInt(0, 6);
            switch (choice) {
                case 0:
                    MyApp.exit();
                    System.exit(0);
                    break;
                case 1:
                    myApp.createNewWorkSchedule();
                    break;
                case 2:
                    myApp.displayWorkScheduleWithinDateRange();
                    break;
                case 3:
                    myApp.displayWorkScheduleOfEmployee();
                    break;
                case 4:
                    updateWorkScheduleMenu();
                    break;
                case 5:
                    System.out.println("This will remove all shifts assigned to an employee.");
                    myApp.deleteWorkSchedule();
                    break;
                case 6:
                    adminMenu();
                    break;
                default:
            }
        }
    }

    private void updateWorkScheduleMenu() throws FileNotFoundException {
        while (true) {
            MyApp myApp = new MyApp();
            printText("- Update Work Schedule - ");
            System.out.println();
            System.out.printf("\t%-22s | %-37s | %-25s \n", "> 1. Add shift", "> 3. Change starting time of a shift", "> 5. Back");
            System.out.printf("\t%-22s | %-37s | %-25s \n\n", "> 2. Remove shift", "> 4. Change ending time of a shift", "> 0. Exit");
            print();
            System.out.print("Select: ");
            int choice = Input.checkInt(0, 5);
            switch (choice) {
                case 0:
                    MyApp.exit();
                    printText("- EXIT PROGRAM -");
                    break;
                case 1:
                    myApp.addShift();
                    break;
                case 2:
                    myApp.removeShift();
                    break;
                case 3:
                    myApp.changeStartingTime();
                    break;
                case 4:
                    myApp.changeEndingTime();
                    break;
                case 5:
                    workScheduleMenu();
                    break;
                default:
            }
        }
    }

    private void waitingList() {
        int choice = -1;
        int choice2 = -1;
        int tempParentID = 0;

        do{
            //print menu options
            printText("- WAITING LIST MENU - ");
            System.out.println();
            System.out.printf("\t%-20s | %-25s | %-24s \n", "> 1. See list", "> 3. Remove child", "> 0. Back" );
            System.out.printf("\t%-20s \n\n", "> 2. Add child");

            //select option
            print();
            System.out.print("Select : ");
            choice = Input.checkInt(0, 3);

            switch (choice){
                case 0:
                    choice = -1;
                    break;
                    //go back to the main menu
                case 1:
                    printText("- WAITING LIST - ");
                    System.out.println();
                    for(int i = 0; i < MyApp.getChildren().size(); i++){
                        if (MyApp.getChildren().get(i).isOnWaitingList()) {
                            MyApp.getChildren().get(i).toStringSimpleChild();
                        }
                    }
                    System.out.println();
                    break;
                case 2:
                    printText("- ADD CHILD - ");
                    MyApp.getChildren().add(addChildFromConsole());
                    MyApp.getChildren().get(MyApp.getChildren().size()-1).setOnWaitingList(true);
                    break;
                case 3:
                    printText("- WAITING LIST - ");
                    System.out.println();
                    for(int i = 0; i < MyApp.getChildren().size(); i++){
                        if (MyApp.getChildren().get(i).isOnWaitingList()) {
                            MyApp.getChildren().get(i).toStringSimpleChild();
                        }
                    }
                    print();
                    System.out.println("Want to remove a child from the waiting list?");
                    print();
                    System.out.printf("\t%-20s \n", "> 1. Yes");
                    System.out.printf("\t%-20s \n\n", "> 0. No");
                    print();
                    System.out.print("Select : ");
                    choice2 = Input.checkInt(0, 1);
                    print();
                    switch (choice2){
                        case 0:
                            break;
                        case 1:
                            System.out.print("Please enter the Child ID of the child you want to remove : ");
                            int answer = Input.checkInt(0, (MyApp.getChildren().size()));
                            MyApp.getChildren().removeIf(child -> child.getChildID() == answer);
                            break;
                        default:
                    }


                    default:
            }
        } while (choice != -1);

    }

    private void telephoneList() {
        int choice = -1;
        do {
            //Print menu options
            printText("- TELEPHONE LISTS - ");
            System.out.printf("\t%-20s | %-25s \n", "> 1. Employees", "> 0. Back" );
            System.out.printf("\t%-20s | \n\n", "> 2. Parents" );
            //select option
            print();
            System.out.print("Select : ");
            choice = Input.checkInt(0, 2);

            switch (choice) {
                case 0:
                    choice = -1;
                    break;
                case 1:
                    // prints all employees, including their telephone list
                    printText(" - EMPLOYEE TELEPHONE LIST - ");
                    for(int i = 0; i < empSize; i++){
                        emp.get(i).toStringSimplePrintPerson();
                        print();
                    }
                    break;
                case 2:
                    // prints all parents, including their phone number
                    printText(" - PARENT TELEPHONE LIST - ");
                    for(int i = 0; i < MyApp.getParents().size(); i++ ){
                        MyApp.getParents().get(i).toStringSimplePrintPerson();
                        print();
                    }

                default:
            }
        } while( choice != -1);
    }

    private void children() {
        int choice =-1;
        int choice2 = -1;

        do {
            //print menu options
            printText(" - CHILD MENU - ");
            System.out.println();
            System.out.printf("\t%-30s | %-25s \n", "> 1. Show list of Children", "> 3. Remove child");
            System.out.printf("\t%-30s | %-25s \n\n", "> 2. Add Child", "> 0. Back" );

            // select option
            print();
            System.out.print("Select : ");
            choice = Input.checkInt(0, 3);
            switch (choice) {
                case 0:
                    choice = -1;
                    break;
                case 1:
                    //Prints a list of all the children in the day care
                    printText(" - LIST OF CHILDREN - ");
                    for (int i = 0; i < MyApp.getChildren().size(); i++) {
                        MyApp.getChildren().get(i).toStringSimpleChild();
                    }
                    print();
                    break;
                case 2:
                    printText(" - ADD CHILD - ");
                    MyApp.getChildren().add(addChildFromConsole());
                    break;
                case 3:
                    printText(" - LIST OF CHILDREN - ");
                    for (int i = 0; i < MyApp.getChildren().size(); i++) {
                        MyApp.getChildren().get(i).toStringSimpleChild();
                    }
                    print();
                    System.out.println("Want to remove a child from the waiting list?");
                    print();
                    System.out.printf("\t%-20s \n", "> 1. Yes");
                    System.out.printf("\t%-20s \n\n", "> 0. No");
                    print();
                    System.out.print("Select : ");
                    choice2 = Input.checkInt(0, 1);
                    print();
                    switch (choice2) {
                        case 0:
                            break;
                        case 1:
                            System.out.print("Please enter the Child ID of the child you want to remove : ");
                            int answer = Input.checkInt(0, (MyApp.getChildren().size()));
                            MyApp.getChildren().removeIf(child -> child.getChildID() == answer);
                            break;
                        default:

                    }
                default:
            }
        } while (choice != -1);
    }


    void employeeMenu() throws FileNotFoundException {
        int choice = -1;

        do{
            //print menu options
            printText("- EMPLOYEE MENU - ");
            System.out.println();
            System.out.printf("\t%-20s | %-25s | %-24s \n", "> 1. Telephone List", "> 3. Children", "> 0. Exit" );
            System.out.printf("\t%-20s | %-25s \n\n", "> 2. Waiting List", "> 4. Change account" );
            //select option
            print();
            System.out.print("Select : ");
            choice = Input.checkInt(0, 4);
            switch (choice) {
                case 0:
                    MyApp.exit();
                    printText("- EXIT PROGRAM -");
                    choice = -1;
                    break;
                case 1:
                    telephoneList();
                    break;
                case 2:
                    waitingList();
                    break;
                case 3:
                    children();
                    break;
                case 4:
                    choice = -1;
                    MyApp.login();
                    break;
                default:

            }

        } while ( choice != -1);
    }

    public Child addChildFromConsole() {
        String tempFirstName1;
        String tempLastName1;
        String tempFirstName2;
        String tempLastName2;
        String tempPhoneNumber;
        int tempParentID;
        int choice = -1;
        System.out.println("Is the parent already in the system? (Do they have a kid in the daycare already)");
        print();

        do {
            System.out.printf("\t%-20s | %-25s \n", "> 1. Yes", "> 0. Back" );
            System.out.printf("\t%-20s \n\n", "> 2. No");
            print();
            System.out.print("Select : ");
            choice = Input.checkInt(0, 2);
            print();

            switch (choice){
                case 0:
                    choice = -1;
                    break;
                case 1:
                    for (int i = 0; i < MyApp.getParents().size(); i++){
                        MyApp.getParents().get(i).toStringSimplePrintParent();
                    }
                    print();
                    System.out.print("Please enter the parent ID of the existing parent : ");
                    tempParentID = Input.checkInt(0, (MyApp.getParents().size()-1));

                    //get name
                    System.out.print("First name of the child : ");
                    tempFirstName1 = Input.checkName();

                    //get last name
                    System.out.print("Last name of the child : ");
                    tempLastName1 = Input.checkName();
                    print();

                    //creates child with given information
                    Child tempChild1 = new Child(tempFirstName1, tempLastName1, tempParentID);
                    tempChild1.toStringSimpleChild();
                    return tempChild1;

                case 2:
                    System.out.println("Please add a new parent to the system");
                    System.out.print("First name : ");
                    tempFirstName2 = Input.checkName();

                    System.out.print("Last name : ");
                    tempLastName2 = Input.checkName();

                    System.out.print("Phone number : ");
                    tempPhoneNumber = Input.checkPhoneNr();

                    Parent tempParent = new Parent(tempFirstName2, tempLastName2, tempPhoneNumber);
                    MyApp.getParents().add(tempParent);
                    System.out.println("Parent added to the system!");
                    print();

                    //get name of child
                    System.out.print("First name of the child : ");
                    tempFirstName1 = Input.checkName();

                    //get last name of child
                    System.out.print("Last name of the child : ");
                    tempLastName1 = Input.checkName();
                    print();

                    Child tempChild2 = new Child(tempFirstName1, tempLastName1, tempParent.getParentID());
                    return tempChild2;
                default:
            }

        } while(choice != -1);
        return null;

    }


    //Updating UserInterface attributes
    private void updateEmpList() {
        emp = MyApp.getEmployees();
        adm = MyApp.getAdmins();
        empSize = emp.size();
        admSize = adm.size();
        sumSize = empSize + admSize;
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


    // used in schedule menu
    private void printTextSchedule(String text) {
        int startSpace = ( space_schedule - text.length() ) / 2;
        String stripe = "";
        String startSpaceString = "";
        for (int j = 0; j < space_schedule; j++) {
            stripe += "-";
        }
        for (int i = 0; i < startSpace; i++ ){
            startSpaceString += " ";
        }
        System.out.println( stripe + "\n" + startSpaceString + text + "\n" + stripe );
    }


    private void print() {

        String stripe = "";
        for (int i = 0; i < space; i++) {
            stripe += "-";
        }
        System.out.println(stripe);
    }

    private void printScheduleMenuLine() {
        String stripe = "";
        for (int i = 0; i < space_schedule; i++) {
            stripe += "-";
        }
        System.out.println(stripe);
    }
}

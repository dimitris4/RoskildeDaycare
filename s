[1mdiff --git a/admins.txt b/admins.txt[m
[1mindex 2681bdc..e69de29 100644[m
[1m--- a/admins.txt[m
[1m+++ b/admins.txt[m
[36m@@ -1 +0,0 @@[m
[31m-teodor jonasson 26192327 teodor jonasson 1 1 100[m
[1mdiff --git a/out/production/Roskilde_Daycare/Child.class b/out/production/Roskilde_Daycare/Child.class[m
[1mindex b5ad9a8..40e8c7b 100644[m
Binary files a/out/production/Roskilde_Daycare/Child.class and b/out/production/Roskilde_Daycare/Child.class differ
[1mdiff --git a/out/production/Roskilde_Daycare/Employee.class b/out/production/Roskilde_Daycare/Employee.class[m
[1mindex 01de09d..ef6c7e3 100644[m
Binary files a/out/production/Roskilde_Daycare/Employee.class and b/out/production/Roskilde_Daycare/Employee.class differ
[1mdiff --git a/out/production/Roskilde_Daycare/FileManagement.class b/out/production/Roskilde_Daycare/FileManagement.class[m
[1mindex bee88df..141ca37 100644[m
Binary files a/out/production/Roskilde_Daycare/FileManagement.class and b/out/production/Roskilde_Daycare/FileManagement.class differ
[1mdiff --git a/out/production/Roskilde_Daycare/Input.class b/out/production/Roskilde_Daycare/Input.class[m
[1mdeleted file mode 100644[m
[1mindex b54d24b..0000000[m
Binary files a/out/production/Roskilde_Daycare/Input.class and /dev/null differ
[1mdiff --git a/out/production/Roskilde_Daycare/MyApp.class b/out/production/Roskilde_Daycare/MyApp.class[m
[1mdeleted file mode 100644[m
[1mindex 1f7bab7..0000000[m
Binary files a/out/production/Roskilde_Daycare/MyApp.class and /dev/null differ
[1mdiff --git a/out/production/Roskilde_Daycare/Parent.class b/out/production/Roskilde_Daycare/Parent.class[m
[1mindex 94aa76f..839cfca 100644[m
Binary files a/out/production/Roskilde_Daycare/Parent.class and b/out/production/Roskilde_Daycare/Parent.class differ
[1mdiff --git a/out/production/Roskilde_Daycare/Person.class b/out/production/Roskilde_Daycare/Person.class[m
[1mindex 05c44cf..2d7debd 100644[m
Binary files a/out/production/Roskilde_Daycare/Person.class and b/out/production/Roskilde_Daycare/Person.class differ
[1mdiff --git a/out/production/Roskilde_Daycare/Shift.class b/out/production/Roskilde_Daycare/Shift.class[m
[1mindex dac85ba..d664924 100644[m
Binary files a/out/production/Roskilde_Daycare/Shift.class and b/out/production/Roskilde_Daycare/Shift.class differ
[1mdiff --git a/out/production/Roskilde_Daycare/UserInterface.class b/out/production/Roskilde_Daycare/UserInterface.class[m
[1mdeleted file mode 100644[m
[1mindex a33c17f..0000000[m
Binary files a/out/production/Roskilde_Daycare/UserInterface.class and /dev/null differ
[1mdiff --git a/peopleCount.txt b/peopleCount.txt[m
[1mindex ad94ab9..7813681 100644[m
[1m--- a/peopleCount.txt[m
[1m+++ b/peopleCount.txt[m
[36m@@ -1,3 +1 @@[m
[31m-10[m
[31m-10[m
[31m-10[m
\ No newline at end of file[m
[32m+[m[32m5[m
\ No newline at end of file[m
[1mdiff --git a/src/Admin.java b/src/Admin.java[m
[1mindex ad3a054..655d8c9 100644[m
[1m--- a/src/Admin.java[m
[1m+++ b/src/Admin.java[m
[36m@@ -4,24 +4,12 @@[m [mpublic class Admin extends Employee {[m
     private int adminID;[m
 [m
     // constructors[m
[31m-    public Admin(String firstName, String lastName, String telephone, String username, String password, int personID, int emplyeeID, int adminID) {[m
[31m-        super(firstName, lastName, telephone, username, password, personID, emplyeeID);[m
[31m-        this.adminID = adminID;[m
[31m-        this.setAccessLevel(2);[m
[31m-    }[m
[31m-[m
     public Admin(String firstName, String lastName, String telephone, String username, String password) {[m
         super(firstName, lastName, telephone, username, password);[m
         this.adminID = adminIDCounter++;[m
         this.setAccessLevel(2);[m
     }[m
 [m
[31m-    public Admin(Employee emp) {[m
[31m-        super(emp.getFirstName(), emp.getLastName(), emp.getTelephone(), emp.getUsername(), emp.getPassword());[m
[31m-        this.adminID = adminIDCounter++;[m
[31m-        this.setAccessLevel(2);[m
[31m-    }[m
[31m-[m
     public Admin(int adminID) {[m
         this.adminID = adminID;[m
         adminIDCounter++;[m
[36m@@ -45,10 +33,6 @@[m [mpublic class Admin extends Employee {[m
         return  adminID + " " + getEmployeeID() + " " + getPersonID();[m
     }[m
 [m
[31m-    public String toStringFile() {[m
[31m-        return  adminID + " " + getEmployeeID() + " " + getPersonID();[m
[31m-    }[m
[31m-[m
     public void toStringPrint() {[m
         System.out.printf( "\t %-35s | %-30s | %s \n\t %-35s | %-30s | %s \n",[m
                 "Full name  : " + super.getFirstName() + " " + super.getLastName(), "Username    : " + super.getUsername(), "Phone nr    : " + super.getTelephone(),[m
[1mdiff --git a/src/Child.java b/src/Child.java[m
[1mindex 223be06..8390f7d 100644[m
[1m--- a/src/Child.java[m
[1m+++ b/src/Child.java[m
[36m@@ -10,17 +10,8 @@[m [mpublic class Child extends Person{[m
     private boolean onWaitingList;[m
 [m
     // constructor[m
[31m-    public Child(String firstName, String lastName, int parentID, int personID, int childID) {[m
[31m-        super(firstName, lastName, null);[m
[31m-        this.childID = childID;[m
[31m-        this.setPersonID(personID);[m
[31m-        this.parentID = parentID;[m
[31m-    }[m
[31m-[m
[31m-    public Child(String firstName, String lastName, int parentID) {[m
[31m-        super(firstName, lastName, null);[m
[32m+[m[32m    public Child(int parentID) {[m
         this.childID = childIDCounter++;[m
[31m-        this.setPersonID(super.getPersonID());[m
         this.parentID = parentID;[m
     }[m
 [m
[1mdiff --git a/src/Employee.java b/src/Employee.java[m
[1mindex 7a4914e..42b61c9 100644[m
[1m--- a/src/Employee.java[m
[1m+++ b/src/Employee.java[m
[36m@@ -8,15 +8,6 @@[m [mpublic class Employee extends Person {[m
     private int accessLevel;[m
 [m
     // constructor[m
[31m-    public Employee(String firstName, String lastName, String telephone, String username, String password, int personID, int employeeID) {[m
[31m-        super(firstName, lastName, telephone);[m
[31m-        this.employeeID = employeeID;[m
[31m-        super.setPersonID(personID);[m
[31m-        this.username = username;[m
[31m-        this.password = password;[m
[31m-        this.accessLevel = 1;[m
[31m-    }[m
[31m-[m
     public Employee(String firstName, String lastName, String telephone, String username, String password) {[m
         super(firstName, lastName, telephone);[m
         this.employeeID = employeeIDCounter++;[m
[36m@@ -33,13 +24,6 @@[m [mpublic class Employee extends Person {[m
         this.accessLevel = 1;[m
     }[m
 [m
[31m-    public Employee (Person person) {[m
[31m-        super(person.getFirstName(), person.getLastName(), person.getTelephone());[m
[31m-        this.employeeID = employeeIDCounter++;[m
[31m-        super.setPersonID(person.getPersonID());[m
[31m-        this.accessLevel = 1;[m
[31m-    }[m
[31m-[m
     public Employee () {[m
         this.employeeID = employeeIDCounter++;[m
         super.setPersonID(super.getPersonID());[m
[1mdiff --git a/src/FileManagement.java b/src/FileManagement.java[m
[1mindex a3bcbac..d299c88 100644[m
[1m--- a/src/FileManagement.java[m
[1m+++ b/src/FileManagement.java[m
[36m@@ -1,6 +1,6 @@[m
[32m+[m[32mimport java.awt.image.AreaAveragingScaleFilter;[m
 import java.io.File;[m
 import java.io.FileNotFoundException;[m
[31m-import java.io.PrintStream;[m
 import java.util.ArrayList;[m
 import java.util.Scanner;[m
 [m
[36m@@ -15,7 +15,9 @@[m [mpublic class FileManagement {[m
         // 2 : ArrayList of Workschedules[m
         // 3 : ArrayList of Children[m
         // 4 : ArrayList of Parents[m
[31m-        // 5 : Integer for People count[m
[32m+[m[32m        // 5 : ArrayList of Integers[m
[32m+[m[32m        // 6 : ArrayList of Integers[m
[32m+[m[32m        // 7 : Integer for People count[m
 [m
         //Scanners for each file[m
         Scanner admins = new Scanner("");[m
[36m@@ -29,7 +31,7 @@[m [mpublic class FileManagement {[m
 [m
         //read all files and throw exception[m
         try {[m
[31m-            admins = new Scanner(new File("/Users/teodorjonasson/Desktop/RoskildeDaycare/admins.txt"));[m
[32m+[m[32m            admins = new Scanner(new File(""));[m
             employees = new Scanner(new File(""));[m
             workschedules = new Scanner(new File(""));[m
             children = new Scanner(new File(""));[m
[36m@@ -44,47 +46,24 @@[m [mpublic class FileManagement {[m
         return objectList;[m
     }[m
 [m
[31m-    public void writeToFiles(ArrayList<Object> objectList) throws FileNotFoundException {[m
[31m-[m
[31m-        PrintStream adm = new PrintStream("/Users/teodorjonasson/Desktop/RoskildeDaycare/admins.txt");[m
[31m-        PrintStream emp = new PrintStream("/Users/teodorjonasson/Desktop/RoskildeDaycare/employees.txt");[m
[31m-        PrintStream work = new PrintStream("/Users/teodorjonasson/Desktop/RoskildeDaycare/workSchedules.txt");[m
[31m-        PrintStream ch = new PrintStream("/Users/teodorjonasson/Desktop/RoskildeDaycare/children.txt");[m
[31m-        PrintStream pa = new PrintStream("/Users/teodorjonasson/Desktop/RoskildeDaycare/parents.txt");[m
[31m-        PrintStream counts = new PrintStream("/Users/teodorjonasson/Desktop/RoskildeDaycare/peopleCount.txt");[m
[32m+[m[32m    public void writeToFiles(ArrayList<Object> objectList) {[m
 [m
         // 0 : ArrayList of Admins[m
         // 1 : ArrayList of Employees[m
         // 2 : ArrayList of Workschedules[m
         // 3 : ArrayList of Children[m
         // 4 : ArrayList of Parents[m
[31m-        // 5 : Integer array for People count[m
[32m+[m[32m        // 5 : ArrayList of Integers[m
[32m+[m[32m        // 6 : ArrayList of Integers[m
[32m+[m[32m        // 7 : Integer for People count[m
 [m
[31m-        ArrayList<Admin> admins = (ArrayList<Admin>) objectList.get(0);[m
[32m+[m[32m        ArrayList<Admin> admin = (ArrayList<Admin>) objectList.get(0);[m
         ArrayList<Employee> employees = (ArrayList<Employee>) objectList.get(1);[m
         ArrayList<WorkSchedule> workSchedules = (ArrayList<WorkSchedule>) objectList.get(2);[m
         ArrayList<Child> children = (ArrayList<Child>) objectList.get(3);[m
         ArrayList<Parent> parents = (ArrayList<Parent>) objectList.get(4);[m
[31m-        int[] peopleCount = (int[]) objectList.get(5);[m
[31m-[m
[31m-        for (Admin admin : admins ) {[m
[31m-            adm.println( admin.toStringFile() );[m
[31m-        }[m
[31m-        for (Employee employee : employees ) {[m
[31m-            emp.println( employee.toStringFile() );[m
[31m-        }[m
[31m-        for (WorkSchedule workSchedule : workSchedules ) {[m
[31m-            work.println( workSchedule.toStringFile() );[m
[31m-        }[m
[31m-        for (Child child : children ) {[m
[31m-            ch.println( child.toStringFile() );[m
[31m-        }[m
[31m-        for (Parent parent : parents ) {[m
[31m-            pa.println( parent.toStringFile() );[m
[31m-        }[m
[31m-        for (int i = 0; i < 3; i++ ) {[m
[31m-            counts.println( peopleCount.get(i) );[m
[31m-        }[m
[32m+[m[32m        ArrayList<Integer> telephoneList = (ArrayList<Integer>) objectList.get(5);[m
[32m+[m[32m        ArrayList<Integer> waitingList = (ArrayList<Integer>) objectList.get(6);[m
 [m
     }[m
 }[m
[1mdiff --git a/src/MyApp.java b/src/MyApp.java[m
[1mindex e2df189..94b535c 100644[m
[1m--- a/src/MyApp.java[m
[1m+++ b/src/MyApp.java[m
[36m@@ -12,6 +12,8 @@[m [mpublic class MyApp {[m
     private static ArrayList<WorkSchedule> workSchedules = new ArrayList<>();[m
     private static ArrayList<Child> children = new ArrayList<>();[m
     private static ArrayList<Parent> parents = new ArrayList<>();[m
[32m+[m[32m    private static ArrayList<Integer> telephoneList = new ArrayList<>();[m
[32m+[m[32m    private static ArrayList<Integer> waitingList = new ArrayList<>();[m
 [m
     //ID counts[m
     private static int personID = 4;[m
[36m@@ -51,7 +53,9 @@[m [mpublic class MyApp {[m
         // 2 : ArrayList of Workschedules[m
         // 3 : ArrayList of Children[m
         // 4 : ArrayList of Parents[m
[31m-        // 5 : Integer for People count[m
[32m+[m[32m        // 5 : ArrayList of Integers[m
[32m+[m[32m        // 6 : ArrayList of Integers[m
[32m+[m[32m        // 7 : Integer for People count[m
 [m
         //FOR USE[m
         /*admins = (ArrayList<Admin>) loadedLists.get(0);[m
[36m@@ -59,6 +63,8 @@[m [mpublic class MyApp {[m
         workSchedules = (ArrayList<WorkSchedule>) loadedLists.get(2);[m
         children = (ArrayList<Child>) loadedLists.get(3);[m
         parents = (ArrayList<Parent>) loadedLists.get(4);[m
[32m+[m[32m        telephoneList = (ArrayList<Integer>) loadedLists.get(5);[m
[32m+[m[32m        waitingList = (ArrayList<Integer>) loadedLists.get(6);[m
 [m
         //FOR ID COUNTS[m
         adminID = admins.get(admins.size()-1).getAdminID();[m
[36m@@ -70,20 +76,6 @@[m [mpublic class MyApp {[m
         Admin testUser = new Admin("teodor", "jonasson", "26192327", "teodor", "jonasson");[m
         admins.add(testUser);[m
 [m
[31m-        Parent testParent1 = new Parent("mother", "mom", "11111111");[m
[31m-        parents.add(testParent1);[m
[31m-        Parent testParent2 = new Parent("father", "dad", "22222222");[m
[31m-        parents.add(testParent2);[m
[31m-        Parent testParent3 = new Parent("moose", "max", "33333333");[m
[31m-        parents.add(testParent3);[m
[31m-        [m
[31m-        Child testChild1 = new Child("child", "lack", testParent1.getParentID());[m
[31m-        children.add(testChild1);[m
[31m-        Child testChild2 = new Child("what", "luck", testParent2.getParentID());[m
[31m-        children.add(testChild2);[m
[31m-        Child testChild3 = new Child("ever", "laack", testParent3.getParentID());[m
[31m-        children.add(testChild3);[m
[31m-[m
         Employee test1 = new Employee("mark", "jackson", "23232323", "mark", "jackson");[m
         employees.add(test1);[m
         Employee test2 = new Employee("loui", "lack", "88776655", "loui", "lack");[m
[36m@@ -97,15 +89,15 @@[m [mpublic class MyApp {[m
 [m
         //Create ArrayList for all system info so it can be loaded into FileManagement[m
         ArrayList<Object> systemInfo = new ArrayList<>();[m
[31m-        int[] peopleCount = {personID, employeeID, adminID};[m
[32m+[m
         //Add infoList in CORRECT order[m
         systemInfo.add(admins);[m
         systemInfo.add(employees);[m
         systemInfo.add(workSchedules);[m
         systemInfo.add(children);[m
         systemInfo.add(parents);[m
[31m-        systemInfo.add(peopleCount);[m
[31m-        //systemInfo.add(waitingList);[m
[32m+[m[32m        systemInfo.add(telephoneList);[m
[32m+[m[32m        systemInfo.add(waitingList);[m
 [m
         //Send ArrayList to FileManagement to update files.[m
         FM.writeToFiles(systemInfo);[m
[36m@@ -331,21 +323,21 @@[m [mpublic class MyApp {[m
         MyApp.parents = parents;[m
     }[m
 [m
[31m-    /*//returns a list of personIDs for each phone nr[m
[32m+[m[32m    //returns a list of personIDs for each phone nr[m
     public static ArrayList<Integer> getTelephoneList() {[m
         return telephoneList;[m
[31m-    }*/[m
[32m+[m[32m    }[m
 [m
[31m-    /*public static void setTelephoneList(ArrayList<Integer> telephoneList) {[m
[32m+[m[32m    public static void setTelephoneList(ArrayList<Integer> telephoneList) {[m
         MyApp.telephoneList = telephoneList;[m
[31m-    }*/[m
[32m+[m[32m    }[m
 [m
[31m-    /*public static ArrayList<Integer> getWaitingList() {[m
[32m+[m[32m    public static ArrayList<Integer> getWaitingList() {[m
         return waitingList;[m
[31m-    }*/[m
[32m+[m[32m    }[m
 [m
[31m-    /*public static void setWaitingList(ArrayList<Integer> waitingList) {[m
[32m+[m[32m    public static void setWaitingList(ArrayList<Integer> waitingList) {[m
         MyApp.waitingList = waitingList;[m
[31m-    }*/[m
[32m+[m[32m    }[m
 [m
 }[m
[1mdiff --git a/src/Parent.java b/src/Parent.java[m
[1mindex 711f347..55a27f1 100644[m
[1m--- a/src/Parent.java[m
[1m+++ b/src/Parent.java[m
[36m@@ -6,18 +6,6 @@[m [mpublic class Parent extends Person {[m
     private static int parentIDCounter = 0;[m
 [m
     // constructor[m
[31m-    public Parent(String firstName, String lastName, String telephone, int personID, int parentID) {[m
[31m-        super(firstName, lastName, telephone);[m
[31m-        this.setPersonID(personID);[m
[31m-        this.parentID = parentID;[m
[31m-    }[m
[31m-[m
[31m-    public Parent(String firstName, String lastName, String telephone) {[m
[31m-        super(firstName, lastName, telephone);[m
[31m-        this.setPersonID(super.getPersonID());[m
[31m-        this.parentID = parentIDCounter++;[m
[31m-    }[m
[31m-[m
     public Parent() {[m
         this.parentID = parentIDCounter++;[m
     }[m
[1mdiff --git a/src/Shift.java b/src/Shift.java[m
[1mindex b8a45a1..401df1c 100644[m
[1m--- a/src/Shift.java[m
[1m+++ b/src/Shift.java[m
[36m@@ -1,7 +1,6 @@[m
 import java.util.Date;[m
 [m
 public class Shift {[m
[31m-[m
     private int shiftID;[m
     private static int shiftIDCounter = 1;[m
     private int workScheduleID;[m
[1mdiff --git a/src/UserInterface.java b/src/UserInterface.java[m
[1mindex fa73d56..d1bac01 100644[m
[1m--- a/src/UserInterface.java[m
[1m+++ b/src/UserInterface.java[m
[36m@@ -2,7 +2,6 @@[m [mimport java.util.ArrayList;[m
 [m
 class UserInterface {[m
 [m
[31m-    //TEST[m
     private int space = 110;[m
     private ArrayList<Employee> emp = MyApp.getEmployees();[m
     private ArrayList<Admin> adm = MyApp.getAdmins();[m
[36m@@ -134,7 +133,7 @@[m [mclass UserInterface {[m
 [m
                     boolean type = false;[m
                     //Regular employee[m
[31m-                    if (empSelection < empSize) {[m
[32m+[m[32m                    if (empSelection > empSize) {[m
                         //Print employee selection to verify it was the right selection[m
                         emp.get(empSelection).toStringPrint();[m
                     }[m
[36m@@ -206,30 +205,45 @@[m [mclass UserInterface {[m
 [m
     private void hireEmployee() {[m
 [m
[31m-        //Create person with firstName, lastName and phoneNr[m
[31m-        Employee newEmp = new Employee(createPerson(false));[m
[32m+[m[32m        Employee newEmp = new Employee();[m
         boolean check = false;[m
 [m
[31m-        //Admin / Employee choice[m
[31m-        print();[m
[32m+[m[32m        printText("- Hire new employee - ");[m
         System.out.println("\tWhat type of employee are you creating?");[m
         System.out.printf("\n\t%-20s | %s", "> 1. Regular Employee", "> 2. Administartor \n\n");[m
         print();[m
         System.out.print("Select: ");[m
[31m-        int selectType = Input.checkInt(1, 2);[m
[32m+[m[32m        int select = Input.checkInt(1, 2);[m
             //only occurs if user selects administrator, otherwise newEmp remains an Employee object[m
[31m-        if (selectType==2) {[m
[31m-            System.out.println(" - Administrator - ");[m
[32m+[m[32m        if (select==2) {[m
[32m+[m[32m            newEmp = new Admin(MyApp.getAdminID()+1);[m
[32m+[m[32m            MyApp.setAdminID(MyApp.getAdminID()+1);[m
[32m+[m[32m            text(" - Administrator - ");[m
         } else {[m
[31m-            System.out.println(" - Employee - ");[m
[32m+[m[32m            text(" - Employee - ");[m
         }[m
 [m
[31m-        //Create Username[m
[32m+[m[32m        //Get first name[m
[32m+[m[32m        System.out.print("First name       : ");[m
[32m+[m[32m        String firstName = Input.checkName();[m
[32m+[m[32m        newEmp.setFirstName(firstName);[m
[32m+[m
[32m+[m[32m        //Get last name[m
[32m+[m[32m        System.out.print("Last name        : ");[m
[32m+[m[32m        String lastName = Input.checkName();[m
[32m+[m[32m        newEmp.setLastName(lastName);[m
[32m+[m
[32m+[m[32m        //Get PhoneNr[m
[32m+[m[32m        System.out.print("Phone nr         : ");[m
[32m+[m[32m        String phoneNr = Input.checkPhoneNr();[m
[32m+[m[32m        newEmp.setTelephone(phoneNr);[m
[32m+[m
[32m+[m[32m        //Get Username[m
         System.out.print("Username         : ");[m
         String username = Input.checkUsername();[m
         newEmp.setUsername(username);[m
 [m
[31m-        //Create password[m
[32m+[m[32m        //Get password[m
         String pass1 = "";[m
         String pass2 = "";[m
         int checkNr = 2;[m
[36m@@ -248,47 +262,28 @@[m [mclass UserInterface {[m
         //All info recieved[m
         //Print info to and ask to save[m
         print();[m
[31m-        newEmp.toStringSimplePrint();[m
[32m+[m[32m        newEmp.toStringPrint();[m
         print();[m
         System.out.print("Save profile?\n1. yes, 2. no    : ");[m
         checkNr = Input.checkInt(1, 2);[m
         if (checkNr == 1) {[m
[32m+[m
             //Add new employee to MyApp and update UI employee lists[m
[31m-            if (selectType == 2) {[m
[31m-                newEmp = new Admin(newEmp);[m
[32m+[m[32m            if (newEmp instanceof Admin) {[m
                 MyApp.addAdmin( (Admin) newEmp);[m
             } else {[m
                 MyApp.addEmployee(newEmp);[m
             }[m
             updateEmpList();[m
[31m-        } else {[m
[31m-            System.out.println("** Cancelled new employee ** ");[m
         }[m
     }[m
 [m
[31m-    private Person createPerson(boolean isChild) {[m
[31m-[m
[31m-        Person newPerson = new Person();[m
[31m-[m
[31m-        //Get first name[m
[31m-        System.out.print("First name       : ");[m
[31m-        String firstName = Input.checkName();[m
[31m-        newPerson.setFirstName(firstName);[m
[31m-[m
[31m-        //Get last name[m
[31m-        System.out.print("Last name        : ");[m
[31m-        String lastName = Input.checkName();[m
[31m-        newPerson.setLastName(lastName);[m
[31m-[m
[31m-        if (!isChild) {[m
[31m-            //Get PhoneNr[m
[31m-            System.out.print("Phone nr         : ");[m
[31m-            String phoneNr = Input.checkPhoneNr();[m
[31m-            newPerson.setTelephone(phoneNr);[m
[31m-        } else {[m
[31m-            newPerson.setTelephone(null);[m
[31m-        }[m
[31m-        return newPerson;[m
[32m+[m[32m    private void updateEmpList() {[m
[32m+[m[32m        emp = MyApp.getEmployees();[m
[32m+[m[32m        adm = MyApp.getAdmins();[m
[32m+[m[32m        empSize = emp.size();[m
[32m+[m[32m        admSize = adm.size();[m
[32m+[m[32m        sumSize = empSize + admSize;[m
     }[m
 [m
     private void changeInfo(Employee emp) {[m
[36m@@ -309,23 +304,63 @@[m [mclass UserInterface {[m
             switch (choice) {[m
                 //Change first name[m
                 case 1:[m
[31m-                    emp.setFirstName(newInfo("name     : ", emp.getFirstName(), 1));[m
[32m+[m[32m                    System.out.println("Current name   : " + emp.getFirstName());[m
[32m+[m[32m                    System.out.print("New name         : ");[m
[32m+[m[32m                    String newName = Input.checkName();[m
[32m+[m[32m                    System.out.print("Correct name     : " + newName + "?\n1. yes, 2. no    : ");[m
[32m+[m[32m                    int assurance = Input.checkInt(1, 2);[m
[32m+[m[32m                    if (assurance == 1) {[m
[32m+[m[32m                        emp.setFirstName(newName);[m
[32m+[m[32m                        System.out.println("** First name changed **");[m
[32m+[m[32m                    }[m
                     break;[m
                 //Change username[m
                 case 2:[m
[31m-                    emp.setUsername(newInfo("username : ", emp.getUsername(), 2));[m
[32m+[m[32m                    System.out.println("Current username  : " + emp.getUsername());[m
[32m+[m[32m                    System.out.print(  "New username      : ");[m
[32m+[m[32m                    String newUsername = Input.checkName();[m
[32m+[m[32m                    System.out.print(  "new username      : " + newUsername + "?\n1. yes, 2. no     : ");[m
[32m+[m[32m                    assurance = Input.checkInt(1, 2);[m
[32m+[m[32m                    if (assurance == 1) {[m
[32m+[m[32m                        emp.setUsername(newUsername);[m
[32m+[m[32m                        System.out.println("** Username changed **");[m
[32m+[m[32m                    }[m
                     break;[m
                 //Change last name[m
                 case 3:[m
[31m-                    emp.setLastName(newInfo("last name: ", emp.getLastName(), 1));[m
[32m+[m[32m                    System.out.println("Current last name : " + emp.getLastName());[m
[32m+[m[32m                    System.out.print(  "New last name     : ");[m
[32m+[m[32m                    String newLastName = Input.checkName();[m
[32m+[m[32m                    System.out.print("New last name : " + newLastName + "?\n1. yes, 2. no     : ");[m
[32m+[m[32m                    assurance = Input.checkInt(1, 2);[m
[32m+[m[32m                    if (assurance == 1) {[m
[32m+[m[32m                        emp.setLastName(newLastName);[m
[32m+[m[32m                        System.out.println("** Last name changed **");[m
[32m+[m[32m                    }[m
                     break;[m
                 //Change password[m
                 case 4:[m
[31m-                    emp.setPassword(newInfo("password  : ", emp.getPassword(), 2));[m
[32m+[m[32m                    System.out.println("Current password  : ********** ");[m
[32m+[m[32m                    System.out.print(  "New password      : ");[m
[32m+[m[32m                    String newPassword = Input.checkUsername();[m
[32m+[m[32m                    System.out.print("New password : " + newPassword + "?\n1. yes, 2. no     : ");[m
[32m+[m[32m                    assurance = Input.checkInt(1, 2);[m
[32m+[m[32m                    if (assurance == 1) {[m
[32m+[m[32m                        emp.setPassword(newPassword);[m
[32m+[m[32m                        System.out.println("** Password changed **");[m
[32m+[m[32m                    }[m
                     break;[m
                 //Change phoneNr[m
                 case 5:[m
[31m-                    emp.setTelephone(newInfo("phoneNr  : ", emp.getTelephone(), 3));[m
[32m+[m[32m                    System.out.println("Current phoneNr   : " + emp.getTelephone());[m
[32m+[m[32m                    System.out.print(  "New phoneNr       : ");[m
[32m+[m[32m                    String newTelephone = Input.checkPhoneNr();[m
[32m+[m[32m                    System.out.print("New phoneNR : " + newTelephone + "?\n1. yes, 2. no     : ");[m
[32m+[m[32m                    assurance = Input.checkInt(1, 2);[m
[32m+[m[32m                    if (assurance == 1) {[m
[32m+[m[32m                        emp.setTelephone(newTelephone);[m
[32m+[m[32m                        System.out.println("** Telephone nr changed **");[m
[32m+[m[32m                    }[m
                     break;[m
                 //Print current Employee info[m
                 case 6:[m
[36m@@ -357,41 +392,16 @@[m [mclass UserInterface {[m
         }[m
     }[m
 [m
[31m-    private String newInfo(String comment, String info, int type) {[m
[31m-[m
[31m-        String newInfo = "";[m
[31m-        System.out.println("Current " + comment + info);[m
[31m-        System.out.print(  "New info         : ");[m
[31m-        if(type == 1 ) {[m
[31m-            newInfo = Input.checkName();[m
[31m-        } else if ( type == 2 ) {[m
[31m-            newInfo = Input.checkUsername();[m
[31m-        } else {[m
[31m-            newInfo = Input.checkPhoneNr();[m
[31m-        }[m
[31m-        System.out.print("Correct info     : " + newInfo + "?\n1. yes, 2. no    : ");[m
[31m-        int assurance = Input.checkInt(1, 2);[m
[31m-        if (assurance == 1) {[m
[31m-            System.out.println("** Profile changed **");[m
[31m-            return newInfo;[m
[31m-        } else {[m
[31m-            System.out.println("** Profile change cancelled **");[m
[31m-            return info;[m
[31m-        }[m
[31m-    }[m
[31m-[m
     private void employeeListPrint(){[m
 [m
         //display full employee list[m
[31m-        printText(" - Employee list -");[m
[32m+[m[32m        text(" - Employee list -");[m
         for (int i = 0; i < empSize; i++) {[m
[31m-            System.out.print("\t> " + i + ". " );[m
[31m-            emp.get(i).toStringSimplePrint();[m
[32m+[m[32m            System.out.println("\t> " + i + ". " + emp.get(i).getFirstName() + " " + emp.get(i).getLastName());[m
         }[m
[31m-        printText(" - Admins -");[m
[32m+[m[32m        text(" - Admins -");[m
         for (int i = empSize; i < admSize + empSize; i++) {[m
[31m-            System.out.print("\t> " + i + ". " );[m
[31m-            adm.get(i-empSize).toStringSimplePrint();[m
[32m+[m[32m            System.out.println("\t> " + i + ". " + adm.get(i-empSize).getFirstName() + " " + adm.get(i-empSize).getLastName());[m
         }[m
     }[m
 [m
[36m@@ -415,15 +425,6 @@[m [mclass UserInterface {[m
         printText("- EMPLOYEE MENU - ");[m
     }[m
 [m
[31m-    //Updating UserInterface attributes[m
[31m-    private void updateEmpList() {[m
[31m-        emp = MyApp.getEmployees();[m
[31m-        adm = MyApp.getAdmins();[m
[31m-        empSize = emp.size();[m
[31m-        admSize = adm.size();[m
[31m-        sumSize = empSize + admSize;[m
[31m-    }[m
[31m-[m
     //FORMATTING  -- ONLY USED WITHIN THE CLASS --[m
     private void printText(String text) {[m
 [m
[1mdiff --git a/src/WorkSchedule.java b/src/WorkSchedule.java[m
[1mindex 98f0350..9de2877 100644[m
[1m--- a/src/WorkSchedule.java[m
[1m+++ b/src/WorkSchedule.java[m
[36m@@ -28,7 +28,5 @@[m [mpublic class WorkSchedule {[m
     public String toString() {[m
         return workScheduleID + " " + employeeID;[m
     }[m
[31m-[m
[31m-[m
 }[m
 [m

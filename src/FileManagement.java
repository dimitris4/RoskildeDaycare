import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class FileManagement {


    // constructor
    public FileManagement() { }


    /****************************************************************/
    /*            methods for reading data from files               */
    /****************************************************************/

    public ArrayList<Admin> readAdminsFromFile() {
        Scanner input = null;
        try {
            input = new Scanner(new File("admins.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
        ArrayList<Admin> admins = new ArrayList<Admin>();
        while (input.hasNextLine()) {
            String line = input.nextLine();
            System.out.println(line);
            Scanner data = new Scanner(line);
            Admin admin = new Admin();
            while (data.hasNext()) {
                //admin.setAdminID(Integer.parseInt(data.next()));
                //admin.setEmployeeID(Integer.parseInt(data.next()));
                admin.setUsername(data.next());
                admin.setPassword(data.next());
                admin.setAccessLevel(Integer.parseInt(data.next()));
                //admin.setPersonID(Integer.parseInt(data.next()));
                admin.setFirstName(data.next());
                admin.setLastName(data.next());
                admin.setTelephone(data.next());
            }
            admins.add(admin);
            data.close();
        }
        return admins;
    }

    public ArrayList<Employee> readEmployeesFromFile() {
        Scanner input = null;
        try {
            input = new Scanner(new File("employees.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
        ArrayList<Employee> employees = new ArrayList<Employee>();
        while (input.hasNextLine()) {
            String line = input.nextLine();
            System.out.println(line);
            Scanner data = new Scanner(line);
            Employee employee = new Employee();
            while (data.hasNext()) {
                //employee.setEmployeeID(Integer.parseInt(data.next()));
                employee.setUsername(data.next());
                employee.setPassword(data.next());
                employee.setAccessLevel(Integer.parseInt(data.next()));
                //employee.setPersonID(Integer.parseInt(data.next()));
                employee.setFirstName(data.next());
                employee.setLastName(data.next());
                employee.setTelephone(data.next());
            }
            employees.add(employee);
            data.close();
        }
        return employees;
    }

    public ArrayList<WorkSchedule> readWorkSchedulesFromFile() {
        Scanner input = null;
        try {
            input = new Scanner(new File("workSchedules.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
        ArrayList<WorkSchedule> workSchedules = new ArrayList<WorkSchedule>();
        while (input.hasNextLine()) {
            String line = input.nextLine();
            System.out.println(line);
            Scanner data = new Scanner(line);
            WorkSchedule wc = new WorkSchedule();
            if (data.hasNext()) {
                wc.setEmployeeID(Integer.parseInt(data.next()));
            }
            ArrayList<Shift> shifts = new ArrayList<Shift>();
            while (data.hasNext()) {
                String str = data.next() + " " + data.next();
                String str2 = data.next() + " " + data.next();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                Date startingDate = null;
                Date endingDate = null;
                try {
                    startingDate = sdf.parse(str);
                    endingDate = sdf.parse(str2);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                shifts.add(new Shift(startingDate, endingDate));
            }
            workSchedules.add(wc);
        }
        return workSchedules;
    }


    public ArrayList<Child> readChildrenFromFile() {
        Scanner input = null;
        try {
            input = new Scanner(new File("children.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
        ArrayList<Child> children = new ArrayList<Child>();
        while (input.hasNextLine()) {
            String line = input.nextLine();
            System.out.println(line);
            Scanner data = new Scanner(line);
            Child child = new Child();
            while (data.hasNext()) {
                //child.setChildID(Integer.parseInt(data.next()));
                //child.setParentID(Integer.parseInt(data.next()));
                child.setOnWaitingList(data.nextBoolean());
                //child.setPersonID(Integer.parseInt(data.next()));
                child.setFirstName(data.next());
                child.setLastName(data.next());
            }
            children.add(child);
            data.close();
        }
        return children;
    }

    public ArrayList<Parent> readParentsFromFile() {
        Scanner input = null;
        try {
            input = new Scanner(new File("parents.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
        ArrayList<Parent> parents = new ArrayList<Parent>();
        while (input.hasNextLine()) {
            String line = input.nextLine();
            System.out.println(line);
            Scanner data = new Scanner(line);
            Parent parent = new Parent();
            while (data.hasNext()) {
                //parent.setParentID(Integer.parseInt(data.next()));
                //parent.setPersonID(Integer.parseInt(data.next()));
                parent.setFirstName(data.next());
                parent.setLastName(data.next());
                parent.setTelephone(data.next());
            }
            parents.add(parent);
            data.close();
        }
        return parents;
    }

    public ArrayList<Person> readPeopleFromFile() {
        Scanner input = null;
        try {
            input = new Scanner(new File("people.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
        ArrayList<Person> people = new ArrayList<Person>();
        while (input.hasNextLine()) {
            String line = input.nextLine();
            System.out.println(line);
            Scanner data = new Scanner(line);
            Person person = new Person();
            while (data.hasNext()) {
                //person.setPersonID(Integer.parseInt(data.next()));
                person.setFirstName(data.next());
                person.setLastName(data.next());
                person.setTelephone(data.next());
            }
            people.add(person);
            data.close();
        }
        return people;
    }



    /**********************************************************/
    /*          methods for finding the next ID number        */
    /**********************************************************/

    /*public int countNumberEmployeeFromFile() {
        Scanner input = null;
        try {
            input = new Scanner(new File("employees.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
        int counter = 0;
        while (input.hasNextLine()) {
            counter++;
        }
        return counter;
    }

    public int countNumberAdminsFromFile() {
        Scanner input = null;
        try {
            input = new Scanner(new File("admins.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
        int counter = 0;
        while (input.hasNextLine()) {
            counter++;
        }
        return counter;
    }

    public int countNumberChildrenFromFile() {
        Scanner input = null;
        try {
            input = new Scanner(new File("children.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
        int counter = 0;
        while (input.hasNextLine()) {
            counter++;
        }
        return counter;
    }

    public int countNumberParentsFromFile() {
        Scanner input = null;
        try {
            input = new Scanner(new File("parents.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
        int counter = 0;
        while (input.hasNextLine()) {
            counter++;
        }
        return counter;
    }

    public int countNumberPeopleFromFile() {
        Scanner input = null;
        try {
            input = new Scanner(new File("people.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
        int counter = 0;
        while (input.hasNextLine()) {
            counter++;
        }
        return counter;
    }*/



    /**************************************************/
    /*           methods for writing to files         */
    /**************************************************/

    public void saveAdminsToFile(ArrayList<Admin> admins) throws FileNotFoundException {
        PrintStream output = new PrintStream(new File("admins.txt"));
        for (int i = 0; i < admins.size(); i++) {
            output.println(admins.get(i));
        }
    }

    public void saveEmployeesToFile(ArrayList<Employee> employees) throws FileNotFoundException {
        PrintStream output = new PrintStream(new File("workSchedules.txt"));
        for (int i = 0; i < employees.size(); i++) {
            output.println(employees.get(i));
        }
    }

    public void saveWorkSchedulesToFile(ArrayList<WorkSchedule> workSchedules) throws FileNotFoundException {
        PrintStream output = new PrintStream(new File("workSchedules.txt"));
        for (int i = 0; i < workSchedules.size(); i++) {
            output.println(workSchedules.get(i));
        }
    }

    public void saveChildrenToFile(ArrayList<Child> children) throws FileNotFoundException {
        PrintStream output = new PrintStream(new File("children.txt"));
        for (int i = 0; i < children.size(); i++) {
            output.println(children.get(i));
        }
    }

    public void saveParentsToFile(ArrayList<Parent> parents) throws FileNotFoundException {
        PrintStream output = new PrintStream(new File("parents.txt"));
        for (int i = 0; i < parents.size(); i++) {
            output.println(parents.get(i));
        }
    }

    public void savePeopleToFile(ArrayList<Person> people) throws FileNotFoundException {
        PrintStream output = new PrintStream(new File("people.txt"));
        for (int i = 0; i < people.size(); i++) {
            output.println(people.get(i));
        }
    }
}

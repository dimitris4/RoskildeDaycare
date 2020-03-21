import java.util.ArrayList;

public class FileManagement {

    public ArrayList<Object> readFromFiles() {

        ArrayList<Object> objectList = new ArrayList<>();
        // needs to return an ArrayList of Objects in the CORRECT order (very important)
        // 0 : Admin user
        // 1 : ArrayList of Employees
        // 2 : ArrayList of Workschedules
        // 3 : ArrayList of Children
        // 4 : ArrayList of Parents
        // 5 : ArrayList of Integers
        // 6 : ArrayList of Integers
        return objectList;

    }

    public void writeToFiles(ArrayList<Object> objectList) {

        // 0 : Admin user
        // 1 : ArrayList of Employees
        // 2 : ArrayList of Workschedules
        // 3 : ArrayList of Children
        // 4 : ArrayList of Parents
        // 5 : ArrayList of Integers
        // 6 : ArrayList of Integers

        Admin admin = (Admin) objectList.get(0);
        ArrayList<Employee> employees = (ArrayList<Employee>) objectList.get(1);
        ArrayList<WorkSchedule> workSchedules = (ArrayList<WorkSchedule>) objectList.get(2);
        ArrayList<Child> children = (ArrayList<Child>) objectList.get(3);
        ArrayList<Parent> parents = (ArrayList<Parent>) objectList.get(4);
        ArrayList<Integer> telephoneList = (ArrayList<Integer>) objectList.get(5);
        ArrayList<Integer> waitingList = (ArrayList<Integer>) objectList.get(6);

    }
}

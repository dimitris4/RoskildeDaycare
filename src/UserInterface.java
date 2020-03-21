public class UserInterface {

    private int space = 100;

    public Employee logInMenu() {

        Employee user = null;
        String username = "";
        String password = "";
        Boolean login = false;

        printText("- LOGIN -");

        while (!login){

            System.out.println("Write username : ");
            //Get username
            username = Input.checkUsername();

            //find match
            user = findUser(username);

            if (user == null) {
                System.out.println("** no matching username **");
            } else {
                System.out.println("Password : ");
                //Check password
                password = Input.checkUsername();

                if (user.getPassword().equals(password)) {
                    printText("** login success **");
                    login = true;
                } else {
                    System.out.println("** Wrong password **");
                }
            }
        }
        return user;
    }

    public Employee findUser (String username) {

        Employee emp = null;

        //looks through userLogIn to find username match with username string
        for (String user : MyApp.getUserLogIn().keySet()) {
            if (username.trim().equals(user)) {
                emp = MyApp.getEmployee(user);
            }
        }
        return emp;
    }

    public void adminMenu() {
        printText("- ADMIN MENU - ");
    }

    public void employeeMenu() {
        printText("- EMPLOYEE MENU - ");
    }

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
}

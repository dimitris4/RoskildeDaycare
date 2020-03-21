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

            //find match from username : returns null if there was no match
            //otherwise return Employee object of user.
            user = MyApp.getEmployee(username);

            //checks to see if there was a user match with username
            if (user == null) {
                System.out.println("** no matching username **");
            } else {

                //asks for password matching username
                System.out.println("Password : ");
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
    }

    public void employeeMenu() {
        printText("- EMPLOYEE MENU - ");
    }

    //Just for formatting
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

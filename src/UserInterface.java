public class UserInterface {

    private int space = 100;

    public Employee logInMenu() {
        printText("- LOGIN -");

        return null;
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

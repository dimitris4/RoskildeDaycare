public class MyApp {
    public static void main(String[] args) {
        FileManagement fileManagement = new FileManagement();
        fileManagement.readFromFiles();
        UserInterface userInterface = new UserInterface();
        userInterface.mainMenu();
    }
}
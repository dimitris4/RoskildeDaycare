import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

class Input {

    private static Scanner in = new Scanner(System.in);

    public static String checkUsername() {

        boolean isValid = false;
        String input = "";

        while (!isValid) {
            isValid = true;
            input = in.nextLine().trim();
            if (input.length() > 15) {
                System.out.println("Too long, please try again");
                isValid = false;
                input = "";
            } else if (input.length() < 3) {
                System.out.println("Too short, please try again");
                isValid = false;
                input = "";
            } else if (input.contains(" ")) {
                System.out.println("Write one word, please try again");
                isValid = false;
                input = "";
            }
        }
        return input;
    }

    public static String checkName() {

        boolean isValid = false;
        String input = "";

        while (!isValid) {
            isValid = true;
            input = in.nextLine().trim();
            if (input.length() > 15) {
                System.out.println("Too long, please try again");
                isValid = false;
                input = "";
            } else if (input.contains(" ")) {
                System.out.println("Write one word, please try again");
                isValid = false;
                input = "";
            } else {
                for (int i = 0; i < input.length(); i++) {
                    if (Character.isDigit(input.charAt(i))) {
                        System.out.println("Only letters, please try again");
                        input = "";
                        isValid = false;
                        in.next();
                    }
                }
            }
        }
        return input;
    }

    public static String checkPhoneNr() {

        boolean isValid = false;
        String input = "";

        while (!isValid) {
            isValid = true;
            input = in.nextLine();
            input.replace(" ", "");
            if ((input.length() != 8)) {
                System.out.println("The phone number has to be 'xxxxxxxx' numbers only");
                isValid = false;
                input = "";
            } else {
                for (int i = 0; i < input.length(); i++) {
                    if (!Character.isDigit(input.charAt(i))) {
                        System.out.println("Only numbers, please try again");
                        input = "";
                        isValid = false;
                        in.next();
                    }
                }
            }
        }
        return input;
    }

    public static int checkInt(int min, int max) {

        boolean isValid = false;
        String input = "";
        while (!isValid) {
            isValid = true;
            if (in.hasNextInt()) {
                input = in.next().trim();
                if (Integer.parseInt(input) > min - 1 && Integer.parseInt(input) < max + 1) {
                    isValid = true;
                } else {
                    isValid = false;
                    System.out.println("The number isn't in our system, try another one: ");
                    input = "";
                }
            } else {
                isValid = false;
                in.next();
                System.out.println("only numbers please, try again:");
            }
        }
        in.nextLine();
        return Integer.parseInt(input);
    }

    public static Date insertDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Scanner console = new Scanner(System.in);
        String str = console.nextLine();
        Date date;
        while (true) {
            try {
                date = sdf.parse(str);
                sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
                break;
            } catch (ParseException e) {
                System.out.print("Day must have the following format (dd-MM-yyyy HH:mm): ");
                str = console.nextLine();
                continue;
            }
        }
        return date;
    }

    public static int diffInDays(Date date1, Date date2) {
        long diffInMillies = Math.abs(date2.getTime() - date1.getTime());
        return (int) TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
    }

    public static Date insertDateWithoutTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Scanner console = new Scanner(System.in);
        String str = console.nextLine();
        Date date;
        while (true) {
            try {
                date = sdf.parse(str);
                sdf = new SimpleDateFormat("dd-MM-yyyy");
                break;
            } catch (ParseException e) {
                System.out.print("Day must have the following format (dd-mm-yyyy): ");
                str = console.nextLine();
                continue;
            }
        }
        return date;
    }
}
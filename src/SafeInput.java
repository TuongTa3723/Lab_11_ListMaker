import java.util.Scanner;

public class SafeInput {

    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String input = "";
        do {
            System.out.print(prompt + " ");
            input = pipe.nextLine();
            if (input.length() == 0) {
                System.out.println("You must enter some text!");
            }
        } while (input.length() == 0);
        return input;
    }

    public static String getRegExString(Scanner pipe, String prompt, String regEx) {
        String input = "";
        boolean valid = false;

        do {
            System.out.print(prompt + " ");
            input = pipe.nextLine();
            if (input.matches(regEx)) {
                valid = true;
            } else {
                System.out.println("Invalid input. Try again!");
            }
        } while (!valid);

        return input;
    }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int result = 0;
        boolean valid = false;

        do {
            System.out.print(prompt + " [" + low + " - " + high + "]: ");
            if (pipe.hasNextInt()) {
                result = pipe.nextInt();
                if (result >= low && result <= high) {
                    valid = true;
                } else {
                    System.out.println("Number is out of range!");
                }
            } else {
                System.out.println("Invalid input. Not an integer.");
            }
            pipe.nextLine(); // clear buffer
        } while (!valid);

        return result;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        String input;
        boolean valid = false;
        boolean result = false;

        do {
            System.out.print(prompt + " [Y/N]: ");
            input = pipe.nextLine();
            if (input.equalsIgnoreCase("Y")) {
                result = true;
                valid = true;
            } else if (input.equalsIgnoreCase("N")) {
                result = false;
                valid = true;
            } else {
                System.out.println("Invalid input. Please enter Y or N.");
            }
        } while (!valid);

        return result;
    }
}
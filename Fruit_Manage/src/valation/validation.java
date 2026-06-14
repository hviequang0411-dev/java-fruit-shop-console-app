// ============================
// validation/Validation.java
// ============================

package valation;

import java.util.Scanner;

public class validation {

    private static final Scanner sc = new Scanner(System.in);

    // input string
    public static String getString(String msg) {

        while (true) {

            System.out.print(msg);

            String input = sc.nextLine().trim();

            if (!input.isEmpty()) {
                return input;
            }

            System.out.println("Input cannot be empty!");
        }
    }

    // input integer
    public static int getInt(String msg,
                             int min,
                             int max) {

        while (true) {

            try {

                System.out.print(msg);

                int n = Integer.parseInt(sc.nextLine());

                if (n >= min && n <= max) {
                    return n;
                }

                System.out.println(
                        "Input from " + min + " to " + max);

            } catch (NumberFormatException e) {

                System.out.println("Invalid number!");
            }
        }
    }

    // input double
    public static double getDouble(String msg,
                                   double min,
                                   double max) {

        while (true) {

            try {

                System.out.print(msg);

                double n = Double.parseDouble(sc.nextLine());

                if (n >= min && n <= max) {
                    return n;
                }

                System.out.println(
                        "Input from " + min + " to " + max);

            } catch (NumberFormatException e) {

                System.out.println("Invalid number!");
            }
        }
    }

    // yes/no
    public static boolean getYesNo(String msg) {

        while (true) {

            String choice = getString(msg);

            if (choice.equalsIgnoreCase("Y")) {
                return true;
            }

            if (choice.equalsIgnoreCase("N")) {
                return false;
            }

            System.out.println("Only Y or N!");
        }
    }
}
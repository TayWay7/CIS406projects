package courseProject;

import java.util.Scanner;

public class DataEntry {
    private static Scanner scanner = new Scanner(System.in);


    public static String entryString(String prompt) {
        System.out.print(prompt + ": ");
        return scanner.nextLine();

}

    public static String entryStringWithLimit(String prompt, int maxLength) {
        String input;
        do {
            System.out.print(prompt + " (max " + maxLength + " characters): ");
            input = scanner.nextLine();
        } while (input.length() > maxLength);
        return input;
    }
    
    public static String entryNumericString(String prompt, int length) {
        String input;
        do {
            System.out.print(prompt + " (exactly " + length + " digits): ");
            input = scanner.nextLine();
        } while (input.length() != length || !input.matches("\\d+"));
        return input;
    }
    
    public static int entryInteger(String prompt) {
        System.out.print(prompt + ": ");
        return scanner.nextInt();
    }
    
    public static int entryIntegerWithLimit(String prompt, int min, int max) {
        int input;
        do {
            System.out.print(prompt + " (" + min + " - " + max + "): ");
            input = scanner.nextInt();
        } while (input < min || input > max);
        return input;
    }
    
    public static double entryDecimal(String prompt) {
        System.out.print(prompt + ": ");
        return scanner.nextDouble();
    }
    public static double entryDecimalWithLimit(String prompt, double min, double max) {
        double input;
        do {
            System.out.print(prompt + " (" + min + " - " + max + "): ");
            input = scanner.nextDouble();
        } while (input < min || input > max);
        return input;
    }
    public static String entryDate(String prompt) {
        System.out.print(prompt + " (format: YYYY-MM-DD): ");
        return scanner.next();
    }
}

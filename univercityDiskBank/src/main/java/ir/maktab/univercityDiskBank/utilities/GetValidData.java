package ir.maktab.univercityDiskBank.utilities;
import java.util.Scanner;
import static ir.maktab.univercityDiskBank.utilities.ConsoleColors.*;

public class GetValidData {
    public static Scanner input = new Scanner(System.in);

    public static int getValidInt(String message) {
        System.out.print(BLUE_BRIGHT + message + RESET);
        String str = input.next();
        if (isNumeric(str)) {
            return Integer.parseInt(str);
        } else {
            System.out.println(RED + "invalid input!" + RESET);
            return getValidInt(message);
        }
    }

    public static boolean isNumeric(String str) {

        if (str == null || str.length() == 0) {
            return false;
        }
        try {
            Double.parseDouble(str);
            return true;

        } catch (NumberFormatException e) {
            return false;
        }

    }








}

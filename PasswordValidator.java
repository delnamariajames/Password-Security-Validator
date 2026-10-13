
import java.util.Scanner;

public class PasswordValidator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter password: ");
        String password = sc.nextLine();

        boolean upper = false;
        boolean lower = false;
        boolean digit = false;
        boolean special = false;

        int length = password.length();

        for (int i = 0; i < length; i++) {

            char ch = password.charAt(i);

            if (Character.isUpperCase(ch))
                upper = true;
            else if (Character.isLowerCase(ch))
                lower = true;
            else if (Character.isDigit(ch))
                digit = true;
            else
                special = true;
        }

        int pool = 0;

        if (upper) pool += 26;
        if (lower) pool += 26;
        if (digit) pool += 10;
        if (special) pool += 32;

        double entropy = 0;

        if (pool > 0)
            entropy = length * (Math.log(pool) / Math.log(2));

        String[] common = {
            "password", "123456", "password123",
            "admin", "qwerty", "12345678",
            "letmein", "welcome"
        };

        boolean isCommon = false;

        for (String word : common) {
            if (password.equalsIgnoreCase(word)) {
                isCommon = true;
                break;
            }
        }

        boolean valid = length >= 12 && upper &&
                        lower && digit && special &&
                        !isCommon;

        System.out.println("\n--- PASSWORD REPORT ---");

        System.out.println("Length: " + length);
        System.out.println("Uppercase: " + upper);
        System.out.println("Lowercase: " + lower);
        System.out.println("Digit: " + digit);
        System.out.println("Special character: " + special);

        System.out.printf("Estimated Entropy: %.2f bits\n", entropy);

        if (isCommon) {
            System.out.println("Strength: Weak");
            System.out.println("Warning: Common password detected!");
        }
        else if (entropy < 40) {
            System.out.println("Strength: Weak");
        }
        else if (entropy < 60) {
            System.out.println("Strength: Moderate");
        }
        else if (entropy < 80) {
            System.out.println("Strength: Strong");
        }
        else {
            System.out.println("Strength: Exceptional (estimated)");
        }

        System.out.println("Policy compliant: " + valid);

        System.out.println("\n--- SUGGESTIONS ---");

        if (length < 12)
            System.out.println("Use at least 12 characters.");

        if (!upper)
            System.out.println("Add an uppercase letter.");

        if (!lower)
            System.out.println("Add a lowercase letter.");

        if (!digit)
            System.out.println("Add a digit.");

        if (!special)
            System.out.println("Add a special character.");

        if (isCommon)
            System.out.println("Avoid commonly used passwords.");

        if (valid)
            System.out.println("All password policy requirements satisfied!");

        sc.close();
    }
}

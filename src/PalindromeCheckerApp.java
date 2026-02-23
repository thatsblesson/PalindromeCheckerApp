import java.util.Scanner;

public class PalindromeCheckerApp {

    // Preprocess the string
    public static String normalize(String input) {
        // remove spaces and convert to lowercase
        return input.replaceAll("\\s+", "").toLowerCase();
    }

    // Palindrome logic (two-pointer)
    public static boolean isPalindrome(String word) {

        int left = 0;
        int right = word.length() - 1;

        while (left < right) {
            if (word.charAt(left) != word.charAt(right))
                return false;

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n==================================");
            System.out.println(" PALINDROME CHECKER (NORMALIZATION)");
            System.out.println("==================================");
            System.out.println("1. Check Palindrome (Ignore case & spaces)");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter a sentence: ");
                    String input = sc.nextLine();

                    String cleaned = normalize(input);

                    if (isPalindrome(cleaned))
                        System.out.println("It is a Palindrome.");
                    else
                        System.out.println("It is NOT a Palindrome.");
                    break;

                case 2:
                    System.out.println("Thank you for using Palindrome Checker!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 2);

        sc.close();
    }
}
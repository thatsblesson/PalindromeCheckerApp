import java.util.Scanner;

public class PalindromeCheckerApp {

    // Recursive function
    public static boolean isPalindromeRecursive(String word, int left, int right) {

        // Base condition
        if (left >= right)
            return true;

        // If mismatch occurs
        if (word.charAt(left) != word.charAt(right))
            return false;

        // Recursive call
        return isPalindromeRecursive(word, left + 1, right - 1);
    }

    // Wrapper function (cleans string)
    public static boolean checkPalindrome(String input) {

        // remove spaces & special characters and convert to lowercase
        String word = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        if (word.length() == 0)
            return true;

        return isPalindromeRecursive(word, 0, word.length() - 1);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n==================================");
            System.out.println("  PALINDROME CHECKER (RECURSION)  ");
            System.out.println("==================================");
            System.out.println("1. Check Palindrome (Recursion)");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter a word or sentence: ");
                    String input = sc.nextLine();

                    if (checkPalindrome(input))
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
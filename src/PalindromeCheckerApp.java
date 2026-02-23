import java.util.Scanner;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n==================================");
            System.out.println("   PALINDROME CHECKER APPLICATION ");
            System.out.println("==================================");
            System.out.println("1. Check Palindrome");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {

                case 1:
                    System.out.print("Enter a word or sentence: ");
                    String input = sc.nextLine();

                    // remove spaces + special characters + case insensitive
                    String word = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

                    String reversed = "";

                    for (int i = word.length() - 1; i >= 0; i--) {
                        reversed += word.charAt(i);
                    }

                    if (word.equals(reversed)) {
                        System.out.println("It is a Palindrome.");
                    } else {
                        System.out.println("It is NOT a Palindrome.");
                    }
                    break;

                case 2:
                    System.out.println("Thank you for using Palindrome Checker!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 2);

        sc.close();
    }
}
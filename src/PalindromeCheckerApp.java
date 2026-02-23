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

                    // remove special characters and convert to lowercase
                    String word = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

                    boolean isPalindrome = true;
                    int left = 0;
                    int right = word.length() - 1;

                    while (left < right) {
                        if (word.charAt(left) != word.charAt(right)) {
                            isPalindrome = false;
                            break;
                        }
                        left++;
                        right--;
                    }

                    if (isPalindrome) {
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
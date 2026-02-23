import java.util.Scanner;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("==================================");
        System.out.println("   WELCOME TO PALINDROME CHECKER  ");
        System.out.println("==================================");

        System.out.print("Enter a word or sentence: ");
        String input = sc.nextLine();

        // Remove spaces and convert to lowercase
        String word = input.replaceAll("\\s+", "").toLowerCase();

        String reversed = "";

        for (int i = word.length() - 1; i >= 0; i--) {
            reversed = reversed + word.charAt(i);
        }

        if (word.equals(reversed)) {
            System.out.println("It is a Palindrome.");
        } else {
            System.out.println("It is NOT a Palindrome.");
        }

        sc.close();
    }
}
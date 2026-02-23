import java.util.Scanner;

public class PalindromeCheckerApp {

    // Node class for Singly Linked List
    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    // Function to check palindrome using linked list
    public static boolean isPalindrome(String input) {

        // remove special characters and lowercase
        String word = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        if (word.length() == 0) return true;

        // Step 1: Convert string to linked list
        Node head = new Node(word.charAt(0));
        Node temp = head;

        for (int i = 1; i < word.length(); i++) {
            temp.next = new Node(word.charAt(i));
            temp = temp.next;
        }

        // Step 2: Find middle using slow and fast pointer
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 3: Reverse second half
        Node prev = null;
        Node curr = slow;

        while (curr != null) {
            Node nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        // Step 4: Compare first half and reversed second half
        Node firstHalf = head;
        Node secondHalf = prev;

        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data)
                return false;

            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n==================================");
            System.out.println(" PALINDROME CHECKER (LINKED LIST) ");
            System.out.println("==================================");
            System.out.println("1. Check Palindrome (Linked List)");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter a word or sentence: ");
                    String input = sc.nextLine();

                    if (isPalindrome(input)) {
                        System.out.println("It is a Palindrome.");
                    } else {
                        System.out.println("It is NOT a Palindrome.");
                    }
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
import java.util.*;

// Step 1: Strategy Interface
interface PalindromeStrategy {
    boolean check(String input);
}

// Step 2: Stack Strategy
class StackStrategy implements PalindromeStrategy {

    public boolean check(String input) {
        input = input.toLowerCase();
        Stack<Character> stack = new Stack<>();

        for(char c : input.toCharArray()) {
            stack.push(c);
        }

        for(char c : input.toCharArray()) {
            if(c != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}

// Step 3: Deque Strategy
class DequeStrategy implements PalindromeStrategy {

    public boolean check(String input) {
        input = input.toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();

        for(char c : input.toCharArray()) {
            deque.add(c);
        }

        while(deque.size() > 1) {
            if(deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }
}

// Step 4: Context Class
class PalindromeChecker {

    private PalindromeStrategy strategy;

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean checkPalindrome(String input) {
        return strategy.check(input);
    }
}

// Step 5: Main Class
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PalindromeChecker checker = new PalindromeChecker();

        System.out.println("Enter a word:");
        String word = sc.nextLine();

        System.out.println("Choose Algorithm:");
        System.out.println("1. Stack");
        System.out.println("2. Deque");

        int choice = sc.nextInt();

        if(choice == 1) {
            checker.setStrategy(new StackStrategy());
        } else {
            checker.setStrategy(new DequeStrategy());
        }

        boolean result = checker.checkPalindrome(word);

        if(result) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not a Palindrome");
        }
    }
}
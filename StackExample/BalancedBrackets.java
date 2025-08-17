/*
Check for Balanced Brackets
Input: "[{()}]"
Output: true if balanced, else false.
*/

import java.util.Stack;
public class BalancedBrackets {

    public static boolean isBalanced(String input) {
        Stack<Character> stack = new Stack<>();

        for (char ch : input.toCharArray()) {
            // Push opening brackets onto the stack
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            // Handle closing brackets
            else if (ch == ')' || ch == '}' || ch == ']') {
                // If stack is empty, there's no opening bracket to match
                if (stack.isEmpty()) return false;

                char top = stack.pop();
                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {
                    return false; // mismatched pair
                }
            }
        }

        // If stack is empty, all brackets matched
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String input = "[{()}]";
        System.out.println("Balanced: " + isBalanced(input)); // Output: true
    }
}

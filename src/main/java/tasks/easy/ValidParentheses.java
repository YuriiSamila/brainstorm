package tasks.easy;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println(isValidParentheses("}"));
    }

    private static boolean isValidParentheses(String s) {
        int n = s.length();
        if (n % 2 == 1) return false;
        char[] stack = new char[n];
        int top = -1;
        for (char c : s.toCharArray()) {
            if (c == '(') stack[++top] = ')';
            else if (c == '{') stack[++top] = '}';
            else if (c == '[') stack[++top] = ']';
            else if (top == -1 || stack[top--] != c) return false;
        }
        return top == -1;
    }

    private static boolean isValidParentheses2(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (c == '{' || c == '[' || c == '(') {
                stack.add(c);
            } else if (!stack.isEmpty() && stack.peek() == desirableChar(c)) {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }


    private static char desirableChar(char c) {
        return switch (c) {
            case ')' -> '(';
            case ']' -> '[';
            case '}' -> '{';
            default -> '\0';
        };
    }
}

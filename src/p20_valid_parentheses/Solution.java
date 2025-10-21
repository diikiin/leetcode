package p20_valid_parentheses;

import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> brackets = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                brackets.push(c);
            } else if (brackets.isEmpty()) {
                return false;
            } else {
                char bracket = brackets.pop();
                if (bracket == '(' && c != ')'
                        || bracket == '[' && c != ']'
                        || bracket == '{' && c != '}') return false;
            }
        }
        return brackets.isEmpty();
    }

    public boolean isValidBest(String s) {
        Stack<Character> brackets = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') brackets.push(')');
            else if (c == '[') brackets.push(']');
            else if (c == '{') brackets.push('}');
            else if (brackets.isEmpty() || brackets.pop() != c) return false;
        }
        return brackets.isEmpty();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid("()"));
        System.out.println(solution.isValid("()[]{}"));
        System.out.println(solution.isValid("(]"));
        System.out.println(solution.isValid("([])"));
        System.out.println(solution.isValid("([)]"));
        System.out.println(solution.isValid("("));
        System.out.println(solution.isValid("]"));

        System.out.println(solution.isValidBest("()"));
        System.out.println(solution.isValidBest("()[]{}"));
        System.out.println(solution.isValidBest("(]"));
        System.out.println(solution.isValidBest("([])"));
        System.out.println(solution.isValidBest("([)]"));
        System.out.println(solution.isValidBest("("));
        System.out.println(solution.isValidBest("]"));
    }
}
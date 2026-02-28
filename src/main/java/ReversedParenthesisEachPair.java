import java.util.Stack;

public class ReversedParenthesisEachPair {

    public String reverseParentheses(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch != ')') {
                stack.push(ch);
            } else {

                StringBuilder sb = new StringBuilder();

                while (!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.pop());
                }

                stack.pop();

                for (int j = 0; j < sb.length(); j++) {
                    stack.push(sb.charAt(j));
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (char ch : stack) {
            result.append(ch);
        }

        return result.toString();
    }
}
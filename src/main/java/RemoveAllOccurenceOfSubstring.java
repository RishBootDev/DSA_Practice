import java.util.Stack;

public class RemoveAllOccurenceOfSubstring {

        public String removeOccurrences(String s, String part) {

            Stack<Character> stack = new Stack<>();
            int n = part.length();

            for (char c : s.toCharArray()) {
                stack.push(c);
                if (stack.size() >= n) {

                    boolean match = true;

                    for (int i = 0; i < n; i++) {
                        if (stack.get(stack.size() - n + i) != part.charAt(i)) {
                            match = false;
                            break;
                        }
                    }

                    if (match) {
                        for (int i = 0; i < n; i++) {
                            stack.pop();
                        }
                    }
                }
            }

            StringBuilder result = new StringBuilder();
            for (char c : stack) {
                result.append(c);
            }

            return result.toString();
        }

}

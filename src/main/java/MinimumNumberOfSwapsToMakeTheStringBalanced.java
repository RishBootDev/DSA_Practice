import java.util.Stack;

public class MinimumNumberOfSwapsToMakeTheStringBalanced {


        public int minSwaps(String s) {

            Stack<Character> stack = new Stack<>();
            int swaps = 0;

            for (int i = 0; i < s.length(); i++) {

                char ch = s.charAt(i);
                if (ch == '[') {
                    stack.push(ch);
                }
                else {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    } else {
                        swaps++;
                    }
                }
            }

            return (swaps + 1) / 2;
        }


}

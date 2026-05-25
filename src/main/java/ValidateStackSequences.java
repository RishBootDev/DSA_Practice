import java.util.Stack;

public class ValidateStackSequences {

    public boolean validateStackSequences(int[] pushed, int[] popped) {

        Stack<Integer> stack = new Stack<>();

        int i = 0;
        int j = 0;

        while (i < pushed.length) {
            stack.push(pushed[i]);
            i++;
            while (!stack.isEmpty() && j < popped.length
                    && stack.peek() == popped[j]) {

                stack.pop();
                j++;
            }
        }

        return stack.isEmpty();
    }
}
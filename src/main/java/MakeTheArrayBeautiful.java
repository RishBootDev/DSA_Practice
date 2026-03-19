import java.util.ArrayList;
import java.util.Stack;

public class MakeTheArrayBeautiful {

    public static ArrayList<Integer> makeBeautiful(int[] arr) {

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < arr.length; i++) {

            if(!stack.isEmpty() &&
                    ((stack.peek() >= 0 && arr[i] < 0) ||
                            (stack.peek() < 0 && arr[i] >= 0))) {

                stack.pop();
            } else {
                stack.push(arr[i]);
            }
        }

        return new ArrayList<>(stack);
    }
}

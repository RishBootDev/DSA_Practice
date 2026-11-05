import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ReduceIt {

    public static void reduce(List<Integer> list) {

        Stack<Integer> stack = new Stack<>();
        int removedCount = 0;

        for (int num : list) {
            if (num == 0) {
                removedCount++;
                continue;
            }

            int current = num;

            while (!stack.isEmpty() && stack.peek() == current) {
                stack.pop();
                current = current + 1;
                removedCount++;
            }

            stack.push(current);
        }

        List<Integer> result = new ArrayList<>(stack);
        System.out.println(result);
    }
}
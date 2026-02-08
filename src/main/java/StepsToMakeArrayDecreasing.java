import java.util.Arrays;
import java.util.Stack;

public class StepsToMakeArrayDecreasing {

    public static void main(String[] args) {
        StepsToMakeArrayDecreasing temp = new StepsToMakeArrayDecreasing();
        temp.totalSteps(new int[]{5,3,4,4,7,3,6,11,8,5,11});
    }

    public int totalSteps(int[] nums) {

        int []res = previousGreater(nums);

        System.out.println(Arrays.toString(res));
        return 0;
    }

    public static int[] previousGreater(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }

            res[i] = stack.isEmpty() ? -1 : stack.peek();

            stack.push(arr[i]);
        }

        return res;
    }
}

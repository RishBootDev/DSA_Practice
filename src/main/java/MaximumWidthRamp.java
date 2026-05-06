import java.util.Stack;

public class MaximumWidthRamp {


    // this is the working approach but got time limit exceeded
    public int maxWidthRamp(int[] nums) {

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int temp = -1;
            for (int j = i; j < nums.length; j++) {
                if(nums[j] >= nums[i]) temp = (j-i);
            }
            max = Math.max(max, temp);
        }

        return max;
    }


    // This is the correct working approach and it is working fine with the above idea
    public int maxWidthRamp2(int[] nums) {

            Stack<Integer> stack = new Stack<>();
            int n = nums.length;

            for (int i = 0; i < n; i++) {

                if (stack.isEmpty() || nums[i] < nums[stack.peek()]) {
                    stack.push(i);
                }
            }
            int maxWidth = 0;

            for (int j = n - 1; j >= 0; j--) {

                while (!stack.isEmpty() && nums[j] >= nums[stack.peek()]) {
                    maxWidth = Math.max(maxWidth, j - stack.peek());
                    stack.pop();
                }
            }
            return maxWidth;
    }

}

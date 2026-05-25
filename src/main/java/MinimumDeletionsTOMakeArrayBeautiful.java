import java.util.Stack;

public class MinimumDeletionsTOMakeArrayBeautiful {

    public int minDeletion(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        boolean flag = true;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if(flag) {
                if(stack.isEmpty()){
                    stack.push(nums[i]);
                    count++;
                }
                else {
                    int top = stack.peek();
                    if(top != nums[i]) {
                        stack.push(nums[i]);
                        count++;
                        flag = count % 2 == 0;
                    }
                }
            }else {
                stack.push(nums[i]);
                count++;
                flag = true;
            }
        }

        return nums.length - stack.size();
    }
}

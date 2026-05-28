class Solution {
    public int maximumPossibleSize(int[] nums) {

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i< nums.length; i++) {
            if(stack.isEmpty()) {
                stack.push(nums[i]);
            }else {
                int top = stack.peek();
                if(nums[i] >= top) stack.push(nums[i]);
            }
        }

        return stack.size();
        
    }
}
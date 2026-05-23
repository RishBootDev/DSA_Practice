class Solution {

    public int minDeletion(int[] nums) {

        Stack<Integer> stack = new Stack<>();

        for (int num : nums) {

            if (stack.size() % 2 == 0) {
                stack.push(num);
            }
            else {

                if (stack.peek() != num) {
                    stack.push(num);
                }
            }
        }

        if (stack.size() % 2 == 1) {
            stack.pop();
        }

        return nums.length - stack.size();
    }
}
public class JumpGame {

    // jump game 2
    public int jump(int[] nums) {
        int jumps = 0;
        int currEnd = 0;
        int farthest = 0;

        for(int i = 0; i < nums.length - 1; i++) {

            farthest = Math.max(farthest, i + nums[i]);
            if(i == currEnd) {
                jumps++;
                currEnd = farthest;
            }
        }
        return jumps;
    }

    // jump game 1
    public boolean canJump(int[] arr) {

        int max = 0;

        for(int i = 0;i < arr.length;i++) {

            if(i > max) return false;
            else if(max >= arr.length -1) return true;
            int temp = arr[i] + i;
            max = Math.max(temp, max);
        }
        return true;
    }

    // the above approach is the greedy version of the jump game
    // i am trying to solve the jump game using the recursion
    public boolean canReach(int arr[]) {
        if(arr.length == 1) return true;
        return helper(arr, 0);
    }
    public boolean helper(int arr[], int i) {
        if(i >= arr.length - 1) return true;
        if(arr[i] == 0) return false;

        int last = i + arr[i];
        boolean ans = false;
        for (int j = i + 1; j <= last; j++) {
            ans |= helper(arr, j);
        }
        return ans;
    }
}

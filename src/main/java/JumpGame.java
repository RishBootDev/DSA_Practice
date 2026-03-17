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
}

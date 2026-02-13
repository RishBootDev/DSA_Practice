public class MinimumOperationsToMakeBinaryStringEqualTo1 {

    public int minOperations(int[] nums) {

        int count = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 0) {
                boolean temp = flip(nums, i);
                count ++;
                if(!temp) return -1;
            }
        }

        return count;
    }

    public boolean flip(int []nums, int i) {

        if(i+2 >= nums.length) return false;

        for (int j = i; j <=i+2 ; j++) {
            if (nums[j] == 0) nums[j] = 1;
            else nums[j] = 0;
        }
        return true;
    }
}

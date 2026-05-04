public class MinimumOperationsToMakeBinaryArray1 {

    public int minOperations(int[] nums) {

        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0 && temp % 2 == 0) temp++;
            else if (nums[i] == 1 && temp % 2 == 1) temp++;
        }

        return temp;
    }
}

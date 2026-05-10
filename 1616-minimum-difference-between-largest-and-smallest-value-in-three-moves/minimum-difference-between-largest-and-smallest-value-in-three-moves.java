class Solution {

    public int minDifference(int[] nums) {

        if(nums.length <= 4) return 0;
        Arrays.sort(nums);

        int n = nums.length;
        int task1 = nums[n - 4] - nums[0];
        int task2 = nums[n - 1] - nums[3];
        int task3 = nums[n - 3] - nums[1];
        int task4 = nums[n - 2] - nums[2];

        return Math.min(
                Math.min(task1, task2),
                Math.min(task3, task4)
        );
    }
}
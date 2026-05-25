public class PartitionArrayInTwoEqualSubsets {

    public boolean checkEqualPartitions(int[] nums, long target) {

        return helper(nums, 0, 1L, 1L, target);
    }

    public boolean helper(int[] nums, int i, long a, long b, long target) {

        if (a > target || b > target) return false;
        if (i == nums.length) {
            return a == target && b == target;
        }

        boolean task1 = helper(nums, i + 1, a * nums[i], b, target);
        boolean task2 = helper(nums, i + 1, a, b * nums[i], target);
        return task1 || task2;
    }
}

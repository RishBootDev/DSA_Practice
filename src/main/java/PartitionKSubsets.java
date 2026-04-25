public class PartitionKSubsets {

        public boolean canPartitionKSubsets(int[] nums, int k) {
            int sum = 0;
            for (int num : nums) sum += num;

            if (sum % k != 0) return false;
            int target = sum / k;
            int[] temp = new int[k];
            return helper(nums, 0, temp, target);
        }

        public boolean helper(int[] nums, int i, int[] temp, int target) {

            if (i == nums.length) {
                for (int x : temp) {
                    if (x != target) return false;
                }
                return true;
            }

            for (int j = 0; j < temp.length; j++) {

                temp[j] += nums[i];
                if (temp[j] <= target && helper(nums, i + 1, temp, target)) {
                    return true;
                }
                temp[j] -= nums[i];
            }
            return false;
        }
}

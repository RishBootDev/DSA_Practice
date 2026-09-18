class CountSequencesToK {

    public int countSequences(int[] nums, long k) {
        return helper(nums, 0, 1.0, k);
    }

    public int helper(int nums[], int i, double val, long k) {

        if(i == nums.length) {
            if(Math.abs(val - k) < 1e-9) {
                return 1;
            }
            return 0;
        }
        int count = 0;
        // multiply
        count += helper(nums, i + 1, val * nums[i], k);
        // divide
        count += helper(nums, i + 1, val / nums[i], k);
        // leave
        count += helper(nums, i + 1, val, k);

        return count;
    }
}
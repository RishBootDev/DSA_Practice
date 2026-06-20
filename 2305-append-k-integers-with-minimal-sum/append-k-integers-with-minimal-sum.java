class Solution {
    public long minimalKSum(int[] nums, int k) {
        Arrays.sort(nums);

        long res = (long) k * (k + 1) / 2;

        int prev = -1;
        for (int n : nums) {
            if (n == prev) continue;
            prev = n;

            if (n <= k) {
                res += (++k) - n;
            } else {
                break;
            }
        }

        return res;
    }
}
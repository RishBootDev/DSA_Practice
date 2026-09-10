public class Solution {

    public int maxSumTwoNoOverlap(int[] nums, int k, int m) {
        int sum = 0;
        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int solve = sum + second(nums, k, nums.length - 1, m);
        ans = Math.max(solve, ans);
        System.out.println("0 to " + (k - 1) + " = " + sum);

        for (int i = k; i < nums.length; i++) {
            sum += nums[i];
            sum -= nums[i - k];

            int left = first(nums, 0, i - k, m);
            int right = second(nums, i + 1, nums.length - 1, m);
            ans = Math.max(ans, sum + Math.max(left, right));
            System.out.println((i - k + 1) + " to " + i + " = " + sum);
        }
        return ans;
    }

    public int first(int[] nums, int start, int end, int size) {
        int availableLength = end - start + 1;
        if (size > availableLength) return Integer.MIN_VALUE;
        int ans = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = start; i < start + size; i++) {
            sum += nums[i];
        }
        ans = Math.max(sum, ans);

        for (int i = start + size; i <= end; i++) {
            sum += nums[i];
            sum -= nums[i - size];
            ans = Math.max(ans, sum);
        }
        return ans;
    }

    public int second(int[] nums, int start, int end, int size) {
        int availableLength = end - start + 1;
        if (size > availableLength) return Integer.MIN_VALUE;
        int ans = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = start; i < start + size; i++) {
            sum += nums[i];
        }
        ans = Math.max(sum, ans);

        for (int i = start + size; i <= end; i++) {
            sum += nums[i];
            sum -= nums[i - size];
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
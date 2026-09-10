public class MinimumTotalCostToProcessAllElements {

    public int minimumCost(int[] nums, int k) {

        long temp = k;
        long count = 0;
        long ans = 0;
        long mod = 1_000_000_007L;

        for (int i = 0; i < nums.length; i++) {
            while (temp < nums[i]) {
                temp += k;
                count++;
                ans = (ans + count) % mod;
            }
            temp -= nums[i];
        }

        return (int) ans;
    }
}
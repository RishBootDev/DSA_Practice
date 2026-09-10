class Solution {

    Integer[] dp;

    public int maximumEnergy(int[] energy, int k) {

        dp = new Integer[energy.length];
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < energy.length; i++) {
            max = Math.max(max, helper(energy, i, k));
        }

        return max;
    }

    public int helper(int[] energy, int i, int k) {

        if(i >= energy.length) {
            return 0;
        }

        if(dp[i] != null) {
            return dp[i];
        }
        return dp[i] = energy[i] + helper(energy, i + k, k);
    }
}
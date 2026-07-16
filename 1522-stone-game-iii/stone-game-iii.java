class Solution {
    Integer dp[][];
    public String stoneGameIII(int[] piles) {
        int n = piles.length;
        dp = new Integer[n][2];
        int sum = 0;
        for(int c : piles) sum += c;
        int max = helper(piles, 0, 1);
        int temp = sum - max;
        if(max == temp) return "Tie";
        else if(max > temp) return "Alice";
        return "Bob";
    }
    public int helper(int piles[], int i, int temp) {
        if(i == piles.length) return 0;

        if(dp[i][temp] != null) return dp[i][temp];

        if(temp == 1) {
            int ans = Integer.MIN_VALUE;
            int sum = 0;
            for (int j = i; j <= i + 2 && j < piles.length ; j++) {
                sum += piles[j];
                int take = helper(piles, j + 1, 0) + sum;
                ans = Math.max(ans, take);
            }
            return dp[i][temp] = ans;
        }else {
            int ans = Integer.MAX_VALUE;
            for (int j = i; j <= i + 2 && j < piles.length ; j++) {
                int take = helper(piles, j + 1, 1);
                ans = Math.min(take, ans);
            }
            return dp[i][temp] = ans;
        }
    }
}
class Solution {
    public boolean canJump(int arr[]) {
        if(arr.length == 1) return true;
        int dp[] = new int[arr.length];
        Arrays.fill(dp, -1);
        return helper(arr, 0, dp);
    }

    public boolean helper(int arr[], int i, int dp[]) {
        if(i >= arr.length - 1) return true;
        if(arr[i] == 0) return false;

        if(dp[i] != -1) return dp[i] == 1;

        int last = Math.min(i + arr[i], arr.length - 1);
        boolean ans = false;

        for(int j = i + 1; j <= last; j++) {
            ans |= helper(arr, j, dp);
        }

        dp[i] = ans ? 1 : 0;
        return ans;
    }
}
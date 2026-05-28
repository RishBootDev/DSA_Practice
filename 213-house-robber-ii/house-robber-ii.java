class Solution {
    
    Integer dp[][];
    public int rob(int[] nums) {
        dp = new Integer[nums.length][2];
       return helper(nums, 0, false);

    }

    public int helper(int[] arr, int i , boolean flag) {
        if(i >= arr.length) {
            return 0;
        }

        if(!flag && dp[i][0] != null) return dp[i][0];
        if(flag && dp[i][1] != null) return dp[i][1];

        // take and not take pattern
        int take = 0;
        int not = 0;
        if(i == 0) {
            take = helper(arr, i + 2, true) + arr[i];
            not = helper(arr, i + 1, false);
        }else if (i == arr.length - 1) {
            if(flag) take = 0;
            else take = helper(arr, i + 2, false)+arr[i];

            not = helper(arr, i + 1, false);
        }else {
            if(flag) {
                take = helper(arr, i + 2, true) + arr[i];
                not = helper(arr, i + 1, true);
            }else {
                take = helper(arr, i + 2, false) + arr[i];
                not = helper(arr, i + 1, false);
            }
        }
        if(flag) return dp[i][1] = Math.max(take, not);
        return dp[i][0] = Math.max(take, not);
    }
}
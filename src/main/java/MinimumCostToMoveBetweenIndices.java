public class MinimumCostToMoveBetweenIndices {

    public int[] minCost(int[] nums, int[][] queries) {

        int ans [] = new int[queries.length];
        int j = 0;
        for(int [] q : queries) {
            int start = q[0];
            int end = q[1];
            int cost = 0;

            for (int i = start + 1; i < end ; i++) {
                int af = nums[i+1] - nums[i];
                int bef = i - 1 == -1?af:nums[i] - nums[i-1];

                if(af <= bef) cost ++;
                else cost += af;
            }
            ans[j] = cost;
        }

        return ans;
    }
}

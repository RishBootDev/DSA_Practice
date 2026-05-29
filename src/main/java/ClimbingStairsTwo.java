public class ClimbingStairsTwo {

    public int climbStairs(int n, int[] costs) {
        return helper(n, costs);
    }

    public int helper(int i, int cost[]) {

        if(i >= cost.length) return 0;

        int cost1 = 0, cost2 = 0, cost3 = 0;
        if(i + 1 < cost.length)
            cost1 = helper(i + 1, cost) + 1 + cost[i + 1];
        if(i + 2 < cost.length)
            cost2 = helper(i + 2, cost) + 4 + cost[i + 2];
        if(i + 3 < cost.length)
            cost3 = helper(i + 3, cost) + 9 + cost[i + 3];

        return Math.min(cost1, Math.min(cost2, cost3));
    }
}

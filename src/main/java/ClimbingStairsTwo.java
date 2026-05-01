public class ClimbingStairsTwo {

    public int climbStairs(int n, int[] costs) {
        return climb(costs, 0);
    }

    public int climb(int[] costs, int i) {

        if (i >= costs.length) {
            return 0;
        }

        int cost1 = climb(costs, i + 1) + 1;
        int cost2 = climb(costs, i + 2) + 4;
        int cost3 = climb(costs, i + 3) + 9;

        return costs[i] + Math.min(cost1,
                Math.min(cost2, cost3));
    }
}

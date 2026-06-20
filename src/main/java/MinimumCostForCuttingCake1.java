public class MinimumCostForCuttingCake1 {

    public int minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        return helper(m, n, horizontalCut, verticalCut);

    }

    public int helper(int m, int n, int[] hs, int[] vs) {

        if (m > hs.length + 1 || n > vs.length + 1)
            return Integer.MAX_VALUE;
        if (m <= 0 || n <= 0)
            return Integer.MAX_VALUE;
        if (m == 1 && n == 1)
            return 0;
        int cost = Integer.MAX_VALUE;

        // horizontal cuts
        for (int i = 0; i < hs.length; i++) {

            int left = helper(m, i + 1, hs, vs);
            int right = helper(m, n - (i + 1), hs, vs);

            if (left != Integer.MAX_VALUE && right != Integer.MAX_VALUE) {
                cost = Math.min(cost, left + right + hs[i]);
            }
        }

        // vertical cuts
        for (int i = 0; i < vs.length; i++) {

            int top = helper(i + 1, n, hs, vs);
            int bottom = helper(m - (i + 1), n, hs, vs);

            if (top != Integer.MAX_VALUE && bottom != Integer.MAX_VALUE) {
                cost = Math.min(cost, top + bottom + vs[i]);
            }
        }
        return cost;
    }
}

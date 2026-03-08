public class MinimumCostToPartition {

    public long minCost(String s, int encCost, int flatCost) {
        return solve(s, 0, s.length() - 1, encCost, flatCost);
    }

    public long solve(String s, int l, int r, int encCost, int flatCost) {

        int length = s.length();
        int ones = 0;
        for (int i = l; i <= r; i++) {
            if (s.charAt(i) == '1') {
                ones++;
            }
        }

        long directCost;
        if (ones == 0) {
            directCost = flatCost;
        } else {
            directCost = (long) length * ones * encCost;
        }

        long ans = directCost;
        if (length % 2 == 0) {
            int mid = (l + r) / 2;
            long splitCost = solve(s, l, mid, encCost, flatCost) + solve(s, mid + 1, r, encCost, flatCost);
            ans = Math.min(ans, splitCost);
        }

        return ans;
    }
}


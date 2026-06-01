public class BestSightingPair {

    public int maxScoreSightseeingPair(int[] values) {

        return helper(0, -1, values);

    }
    public int helper(int i, int prev, int [] values) {
        if(i == values.length) return 0;

        if(prev == -1) {
            int take = helper(i + 1, i, values);
            int not = helper(i + 1, prev, values);
            return Math.max(take, not);
        }else {
            // took
                int pair = values[prev] + values[i] + prev - i;
                int not = helper(i + 1, prev, values);
                return Math.max(pair, not);
            }
        }
}

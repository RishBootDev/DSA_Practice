class Solution {
    
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {

        List<Pair> pairs = new ArrayList<>();

        for (int i = 0; i < difficulty.length; i++) {
            pairs.add(new Pair(difficulty[i], profit[i]));
        }
        pairs.sort((p1, p2) -> p2.profit - p1.profit);

        int ans = 0;
        for (int w : worker) {
            for (Pair pair : pairs) {

                if (pair.diff <= w) {
                    ans += pair.profit;
                    break;
                }
            }
        }
        return ans;
    }

    static class Pair {

        int diff;
        int profit;

        public Pair(int diff, int profit) {
            this.diff = diff;
            this.profit = profit;
        }
    }
}
class Solution {

    Integer dp[][];

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        dp = new Integer[n][k + 1];
        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] flight : flights) {
            Pair pair = new Pair(flight[1], flight[2]);
            graph.get(flight[0]).add(pair);
        }

        int ans = dfs(graph, src, dst, k, n);
        return ans >= 100000 ? -1 : ans;
    }

    public int dfs(List<List<Pair>> graph, int start, int dst, int k, int n) {

        if (start == dst) {
            return 0;
        }
        if (k < 0) return 100000;
        if (dp[start][k] != null) return dp[start][k];

        int price = 100000;

        for (Pair p : graph.get(start)) {
            int temp = dfs(graph, p.to, dst, k - 1, n) + p.price;
            price = Math.min(price, temp);
        }
        return dp[start][k] = price;
    }

    static class Pair {
        int to;
        int price;

        public Pair(int to, int price) {
            this.to = to;
            this.price = price;
        }
    }
}
class Solution {
    
     public int networkDelayTime(int[][] times, int n, int k) {

        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int time[] : times) {
            Pair pair = new Pair(time[0], time[1], time[2]);
            graph.get(time[0]).add(pair);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (p1, p2) -> p1.time - p2.time
        );

        pq.add(new Pair(-1, k, 0));

        int ans[] = new int[n + 1];
        boolean vis[] = new boolean[n + 1];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[k] = 0;

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();

            if (!vis[curr.end]) {
                vis[curr.end] = true;
                ans[curr.end] = curr.time;

                for (Pair next : graph.get(curr.end)) {
                    if (!vis[next.end]) {
                        pq.add(new Pair(curr.end, next.end,
                                curr.time + next.time));
                    }
                }
            }
        }

        int max = 0;

        for (int i = 1; i <= n; i++) {
            if (ans[i] == Integer.MAX_VALUE) {
                return -1;
            }
            max = Math.max(max, ans[i]);
        }

        return max;
    }

    static class Pair {
        int start;
        int end;
        int time;

        public Pair(int start, int end, int time) {
            this.start = start;
            this.end = end;
            this.time = time;
        }
    }
}
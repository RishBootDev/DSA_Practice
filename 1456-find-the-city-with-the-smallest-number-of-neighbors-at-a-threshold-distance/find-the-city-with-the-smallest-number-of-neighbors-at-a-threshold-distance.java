class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {

        List<List<Pair>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(new Pair(edge[1], edge[2]));
            graph.get(edge[1]).add(new Pair(edge[0], edge[2]));
        }

        int result = -1;
        int minCount = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {

            int count = countbfs(graph, i, distanceThreshold);

            if (count <= minCount) {
                minCount = count;
                result = i;
            }
        }

        return result;
    }

    public int countbfs(List<List<Pair>> graph, int start, int threshold) {

        int count = 0;

        int[] dist = new int[graph.size()];

        for (int i = 0; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        Queue<Pair> queue = new LinkedList<>();

        dist[start] = 0;
        queue.offer(new Pair(start, 0));

        while (!queue.isEmpty()) {

            Pair curr = queue.poll();

            int currCity = curr.a;
            int currDist = curr.dist;

            for (Pair node : graph.get(currCity)) {

                int nextCity = node.a;
                int nextDist = currDist + node.dist;

                if (nextDist <= threshold && nextDist < dist[nextCity]) {

                    if (dist[nextCity] == Integer.MAX_VALUE) {
                        count++;
                    }

                    dist[nextCity] = nextDist;

                    queue.offer(new Pair(nextCity, nextDist));
                }
            }
        }

        return count;
    }

    static class Pair {
        int a;
        int dist;

        public Pair(int a, int dist) {
            this.a = a;
            this.dist = dist;
        }
    }
}
import java.util.*;

public class MinimumTimeToCollectApples {

    private Set<Pair> set;

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        this.set = new HashSet<>();
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }

        for(int edge [] : edges) {
            int a = edge[0];
            int b = edge[1];
            tree.get(a).add(b);
        }

        for (int i = 0; i < hasApple.size(); i++) {
            if(hasApple.get(i)) {
                print(tree, 0, i, new ArrayList<>());
            }
        }
        return set.size() * 2;
    }

    public void print(List<List<Integer>> tree, int a, int b,
                      List<Integer> path) {

        path.add(a);

        if (a == b) {
            List<Integer> list = new ArrayList<>(path);
            for (int i = 0; i < list.size() - 1; i++) {
                Pair pair = new Pair(list.get(i), list.get(i + 1));
                set.add(pair);
            }
            path.removeLast();
            return;
        }

        for (int node : tree.get(a)) {
            print(tree, node, b, path);
        }
        path.removeLast();
    }

    static class Pair{
        int start;
        int end;
        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Pair pair)) return false;
            return start == pair.start && end == pair.end || start == pair.end && end == pair.start;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end);
        }
    }
}

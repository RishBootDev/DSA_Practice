import java.util.*;

public class CriticsSpecial {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int a = sc.nextInt();

            List<Set<Integer>> graph = new ArrayList<>();
            Map<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i <= a; i++) {
                graph.add(new HashSet<>());
            }

            for (int i = 1; i <= a; i++) {
                map.put(i, sc.nextInt());
            }
            PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) ->
                    p2.priority - p1.priority);

            for (int i = 1; i < a; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                Pair pair = new Pair(x, y);
                pq.add(pair);
                graph.get(x).add(y);
                graph.get(y).add(x);
            }

            for (int i = 1; i <= a; i++) {
                Set<Integer> set = graph.get(i);

                int max = Integer.MIN_VALUE;
                int ans = 0;

                List<Pair> pairs = new ArrayList<>();
                while(!pq.isEmpty() && set.contains(pq.peek().v)) {
                    Pair pair = pq.poll();
                    pairs.add(pair);
                    ans = pair.v;
                }
                pq.addAll(pairs);
                System.out.print(ans + " ");
            }
        }
    }

    static class Pair{
        int v;
        int priority;
        public Pair(int v , int priority) {
            this.v = v;
            this.priority = priority;
        }
    }

}

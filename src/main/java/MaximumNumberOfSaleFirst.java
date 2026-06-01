import java.util.*;

public class MaximumNumberOfSaleFirst {

    private static Map<Integer, Integer> map = new HashMap<>();

    public static int maximumSaleItems(int[][] items, int budget) {

        List<Pair> pairs = new ArrayList<>();
        for(int item[] : items) {
            int factor = item[0];
            int cost = item[1];
            if(cost <= budget) {
                Pair pair = new Pair(factor, cost);
                pairs.add(pair);
            }
        }

        int m = pairs.size();

        for(int i= 0; i < m; i++) {
            for(int j = 0; j < m ; j++) {
               // if(i == j) continue;
                if(pairs.get(j).factor % pairs.get(i).factor == 0) {
                   map.put(pairs.get(i).factor, map.getOrDefault(pairs.get(i).factor, 0) + 1);
                }
            }
        }

        System.out.println(map);
        Set<Integer> set = new HashSet<>();
        int ans = helper(pairs, 0, budget, set);
        return ans;

    }
    public static int helper(List<Pair> pairs, int i, int budget, Set<Integer> usedFactors) {
        if (i == pairs.size()) {
            return 0;
        }

        Pair pair = pairs.get(i);
        int cost = pair.cost;
        int factor = pair.factor;

        // not take
        int not = helper(pairs, i + 1, budget, usedFactors);

        // take
        int take = 0;
        if (budget >= cost) {
            boolean firstTime = !usedFactors.contains(factor);

            if (firstTime) {
                usedFactors.add(factor);
                take = helper(pairs, i, budget - cost, usedFactors) + map.get(factor);
                usedFactors.remove(factor);
            } else {
                take = helper(pairs, i, budget - cost, usedFactors) + 1;
            }
        }

        return Math.max(take, not);
    }

    static class Pair{
        int factor;
        int cost;

        public Pair(int factor, int cost) {
            this. factor= factor;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {
        int items [][] = {
                {6,2},
                {2,6},
                {3,4}
        };
        int budget = 9;
        System.out.println(maximumSaleItems(items, budget));
    }
}

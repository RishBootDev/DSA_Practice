import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MinimumRotationsForEqualRow {

        public int minDominoRotations(int[] tops, int[] bottoms) {

            Map<Integer, Integer> map = new HashMap<>();
            for (int top : tops)
                map.put(top, map.getOrDefault(top, 0) + 1);

            for (int bottom : bottoms)
                map.put(bottom, map.getOrDefault(bottom, 0) + 1);

            PriorityQueue<Integer> pq =
                    new PriorityQueue<>(Collections.reverseOrder());

            for (Map.Entry<Integer, Integer> ent : map.entrySet()) {
                if (ent.getValue() >= tops.length) {
                    pq.add(ent.getKey());
                }
            }
            int min = Integer.MAX_VALUE;
            while (!pq.isEmpty()) {
                int k = pq.poll();
                int count = count(tops, bottoms, k);
                if (count != -1) {
                    min = Math.min(min, count);
                }
            }

            return min == Integer.MAX_VALUE ? -1 : min;
        }

        public int count(int[] tops, int[] bottoms, int k) {

            int count1 = 0;
            int count2 = 0;

            for (int i = 0; i < tops.length; i++) {
                if (tops[i] != k && bottoms[i] != k) {
                    return -1;
                }
                if (tops[i] != k) {
                    count1++;
                }

                if (bottoms[i] != k) {
                    count2++;
                }
            }
            return Math.min(count1, count2);
        }

}

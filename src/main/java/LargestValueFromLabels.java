import java.util.*;

public class LargestValueFromLabels {

    public int largestValsFromLabels(int[] values, int[] labels,
                                     int numWanted, int useLimit) {

        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) ->
                p2.value - p1.value);

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < values.length; i++) {
            pq.add(new Pair(values[i], labels[i]));
        }

        int sum = 0;

        while (numWanted > 0 && !pq.isEmpty()) {
            Pair pair = pq.poll();

            if (map.containsKey(pair.label)) {
                if (map.get(pair.label) < useLimit) {
                    sum += pair.value;
                    map.put(pair.label, map.get(pair.label) + 1);
                    numWanted--;
                }
            } else {
                sum += pair.value;
                map.put(pair.label, 1);
                numWanted--;
            }
        }

        return sum;
    }

    static class Pair {
        int value;
        int label;

        @Override
        public String toString() {
            return "Pair{" +
                    "value=" + value +
                    ", label=" + label +
                    '}';
        }

        public Pair(int value, int label) {
            this.value = value;
            this.label = label;
        }
    }
}

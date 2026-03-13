import java.util.HashMap;
import java.util.Map;

public class MaxWeight {

    public int maxWeightCell(int[] exits) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < exits.length; i++) {
            map.put(i, 0);
        }
        for (int i = 0; i < exits.length; i++) {

            if (exits[i] != -1) {
                map.put(exits[i], map.getOrDefault(exits[i], 0) + i);
            }
        }

        int max = Integer.MIN_VALUE;
        int result = -1;

        for (Map.Entry<Integer, Integer> ent : map.entrySet()) {

            int cell = ent.getKey();
            int weight = ent.getValue();

            if (weight > max || (weight == max && cell > result)) {
                max = weight;
                result = cell;
            }
        }

        return result;

    }
}

import java.util.HashMap;
import java.util.Map;

public class NodeWithHighestEdgeScore {

    public int edgeScore(int[] edges) {

        Map<Integer, Long> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {

           map.put(edges[i], map.getOrDefault(edges[i], 0L) + 1);
        }
        long max = Long.MIN_VALUE;
        int ans = -1;
        for(Map.Entry<Integer, Long> ent : map.entrySet()) {
            if(max < ent.getValue()) {
                ans = ent.getKey();
                max = ent.getValue();
            }
        }
        return ans;
    }
}

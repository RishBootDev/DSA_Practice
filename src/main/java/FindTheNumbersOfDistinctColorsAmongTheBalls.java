import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindTheNumbersOfDistinctColorsAmongTheBalls {

    public int[] queryResults(int limit, int[][] queries) {

        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> ball = new HashMap<>();
        int [] res = new int[queries.length];
        int i = 0;
        for(int [] q : queries) {
            int b = q[0];
            int c = q[1];
            if(ball.containsKey(b)) {
                int previousColour = ball.get(b);
                if(map.get(previousColour) >1) {
                    map.put(previousColour, map.get(previousColour)-1);
                }else map.remove(previousColour);
                ball.put(b, c);
                map.put(c, map.getOrDefault(c, 0) + 1);
            }else {
               ball.put(b, c);
               map.put(c, map.getOrDefault(c, 0) + 1);
            }
            res[i ++ ] = map.size();
        }
        return res;
    }
}

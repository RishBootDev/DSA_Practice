import java.util.HashMap;
import java.util.Map;

public class NumberOfPairsOfInterchangeableRectangles {

    public long interchangeableRectangles(int[][] rectangles) {

        Map<Double, Integer> map = new HashMap<>();
        for(int rect[] : rectangles) {
            if(map.containsKey(rect[0]/(rect[1]*1.0))) {
                map.put(rect[0]/(1.0 * rect[1]), map.getOrDefault(rect[0]/(1.0 * rect[1]), 0) + 1);
            }
            else map.put(rect[0]/(1.0 * rect[1]), 1);
        }
        int count = 0;
        for(int val : map.values()) {
            count += (val * (val - 1))/2;
        }
        return count;
    }
}

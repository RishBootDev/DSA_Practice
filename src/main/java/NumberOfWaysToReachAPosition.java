import java.util.HashMap;
import java.util.Map;

public class NumberOfWaysToReachAPosition {

    Map<String, Integer> map;
    public int numberOfWays(int startPos, int endPos, int k) {
        map = new HashMap<>();
        return helper(startPos, endPos, k);
    }
    public int helper(int start, int end, int k) {
        if(k == 0) {
            if(start == end) return 1;
            return 0;
        }
        String key = start + " " + k;
        if(map.containsKey(key)) return map.get(key);
        // move left
        int left = helper(start - 1, end, k - 1);
        // move right
        int right = helper(start + 1, end, k - 1);

        int ans = left + right;
        map.put(key, ans);
        return ans;
    }
}

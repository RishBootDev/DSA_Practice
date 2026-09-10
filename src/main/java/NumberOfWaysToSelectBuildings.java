import java.util.HashMap;
import java.util.Map;

public class NumberOfWaysToSelectBuildings {

    private Map<String, Long> map;

    public long numberOfWays(String s) {
        map = new HashMap<>();
        return helper(s, '$', 0, 0);
    }

    public long helper(String s, char prev, int i, int count) {
        if (count == 3) return 1;
        if (i == s.length()) return 0;

        String key = prev + " " + i + " " + count;
        if(map.containsKey(key)) return map.get(key);

        long ans = 0;
        if (prev == '$') {
            ans += helper(s, s.charAt(i), i + 1, count + 1);
            ans += helper(s, '$', i + 1, count);
        } else {
            if (prev != s.charAt(i)) {
                ans += helper(s, s.charAt(i), i + 1, count + 1);
            }
            ans += helper(s, prev, i + 1, count);
        }
        map.put(key, ans);
        return ans;
    }
}

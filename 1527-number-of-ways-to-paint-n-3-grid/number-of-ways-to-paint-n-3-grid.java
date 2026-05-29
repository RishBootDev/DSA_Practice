import java.util.HashMap;
import java.util.Map;

class Solution {
    
    private final int MOD = 1_000_000_007;
    private Map<String, Integer> map;

    public int numOfWays(int n) {
        this.map = new HashMap<>();
        return helper(n, 0, 0, null, new String[3]);
    }

    public int helper(int n, int i, int j, String leftColor, String[] prevRow) {

        if (i == n) return 1;

        if (j == 3) return helper(n, i + 1, 0, null, prevRow);
        
        String upColor = prevRow[j];
        
        String key = i + " " + j + " " + leftColor + " " + prevRow[0] + " " + prevRow[1] + " " + prevRow[2];
        if (map.containsKey(key)) return map.get(key);

        int count = 0;

        if (leftColor == null && upColor == null) {
            count = (count + runNext(n, i, j, "red", prevRow)) % MOD;
            count = (count + runNext(n, i, j, "green", prevRow)) % MOD;
            count = (count + runNext(n, i, j, "yellow", prevRow)) % MOD;
        } else if (leftColor != null && upColor == null) {
            if (leftColor.equals("red")) {
                count = (count + runNext(n, i, j, "green", prevRow)) % MOD;
                count = (count + runNext(n, i, j, "yellow", prevRow)) % MOD;
            } else if (leftColor.equals("yellow")) {
                count = (count + runNext(n, i, j, "red", prevRow)) % MOD;
                count = (count + runNext(n, i, j, "green", prevRow)) % MOD;
            } else {
                count = (count + runNext(n, i, j, "red", prevRow)) % MOD;
                count = (count + runNext(n, i, j, "yellow", prevRow)) % MOD;
            }
        } else {
            if (!"red".equals(leftColor) && !"red".equals(upColor)) {
                count = (count + runNext(n, i, j, "red", prevRow)) % MOD;
            }
            if (!"green".equals(leftColor) && !"green".equals(upColor)) {
                count = (count + runNext(n, i, j, "green", prevRow)) % MOD;
            }
            if (!"yellow".equals(leftColor) && !"yellow".equals(upColor)) {
                count = (count + runNext(n, i, j, "yellow", prevRow)) % MOD;
            }
        }
        
        map.put(key, count);
        return count;
    }

    private int runNext(int n, int i, int j, String nextColor, String[] prevRow) {
        String[] nextRow = new String[]{prevRow[0], prevRow[1], prevRow[2]};
        nextRow[j] = nextColor;
        return helper(n, i, j + 1, nextColor, nextRow);
    }
}
import java.util.HashMap;
import java.util.Map;

public class NumberOfWaysToPaintGrid {

    private final int MOD = 1_000_000_007;
    Integer dp[][][][];
    private Map<String, Integer> map;

    public int numOfWays(int n) {
        int ans = 0;
        this.dp = new Integer[n][3][3][3];
        this.map = new HashMap<>();
        boolean[][] visited = new boolean[n][3];
        ans = (ans + helper(n, 0, 0, null, "start", visited)) % MOD;
        return ans;
    }

    public int helper(int n, int i, int j, String color, String comingFrom, boolean[][] visited) {

        if(!check(n, i, j)) return 0;

        if(visited[i][j]) return 0;

        if(i == n - 1 && j == 2) {
            if(color == null) return 3;
            return 2;
        }

        StringBuilder key = new StringBuilder(i + j + " " + color + " " + comingFrom);

        if(map.containsKey(key.toString())) return map.get(key.toString());

        visited[i][j] = true;

        int count = 0;
        if(color == null) {
            if (!comingFrom.equals("left")) {
                count = (count + helper(n, i, j + 1, "red", "right", visited)) % MOD;
                count = (count + helper(n, i, j + 1, "green", "right", visited)) % MOD;
                count = (count + helper(n, i, j + 1, "yellow", "right", visited)) % MOD;
            }

            if (!comingFrom.equals("up")) {
                count = (count + helper(n, i + 1, j, "red", "down", visited)) % MOD;
                count = (count + helper(n, i + 1, j, "green", "down", visited)) % MOD;
                count = (count + helper(n, i + 1, j, "yellow", "down", visited)) % MOD;
            }

            if (!comingFrom.equals("down")) {
                count = (count + helper(n, i - 1, j, "red", "up", visited)) % MOD;
                count = (count + helper(n, i - 1, j, "green", "up", visited)) % MOD;
                count = (count + helper(n, i - 1, j, "yellow", "up", visited)) % MOD;
            }

            if (!comingFrom.equals("right")) {
                count = (count + helper(n, i, j - 1, "red", "left", visited)) % MOD;
                count = (count + helper(n, i, j - 1, "green", "left", visited)) % MOD;
                count = (count + helper(n, i, j - 1, "yellow", "left", visited)) % MOD;
            }
        } else if(color.equals("red")) {

            if (!comingFrom.equals("left")) {
                count = (count + helper(n, i, j + 1, "green", "right", visited)) % MOD;
                count = (count + helper(n, i, j + 1, "yellow", "right", visited)) % MOD;
            }

            if (!comingFrom.equals("up")) {
                count = (count + helper(n, i + 1, j, "green", "down", visited)) % MOD;
                count = (count + helper(n, i + 1, j, "yellow", "down", visited)) % MOD;
            }

            if (!comingFrom.equals("down")) {
                count = (count + helper(n, i - 1, j, "green", "up", visited)) % MOD;
                count = (count + helper(n, i - 1, j, "yellow", "up", visited)) % MOD;
            }

            if (!comingFrom.equals("right")) {
                count = (count + helper(n, i, j - 1, "green", "left", visited)) % MOD;
                count = (count + helper(n, i, j - 1, "yellow", "left", visited)) % MOD;
            }
        } else if (color.equals("yellow")) {
            if (!comingFrom.equals("left")) {
                count = (count + helper(n, i, j + 1, "red", "right", visited)) % MOD;
                count = (count + helper(n, i, j + 1, "green", "right", visited)) % MOD;
            }

            if (!comingFrom.equals("up")) {
                count = (count + helper(n, i + 1, j, "red", "down", visited)) % MOD;
                count = (count + helper(n, i + 1, j, "green", "down", visited)) % MOD;
            }

            if (!comingFrom.equals("down")) {
                count = (count + helper(n, i - 1, j, "red", "up", visited)) % MOD;
                count = (count + helper(n, i - 1, j, "green", "up", visited)) % MOD;
            }

            if (!comingFrom.equals("right")) {
                count = (count + helper(n, i, j - 1, "red", "left", visited)) % MOD;
                count = (count + helper(n, i, j - 1, "green", "left", visited)) % MOD;
            }
        } else {
            if (!comingFrom.equals("left")) {
                count = (count + helper(n, i, j + 1, "red", "right", visited)) % MOD;
                count = (count + helper(n, i, j + 1, "yellow", "right", visited)) % MOD;
            }

            if (!comingFrom.equals("up")) {
                count = (count + helper(n, i + 1, j, "red", "down", visited)) % MOD;
                count = (count + helper(n, i + 1, j, "yellow", "down", visited)) % MOD;
            }

            if (!comingFrom.equals("down")) {
                count = (count + helper(n, i - 1, j, "red", "up", visited)) % MOD;
                count = (count + helper(n, i - 1, j, "yellow", "up", visited)) % MOD;
            }

            if (!comingFrom.equals("right")) {
                count = (count + helper(n, i, j - 1, "red", "left", visited)) % MOD;
                count = (count + helper(n, i, j - 1, "yellow", "left", visited)) % MOD;
            }
        }

        visited[i][j] = false;

        map.put(key.toString(), count);

        return count;
    }

    public boolean check(int n , int i, int j) {
        if(i < 0 || j < 0) return false;
        if(i >= n || j >= 3) return false;

        return true;
    }

}

import java.util.Map;

public class NumberOfWaysToReachTheKstStair {

    Map<String, Integer> map;
    public int waysToReachStair(int k) {
        return helper(1, k, 0, true);
    }

    public int helper(int i, int k, int jump, boolean flag) {

        if (i > k + 1) return 0;
        int path = 0;
        if (i == k) path = 1;
        String key = i + " " + jump + " " + flag;
        if(map.containsKey(key)) return map.get(key);

        path += helper(i + (int)Math.pow(2, jump), k, jump + 1, true);
        if (flag && i > 0) {
            path += helper(i - 1, k, jump, false);
        }
        map.put(key, path);
        return path;
    }
}

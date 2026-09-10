import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

public class StoneGame7 {

    Map<String, Integer> map;
    public int stoneGameVII(int[] stones) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        map = new HashMap<>();
        int sum = 0;
        for (int c : stones) {
            dq.offerLast(c);
            sum += c;
        }
        return helper(dq, 1, 0, 0, sum);
    }

    public int helper(ArrayDeque<Integer> dq, int temp, int a, int b, int sum) {

        if (dq.isEmpty()) {
            return a - b;
        }
        String key = a + " " + b + " " + temp;
        if(map.containsKey(key)) return map.get(key);
        if (temp == 1) {

            int x = dq.pollFirst();
            int first = helper(dq, 0, a + sum - x, b, sum - x);
            dq.offerFirst(x);

            x = dq.pollLast();
            int last = helper(dq, 0, a + sum - x, b, sum - x);
            dq.offerLast(x);

            int ans = Math.max(first, last);
            map.put(key, ans);
            return ans;

        } else {
            int x = dq.pollFirst();
            int first = helper(dq, 1, a, b + sum - x, sum - x);
            dq.offerFirst(x);

            x = dq.pollLast();
            int last = helper(dq, 1, a, b + sum - x, sum - x);
            dq.offerLast(x);

            int ans = Math.min(first, last);
            map.put(key, ans);
            return ans;
        }
    }
}
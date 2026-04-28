import java.util.HashMap;
import java.util.Map;

public class MinimumRoundsToCompleteAllTask {

    public int minimumRounds(int[] tasks) {

        Map<Integer, Integer> map = new HashMap<>();

        for(int task : tasks)
            map.put(task, map.getOrDefault(task, 0) + 1);

        int ans = 0;

        for(int x : map.values()) {

            int temp = x % 3;
            int div = x / 3;

            if(x == 1) return -1;

            if(temp == 0) {
                ans += div;
            }
            else if(temp == 1) {
                if(div >= 1)
                    ans += (div - 1) + 2;
                else
                    return -1;
            }
            else {
                ans += div + 1;
            }
        }

        return ans;
    }
}
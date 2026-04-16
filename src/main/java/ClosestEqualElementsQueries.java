import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClosestEqualElementsQueries {


    // This is my initial approach to solve the problem and it clears 612 test cases out of 614 but
    // this approach did not survived the constraints and eventually got time limit exceeded
    public List<Integer> solveQueries(int[] nums, int[] queries) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(nums[i], list);
            }
        }

        List<Integer> ans = new ArrayList<>();

        for (int x : queries) {

            List<Integer> list = map.get(nums[x]);

            if (list.size() == 1) {
                ans.add(-1);
            } else {
                int idx = x;
                int min = Integer.MAX_VALUE;
                for (int y : list) {
                    if (y == idx) continue;

                    int dist = Math.abs(y - idx);
                    int circularDist = n - dist;

                    min = Math.min(min, Math.min(dist, circularDist));
                }

                ans.add(min);
            }
        }

        return ans;
    }
}
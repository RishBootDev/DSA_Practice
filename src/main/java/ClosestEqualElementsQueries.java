import java.util.*;

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

    // this is the optimized approach where i am trying to have binary search on answer
    public List<Integer> solveQueries2(int[] nums, int[] queries) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        List<Integer> ans = new ArrayList<>();

        for (int x : queries) {

            List<Integer> list = map.get(nums[x]);

            if (list.size() == 1) {
                ans.add(-1);
                continue;
            }

            int idx = x;
            int min = Integer.MAX_VALUE;

            int pos = Collections.binarySearch(list, idx);

            int leftIdx;
            if (pos > 0) {
                leftIdx = list.get(pos - 1);
            } else {
                leftIdx = list.get(list.size() - 1);
            }

            int distLeft = Math.abs(idx - leftIdx);
            min = Math.min(min, Math.min(distLeft, n - distLeft));

            int rightIdx;
            if (pos < list.size() - 1) {
                rightIdx = list.get(pos + 1);
            } else {
                rightIdx = list.get(0);
            }

            int distRight = Math.abs(idx - rightIdx);
            min = Math.min(min, Math.min(distRight, n - distRight));

            ans.add(min);
        }

        return ans;
    }
}
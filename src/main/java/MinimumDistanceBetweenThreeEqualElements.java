import java.util.*;

public class MinimumDistanceBetweenThreeEqualElements {

    public int minimumDistance(int[] nums) {

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }

        int min = Integer.MAX_VALUE;

        for (Map.Entry<Integer, List<Integer>> ent : map.entrySet()) {

            List<Integer> list = ent.getValue();

            if (list.size() >= 3) {

                for (int i = 0; i <= list.size() - 3; i++) {

                    int a = list.get(i);
                    int b = list.get(i + 1);
                    int c = list.get(i + 2);

                    int temp = Math.abs(a - b)
                            + Math.abs(b - c)
                            + Math.abs(c - a);

                    min = Math.min(min, temp);
                }
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
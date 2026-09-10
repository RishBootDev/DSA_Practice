import java.util.ArrayList;
import java.util.List;

public class MinimumNumberOfOperationsToMakeUniGrid {

    public int minOperations(int[][] grid, int x) {
        List<Integer> nums = new ArrayList<>();

        for (int[] row : grid) {
            for (int num : row) {
                nums.add(num);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            int count = 0;
            for (int j = 0; j < nums.size(); j++) {
                if(i == j) continue;

                int diff = Math.abs(nums.get(i) - nums.get(j));
                if(diff % x == 0) {
                    count += (diff/x);
                }else {
                    break;
                }
            }
            min = Math.min(min, count);
        }
        return min == Integer.MAX_VALUE?-1:min;
    }
}



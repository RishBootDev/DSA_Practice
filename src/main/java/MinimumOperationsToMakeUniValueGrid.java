import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimumOperationsToMakeUniValueGrid {

    public int minOperations(int[][] grid, int x) {
        List<Integer> nums = new ArrayList<>();

        for (int[] row : grid) {
            for (int num : row) {
                nums.add(num);
            }
        }

        int rem = nums.get(0) % x;
        for (int num : nums) {
            if (num % x != rem) {
                return -1;
            }
        }

        Collections.sort(nums);
        int med = nums.get(nums.size() / 2);

        int ans = 0;
        for (int num : nums) {
            ans += Math.abs(num - med) / x;
        }

        return ans;
    }
}

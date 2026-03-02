import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MinimumSwapsToArrangeABinaryGrid {

    public int minSwaps(int[][] grid) {

        int n = grid.length;
        int ans = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 0) count++;
                else break;
            }
            map.put(i, count);
        }

        ArrayList<Integer> arr = new ArrayList<>(map.values());

        Collections.sort(arr, (a, b) -> b - a);

        for (int i = 0; i < n; i++) {
            if (arr.get(i) < (n - 1 - i)) {
                return -1;
            }
        }

        for (int i = 0; i < n; i++) {
            if (arr.get(i) != map.get(i)) {
                ans++;
            }
        }

        return ans;
    }
}
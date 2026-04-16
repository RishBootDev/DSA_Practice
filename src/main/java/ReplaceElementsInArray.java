import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ReplaceElementsInArray {

    public int[] arrayChange(int[] nums, int[][] operations) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for(int [] op : operations) {
            int num1 = op[0];
            int num2 = op[1];

            int idx = map.get(num1);
            nums[idx] = num2;
        }

        return nums;
    }
}

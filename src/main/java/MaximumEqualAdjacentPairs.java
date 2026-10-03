import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MaximumEqualAdjacentPairs {

    public int maxEqualAdjacentPairs(int[] nums) {

        Map<String, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if(nums[i] == nums[i + 1]) count++;
            String key = Math.max(nums[i], nums[i+1]) + " " + Math.min(nums[i], nums[i + 1]);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        if(map.size() == 1) return count;
        int max = Integer.MIN_VALUE;
        for(int c : map.values()) max = Math.max(max, c);
        return max + count;
    }
}

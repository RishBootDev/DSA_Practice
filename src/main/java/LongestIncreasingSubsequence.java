import java.util.HashMap;
import java.util.Map;

public class LongestIncreasingSubsequence {

    Map<String, Integer> map;
    public int lengthOfLIS(int[] nums) {
        map = new HashMap<>();
       return helper(nums, 0, -1);
    }
    public int helper(int nums[], int i, int prev) {
        if(i == nums.length) {
            return 0;
        }
        String key = i + " " + prev;
        if(map.containsKey(key)) return map.get(key);

        if(prev == -1) {
            // take
            int take = helper(nums, i + 1, i) + 1;
            // not take
            int not = helper(nums, i + 1, -1);
            int ans = Math.max(take, not);
            map.put(key, ans);
            return ans;
        }else {
            if(nums[i] >= nums[prev]) {
                // take
                int take = helper(nums, i + 1, i) + 1;
                // not take
                int not = helper(nums, i + 1, prev);
                int ans = Math.max(take, not);
                map.put(key, ans);
                return ans;
            }
            int ans = helper(nums, i + 1, prev);
            map.put(key, ans);
            return ans;
        }
    }
}

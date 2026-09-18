import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CountNicePairsInArray {

    public int countNicePairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        long count = 0;
        int MOD = 1_000_000_007;

        for (int i = 0; i < nums.length; i++) {

            StringBuilder sb = new StringBuilder(String.valueOf(nums[i]));
            int rev = Integer.parseInt(sb.reverse().toString());

            int target = nums[i] - rev;

            if(map.containsKey(target)) {
                count = (count + map.get(target)) % MOD;
            }

            map.put(target, map.getOrDefault(target, 0) + 1);
        }

        return (int) count;
    }
}

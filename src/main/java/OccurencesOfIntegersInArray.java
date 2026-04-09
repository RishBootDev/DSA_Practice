import java.util.HashMap;
import java.util.Map;

public class OccurencesOfIntegersInArray {

    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {

        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if(nums[i] == x) {
                count++;
                map.put(count, i);
            }
        }

        int ans [] = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            ans[i] = map.getOrDefault(queries[i], -1);
        }

        return ans;
    }
}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumIndexOfAValidSplit {

    public int minimumIndex(List<Integer> nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int x : nums)
            map.put(x, map.getOrDefault(x, 0) + 1);

        int max = Integer.MIN_VALUE;
        int maxKey = Integer.MIN_VALUE;

        for(Map.Entry<Integer, Integer> ent : map.entrySet()) {
            int key = ent.getKey();
            int value = ent.getValue();

            if(max < value) {
                max = value;
                maxKey = key;
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            if(nums.get(i) == maxKey) list.add(i);
        }

        int n = nums.size();
        int total = list.size();

        for (int k = 0; k < list.size(); k++) {
            int i = list.get(k);

            if(i == n - 1) break;

            int leftCount = k + 1;
            int rightCount = total - leftCount;

            int leftSize = i + 1;
            int rightSize = n - leftSize;

            if(leftCount * 2 > leftSize && rightCount * 2 > rightSize)
                return i;
        }

        return -1;
    }
}
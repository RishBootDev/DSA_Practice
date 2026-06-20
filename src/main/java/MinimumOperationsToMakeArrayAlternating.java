import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MinimumOperationsToMakeArrayAlternating {

    public int minimumOperations(int[] nums) {

        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if(i % 2 == 0) {
                map1.put(nums[i], map1.getOrDefault(nums[i], 0) + 1);
            }else {
                map2.put(nums[i], map2.getOrDefault(nums[i], 0) + 1);
            }
        }
        int max1 = Integer.MIN_VALUE;
        int temp1 = -1;
        int max2 = Integer.MIN_VALUE;
        int temp2 = -1;
        for(Map.Entry<Integer, Integer> ent : map1.entrySet()) {
            if(ent.getValue() > max1) {
                temp1 = ent.getKey();
            }
        }
        for(Map.Entry<Integer, Integer> ent : map2.entrySet()) {
            if(ent.getValue() > max2) {
                temp2 = ent.getKey();
            }
        }
        if(temp1 != temp2) {
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if(i % 2 ==0) {
                    if(nums[i] != temp1) count++;
                }else {
                    if(nums[i] != temp2) count++;
                }
            }
            return count;
        }else {
            if(!Objects.equals(map1.get(temp1), map2.get(temp2))) {

            }
        }
        return 0;
    }

}

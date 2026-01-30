import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class ReductionOperations {

    public int reductionOperations(int[] nums) {

        SortedMap<Integer,Integer> map = new TreeMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        int c = 0;
        int ans = 0;
        for(Map.Entry<Integer,Integer> ent: map.entrySet()){
            ans += c++ * ent.getValue();
        }
        return ans;
    }
}

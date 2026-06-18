import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int minimumOperations(int[] nums) {

        if(nums.length == 1) return 0;

        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if(i % 2 == 0) {
                map1.put(nums[i], map1.getOrDefault(nums[i], 0) + 1);
            } else {
                map2.put(nums[i], map2.getOrDefault(nums[i], 0) + 1);
            }
        }

        int evenMaxVal = -1;
        int evenMaxFreq = 0;
        int evenSecondFreq = 0;

        for(Map.Entry<Integer, Integer> ent : map1.entrySet()) {
            int freq = ent.getValue();

            if(freq > evenMaxFreq) {
                evenSecondFreq = evenMaxFreq;
                evenMaxFreq = freq;
                evenMaxVal = ent.getKey();
            } else if(freq > evenSecondFreq) {
                evenSecondFreq = freq;
            }
        }

        int oddMaxVal = -1;
        int oddMaxFreq = 0;
        int oddSecondFreq = 0;

        for(Map.Entry<Integer, Integer> ent : map2.entrySet()) {
            int freq = ent.getValue();

            if(freq > oddMaxFreq) {
                oddSecondFreq = oddMaxFreq;
                oddMaxFreq = freq;
                oddMaxVal = ent.getKey();
            } else if(freq > oddSecondFreq) {
                oddSecondFreq = freq;
            }
        }

        int evenCount = (nums.length + 1) / 2;
        int oddCount = nums.length / 2;

        if(evenMaxVal != oddMaxVal) {
            return (evenCount - evenMaxFreq)
                    + (oddCount - oddMaxFreq);
        }

        int option1 = (evenCount - evenMaxFreq)
                + (oddCount - oddSecondFreq);

        int option2 = (evenCount - evenSecondFreq)
                + (oddCount - oddMaxFreq);

        return Math.min(option1, option2);
    }
}
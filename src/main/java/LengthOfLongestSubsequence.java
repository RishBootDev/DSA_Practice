import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubsequence {

    Map<Integer, Integer> map;
    public int lenLongestFibSubseq(int[] arr) {
        this.map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                max = Math.max(max, helper(arr, i, j));
            }
        }
        return max;
    }
    public int helper(int [] arr, int i, int j) {

        if(j == arr.length) return 0;

        if(map.containsKey(arr[i] + arr[j])) {
            return helper(arr, j, map.get(arr[i] + arr[j])) + 1;
        }
        return 0;
    }
}

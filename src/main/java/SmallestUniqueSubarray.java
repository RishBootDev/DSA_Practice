import java.util.*;

public class SmallestUniqueSubarray {


    // this is a working approach but it only passed 577 out of 600 test cases
    public static int smallestUniqueSubarray(int[] arr) {

        int n = arr.length;

        Map<List<Integer>, Integer> map = new HashMap<>();
        for (int start = 0; start < n; start++) {
            List<Integer> current = new ArrayList<>();
            for (int end = start; end < n; end++) {
                current.add(arr[end]);
                List<Integer> subarray = new ArrayList<>(current);
                map.put(subarray, map.getOrDefault(subarray, 0) + 1);
            }
        }

        int min = Integer.MAX_VALUE;
        int ans = Integer.MAX_VALUE;

        for(Map.Entry<List<Integer>, Integer> ent : map.entrySet()) {
            List<Integer> key = ent.getKey();
            int value = ent.getValue();

            if(value == 1) {
                ans= Math.min(ans, key.size());
            }
        }
        // System.out.println(map);
        return ans;
    }

    public static void main(String[] args) {
        smallestUniqueSubarray(new int[]{1,1,1,1});
    }
}
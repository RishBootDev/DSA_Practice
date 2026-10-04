import java.util.HashMap;
import java.util.Map;

public class SubArraysWithOddSUm {

        Map<String, Integer> map;
        public int numOfSubarrays(int[] arr) {
            map = new HashMap<>();
            int count = 0;
            for (int i = 0; i < arr.length; i++) {
                count += helper(arr, i, 0);
            }
            return count;
        }

        public int helper(int arr[], int i, int sum) {

            if (i == arr.length) {
                return 0;
            }
            int parity = sum % 2;
            String key = i + " " + parity;
            if (map.containsKey(key)) {
                return map.get(key);
            }
            int newSum = sum + arr[i];
            int ans;
            if (newSum % 2 == 1) {
                ans = helper(arr, i + 1, newSum) + 1;
            } else {
                ans = helper(arr, i + 1, newSum);
            }
            map.put(key, ans);

            return ans;
        }
    }


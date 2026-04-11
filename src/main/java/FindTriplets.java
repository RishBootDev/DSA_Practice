import java.util.HashMap;
import java.util.Map;

public class FindTriplets {

    public boolean findTriplets(int[] arr) {

        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int n = arr.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                int a = arr[i];
                int b = arr[j];

                freq.put(a, freq.get(a) - 1);
                freq.put(b, freq.get(b) - 1);

                int target = -(a + b);

                if (freq.getOrDefault(target, 0) > 0) {
                    return true;
                }

                freq.put(a, freq.get(a) + 1);
                freq.put(b, freq.get(b) + 1);
            }
        }

        return false;
    }
}

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MostFrequentIds {

    public long[] mostFrequentIDs(int[] nums, int[] freq) {

        Map<Integer, Long> map = new HashMap<>();

        PriorityQueue<long[]> pq = new PriorityQueue<>(
                (a, b) -> Long.compare(b[0], a[0])
        );
        long[] ans = new long[nums.length];

        for (int i = 0; i < nums.length; i++) {

            int id = nums[i];
            long f = freq[i];

            long newFreq = map.getOrDefault(id, 0L) + f;
            map.put(id, newFreq);
            pq.add(new long[]{newFreq, id});

            while (!pq.isEmpty()) {
                long[] top = pq.peek();
                long storedFreq = map.getOrDefault((int)top[1], 0L);

                if (storedFreq != top[0]) {
                    pq.poll();
                } else break;
            }

            ans[i] = pq.isEmpty() ? 0 : pq.peek()[0];
        }

        return ans;
    }
}

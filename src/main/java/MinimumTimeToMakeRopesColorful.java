import java.util.PriorityQueue;

public class MinimumTimeToMakeRopesColorful {

    public int minCost(String colors, int[] neededTime) {
        int ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int count = 0;

        for (int i = 0; i < colors.length(); i++) {
            if (i < colors.length() - 1 && colors.charAt(i) == colors.charAt(i + 1)) {
                count++;
                pq.add(neededTime[i]);
            } else {
                pq.add(neededTime[i]);
                while (count-- > 0 && !pq.isEmpty()) {
                    ans += pq.poll();
                }
                pq.clear();
                count = 0;
            }
        }

        return ans;
    }
}

import java.math.BigInteger;
import java.util.PriorityQueue;

public class KthSmallestTrimmedNumbers {

    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {

        int ans [] = new int[queries.length];
        int j = 0;

        for(int[] query : queries) {

            // i used BigInteger to compare the nums but the best idea was the string comparison only as it compares the lexicographically which is correct
            PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) ->
            {
                if(a.dt.equals(b.dt)) return a.idx - b.idx;
                else return a.dt.compareTo(b.dt);
            });
            int k = query[0];
            int trim = query[1];

            for (int i = 0; i < nums.length; i++) {
                String tr = nums[i].substring(nums[i].length() - trim);
                Pair pair = new Pair(new BigInteger(tr), i);
                pq.add(pair);
            }

            int temp = -1;
            while (k --> 0) {
                temp = pq.poll().idx;
            }
            ans[j++] = temp;
        }

        return ans;
    }

    static class Pair{
        BigInteger dt;
        int idx;

        public Pair(BigInteger dt, int idx) {
            this.dt = dt;
            this.idx = idx;
        }
    }
}

import java.util.HashSet;
import java.util.PriorityQueue;

public class MaximizeYSumByXsum {

    public int maxSumDistinctTriplet(int[] x, int[] y) {

        HashSet<Integer> set = new HashSet<>();
        for(int a : x) set.add(a);

        if(set.size() <3) return -1;

        set.clear();
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2)->p2.a-p1.a);

        for (int i = 0; i < y.length; i++) {
            pq.add(new Pair(y[i], i));
        }

        int k = 3;
        int ans = 0;
        while(k>0) {

            Pair pair = pq.poll();
            int idx = pair.idx;
            if(!set.contains(x[idx])){
                ans += pair.a;
                set.add(x[idx]);
                k--;
            }
        }

        return ans;


    }

    static class Pair{
        int a;
        int idx;

        public Pair(int a, int idx) {
            this.a = a;
            this.idx = idx;
        }
    }
}

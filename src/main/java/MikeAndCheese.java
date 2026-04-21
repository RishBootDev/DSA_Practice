import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class MikeAndCheese {

    public int miceAndCheese(int[] reward1, int[] reward2, int k) {

        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a, b) -> (b.rec1 - b.rec2) - (a.rec1 - a.rec2));
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i< reward1.length; i++) {
            pq.add(new Pair(reward1[i], reward2[i], i));
        }
        int ans = 0;
        while(k --> 0) {
           Pair pair = pq.poll();
           ans += pair.rec1;
           set.add(pair.idx);
        }
        for (int i = 0; i < reward1.length; i++) {
            if(set.contains(i)) continue;
            ans += reward2[i];
        }
        return ans;
    }

    static class Pair{
        int rec1;
        int rec2;
        int idx;

        public Pair(int rec1, int rec2, int idx) {
            this.rec1 = rec1;
            this.rec2 = rec2;
            this.idx = idx;
        }
    }
}

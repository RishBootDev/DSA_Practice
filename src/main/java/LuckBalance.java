import java.util.List;
import java.util.PriorityQueue;

public class LuckBalance {

    public static int luckBalance(int k, List<List<Integer>> contests) {

        int ans = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1,p2)->p2.luck - p1.luck);

        for(List<Integer> list : contests) {
            if(list.get(1) == 0) ans += list.get(0);
            else {
                Pair pair = new Pair(list.get(0), list.get(1));
                pq.add(pair);
            }
        }

        while(k --> 0) {
            ans += pq.poll().luck;
        }

        while(!pq.isEmpty()) {
            ans -= pq.poll().luck;
        }
        return ans;

    }

    static class Pair{
        int luck;
        int imp;

        public Pair(int luck, int imp) {
            this.imp = imp;
            this.luck = luck;

        }
    }

}

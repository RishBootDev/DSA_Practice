import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FilterOccupiedIntervals {

    public List<List<Integer>> filterOccupiedIntervals(int[][] occ, int freeStart, int freeEnd) {

        Arrays.sort(occ, (a, b) -> a[0] - b[0]);
        List<List<Integer>> ans = new ArrayList<>();
        List<Pair> pairs = new ArrayList<>();
        for (int oc [] : occ) {
            Pair pair = new Pair(oc[0], oc[1]);
            pairs.add(pair);
        }
        List<Pair> merge = merge(pairs);
        System.out.println(merge);

        for(Pair pair : merge) {
            int start = pair.start;
            int end = pair.end;
            if(freeStart <= start && freeEnd >= end) {
                continue;
            }else if(freeStart <= start && freeEnd < end) {
                List<Integer> temp = new ArrayList<>();
                temp.add(freeEnd);
                temp.add(end);
                ans.add(temp);
            }else if (freeStart > start && freeEnd >= end) {
                List<Integer> temp = new ArrayList<>();
                temp.add(start);
                temp.add(freeStart);
                ans.add(temp);
            }
            else {
                List<Integer> temp = new ArrayList<>();
                temp.add(start);
                temp.add(freeStart);
                List<Integer> bemp = new ArrayList<>();
                bemp.add(freeEnd);
                bemp.add(end);
            }
        }
        return ans;
    }
    public List<Pair> merge(List<Pair> pairs) {

        List<Pair> ans = new ArrayList<>();
        if (pairs.isEmpty()) return ans;
        Pair p2 = pairs.getFirst();

        for (int i = 1; i < pairs.size(); i++) {
            Pair p1 = pairs.get(i);

            if (p1.start <= p2.end) {
                p2.end = Math.max(p2.end, p1.end);
            }
            else {
                ans.add(p2);
                p2 = p1;
            }
        }

        ans.add(p2);
        return ans;
    }

    static class Pair {
        int start;
        int end;

        @Override
        public String toString() {
            return "Pair{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }

        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}

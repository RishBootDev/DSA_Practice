import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximumUnitsInATruck {

    public int maximumUnits(int[][] boxTypes, int truckSize) {

        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) ->p1.unit - p2.unit);
        for(int[] box : boxTypes) {
            Pair pair = new Pair(box[0], box[1]);
            pq.add(pair);
        }
        int ans = 0;
        while(truckSize > 0) {
            Pair temp = pq.poll();
            if(temp.number <= truckSize) {
                truckSize -= temp.number;
                ans += temp.unit * temp.number;
            }else {
                ans += temp.unit * truckSize;
                truckSize = 0;
            }
        }

        return ans;
    }

    static class Pair{
        int number;
        int unit;

        public Pair(int number, int unit) {
            this.number = number;
            this.unit = unit;
        }
    }
}

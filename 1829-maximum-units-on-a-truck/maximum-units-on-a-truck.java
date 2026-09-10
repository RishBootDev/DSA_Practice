class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {

        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) ->p2.unit - p1.unit);
        for(int[] box : boxTypes) {
            Pair pair = new Pair(box[0], box[1]);
            pq.add(pair);
        }
        int ans = 0;
        while(truckSize > 0 && !pq.isEmpty()) {
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




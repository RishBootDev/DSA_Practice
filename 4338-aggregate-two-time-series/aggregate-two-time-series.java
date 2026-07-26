class Solution {
    public List<List<Integer>> aggregateTimeSeries(int[][] series1, int[][] series2) {

        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Pair> pq1 = new PriorityQueue<>((p1, p2) -> p1.time - p2.time);
        PriorityQueue<Pair> pq2 = new PriorityQueue<>((p1, p2) -> p1.time - p2.time);

        for(int series[] : series1) {
            int key = series[0];
            int value = series[1];
            Pair pair = new Pair(key ,value);
            pq1.add(pair);

         //   map.put(key, map.getOrDefault(key, 0) + value);
        }

        for(int series[] : series2) {
            int key = series[0];
            int value = series[1];
            Pair pair = new Pair(key , value);
            pq2.add(pair);
           // map.put(key, map.getOrDefault(key, 0)+ value);
        }

        while(!pq1.isEmpty() && !pq2.isEmpty()) {
            Pair pair1 = pq1.poll();
            Pair pair2 = pq2.poll();

            if(pair1.time == pair2.time) {
                map.put(pair1.time, pair1.value + pair2.value);
            }else if(pair1.time > pair2.time) {
              //  Pair second = pq1.poll();
               
               // map.put(pair2.time, pair2.value);
                map.put(pair2.time, pair2.value + pair1.value);
                
                pq1.offer(pair1);
            }else {
        
                //Pair second = pq2.poll();
                //if(second == null) {
                   // map.put(pair1.time, pair1.value);
               
                    map.put(pair1.time, pair1.value + pair2.value);
                
                pq2.offer(pair2);
            }
        }
        if(!pq1.isEmpty()) {
            while(!pq1.isEmpty()) {
                Pair pair = pq1.poll();
                map.put(pair.time, pair.value);
            }
        }else if(!pq2.isEmpty()){
            while(!pq2.isEmpty()) {
                Pair pair = pq2.poll();
                map.put(pair.time, pair.value);
            }
        }
        
        List<List<Integer>> list = new ArrayList<>();
        for(Map.Entry<Integer, Integer> ent : map.entrySet()) {
            List<Integer> temp = new ArrayList<>();
            temp.add(ent.getKey());
            temp.add(ent.getValue());
            list.add(temp);
        }

        list.sort((l1, l2) -> l1.getFirst() - l2.getFirst());

        return list;
    }

    static class Pair{
        int time;
        int value;

        public Pair(int time, int value) {
            this.time = time;
            this.value = value;
        }
    }
}
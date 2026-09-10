class Solution {
    
    public int edgeScore(int[] edges) {

        Map<Integer, Long> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {

            if (map.containsKey(edges[i])) {
                long sum = map.get(edges[i]);
                sum += i;
                map.put(edges[i], sum);
            } else {
                map.put(edges[i], (long) i);
            }
        }
        long max = Long.MIN_VALUE;
        int ans = -1;
        for(Map.Entry<Integer, Long> ent : map.entrySet()) {
            
            if (ent.getValue() > max ||
        (ent.getValue() == max && ent.getKey() < ans)) {

        max = ent.getValue();
        ans = ent.getKey();
    }
        }
        return ans;
    }
}
class Solution {
    
    public long interchangeableRectangles(int[][] rectangles) {

        Map<Double, Long> map = new HashMap<>();
        for(int rect[] : rectangles) {
            if(map.containsKey(rect[0]/(rect[1]*1.0))) {
                map.put(rect[0]/(1.0 * rect[1]), map.getOrDefault(rect[0]/(1.0 * rect[1]), 0l) + 1l);
            }
            else map.put(rect[0]/(1.0 * rect[1]), 1l);
        }
        long count = 0;
        for(long val : map.values()) {
            count += (val * (val - 1))/2;
        }
        return count;
    }
}
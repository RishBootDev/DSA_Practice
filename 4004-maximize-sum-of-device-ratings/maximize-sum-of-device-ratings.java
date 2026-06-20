class Solution {
    public long maxRatings(int[][] units) {
        
        long first = 0;
        long second = 0;
        long min1 = Long.MAX_VALUE;
        long min2 = Long.MAX_VALUE;

        for(int [] tm: units) {
            Arrays.sort(tm);
            first += tm[0];
            if(tm.length == 1) second += tm[0];
            else second += tm[1];
            min1 = Math.min(min1, tm[0]);
            if(tm.length == 1)
               min2 = Math.min(min2, tm[0]);
            else min2 = Math.min(min2, tm[1]);
        }
        

        return Math.max(first, min1 + second - min2);
    }
}
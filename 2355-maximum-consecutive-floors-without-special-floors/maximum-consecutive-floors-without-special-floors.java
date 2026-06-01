class Solution {
    public int maxConsecutive(int bottom, int top, int[] special) {
        
         Arrays.sort(special);

         int max = Integer.MIN_VALUE;
         for(int i = 0; i< special.length-1; i++) {
            int diff = special[i+1] - special[i] - 1;
            max = Math.max(diff, max);
         }

         max = Math.max(max, special[0] - bottom);
         max = Math.max(max, top - special[special.length-1]);
         return max;
    }
}
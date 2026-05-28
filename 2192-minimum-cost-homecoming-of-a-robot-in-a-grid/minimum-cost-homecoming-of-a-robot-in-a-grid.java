class Solution {
    public int minCost(int[] startPos, int[] homePos,
                               int[] rowCosts, int[] colCosts) {

               int ans = 0;
               int start = startPos[1];
               int end = homePos[1];
               while(start != end) {
                   if(start > end ) start --;
                   else start ++;
                   ans += colCosts[start];
               }

               start = startPos[0];
               end = homePos[0];
               
               while(start != end) {
                   if(start > end) start--;
                   else start ++;
                   
                   ans += rowCosts[start];
               }
               
               return ans;
            }
}
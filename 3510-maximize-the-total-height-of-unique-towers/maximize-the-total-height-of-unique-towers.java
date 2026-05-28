class Solution {
    
    public long maximumTotalSum(int[] maximumHeight) {

        Arrays.sort(maximumHeight);
        for (int i = maximumHeight.length - 1; i >0 ; i--) {
            if(maximumHeight[i] <= maximumHeight[i-1]) {
                maximumHeight[i-1] = maximumHeight[i] - 1;
            }
        }
        
        long ans = 0;
        for(int c : maximumHeight) {
            if(c < 1) return -1;
            ans += c;
        }
        
        return ans;
    }
}

// 2 3 3 4
// 10 15
// 1 2 2

class Solution {
    
     public int[] missingRolls(int[] rolls, int mean, int n) {
        int sumx = 0;
        for (int c : rolls) sumx += c;
        int sumy = mean * (n + rolls.length) - sumx;

        if (sumy < n || sumy > 6 * n) return new int[0];

        int[] ans = new int[n];
        int base = sumy / n;
        int rem = sumy % n;
        for (int i = 0; i < n; i++) {
            ans[i] = base;
            if (rem > 0) {
                ans[i]++;
                rem--;
            }
        }
        return ans;
    }
}
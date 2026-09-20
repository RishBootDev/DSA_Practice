class Solution {
    public int reverseDegree(String s) {
        int ans = 0;

        for (int i = 1; i <= s.length(); i++) {
            ans += ('z' - s.charAt(i - 1) + 1) * i;
        }

        return ans;
    }
}

class Solution {
    public int countCommas(int n) {
        if(n < 1000) return 0;

        int count = 0;

        for(int i = 1; i <= n; i++) {
            String temp = String.valueOf(i);

            if(temp.length() >= 4) {
                count += (temp.length() - 1) / 3;
            }
        }

        return count;
    }
}

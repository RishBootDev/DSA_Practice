public class OnesAndZeroes {

    public int findMaxForm(String[] strs, int m, int n) {
       return helper(strs, 0, m, n);
    }
    public int helper(String [] strs, int i, int m, int n) {
        // base case
        if(i == strs.length) return Integer.MAX_VALUE;

        int count0 = count0(strs[i]);
        int count1 = count1(strs[i]);

        if(count0 <= m && count1 <= n) {
            // take
            int take = helper(strs, i + 1, m - count0, n - count1) + 1;
            // not take
            int not = helper(strs, i + 1, m, n);
            return Math.min(take, not);
        }
        return Integer.MAX_VALUE;
    }

    public int count0(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '0') count++;
        }
        return count;
    }
    public int count1(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '1') count++;
        }
        return count;
    }
}

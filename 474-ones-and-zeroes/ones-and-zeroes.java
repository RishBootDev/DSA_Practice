class Solution {
    
    Map<String, Integer> map;
    public int findMaxForm(String[] strs, int m, int n) {
        map = new HashMap<>();
       return helper(strs, 0, m, n);
    }
    public int helper(String [] strs, int i, int m, int n) {
        // base case
        if(i == strs.length) return 0;
       // if(m <= 0 && n <= 0) return 0;

        String key = i + " " + m + " " + n+ " ";
        if(map.containsKey(key)) return map.get(key);
        
        int count0 = count0(strs[i]);
        int count1 = count1(strs[i]);
        
        if(count0 <= m && count1 <= n) {
            // take
            int take = helper(strs, i + 1, m - count0, n - count1) + 1;
            // not take
            int not = helper(strs, i + 1, m, n);
            int ans = Math.max(take, not);
            map.put(key, ans);
            return ans;
        }
        int ans = helper(strs, i + 1, m, n);
        map.put(key, ans);
        return ans;
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
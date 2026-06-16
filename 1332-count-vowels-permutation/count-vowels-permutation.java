class Solution {

    private Map<String, Integer> map;
    int MOD = 1_000_000_007;

    public int countVowelPermutation(int n) {
        map = new HashMap<>();
        int ans = 0;

        ans = (ans + helper('a', n - 1)) % MOD;
        ans = (ans + helper('e', n - 1)) % MOD;
        ans = (ans + helper('i', n - 1)) % MOD;
        ans = (ans + helper('o', n - 1)) % MOD;
        ans = (ans + helper('u', n - 1)) % MOD;

        return ans;
    }

    public int helper(char ch, int rem) {

        if (rem == 0)
            return 1;

        String key = ch + " " + rem;
        if (map.containsKey(key))
            return map.get(key);

        int ans = 0;

        if (ch == 'a') {
            ans = (ans + helper('e', rem - 1)) % MOD;
        } else if (ch == 'e') {
            ans = (ans + helper('a', rem - 1)) % MOD;
            ans = (ans + helper('i', rem - 1)) % MOD;
        } else if (ch == 'i') {
            ans = (ans + helper('a', rem - 1)) % MOD;
            ans = (ans + helper('e', rem - 1)) % MOD;
            ans = (ans + helper('o', rem - 1)) % MOD;
            ans = (ans + helper('u', rem - 1)) % MOD;
        } else if (ch == 'o') {
            ans = (ans + helper('i', rem - 1)) % MOD;
            ans = (ans + helper('u', rem - 1)) % MOD;
        } else {
            ans = (ans + helper('a', rem - 1)) % MOD;
        }
        map.put(key, ans);
        return ans;
    }
}
class Solution {

    Map<String, Integer> map;
    int mod = 1000000007;

    public int numOfSubarrays(int[] arr) {
        map = new HashMap<>();

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            count = (count + helper(arr, i, 0)) % mod;
        }
        return count;
    }

    public int helper(int[] arr, int i, int parity) {
        if (i == arr.length) {
            return 0;
        }
        String key = i + " " + parity;
        if (map.containsKey(key)) {
            return map.get(key);
        }

        int newParity = (parity + arr[i]) % 2;
        int ans = helper(arr, i + 1, newParity);
        if (newParity == 1) {
            ans = (ans + 1) % mod;
        }
        map.put(key, ans);
        return ans;
    }
}
class Solution {

    HashMap<String, Boolean> dp = new HashMap<>();

    public boolean canCross(int[] stones) {
        return helper(stones, 0, 0);
    }

    public boolean helper(int[] stones, int i, int k) {

        if (i == stones.length - 1) {
            return true;
        }
        String key = i + "," + k;

        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        boolean ans = false;

        for (int j = i + 1; j < stones.length; j++) {

            int diff = stones[j] - stones[i];
            if (diff == k - 1 && diff > 0) {
                ans |= helper(stones, j, diff);
            }
            else if (diff == k) {
                ans |= helper(stones, j, diff);
            }
            else if (diff == k + 1) {
                ans |= helper(stones, j, diff);
            }

            if (diff > k + 1) {
                break;
            }
        }

        dp.put(key, ans);
        return ans;
    }
}
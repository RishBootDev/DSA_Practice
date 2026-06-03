class Solution {

    HashMap<Integer, Integer> dp = new HashMap<>();

    public int minimumOperationsToMakeEqual(int x, int y) {
        return helper(x, y);
    }

    public int helper(int x, int y) {

        if (x <= y) {
            return y - x;
        }

        if (dp.containsKey(x)) {
            return dp.get(x);
        }

        int op = x - y;

        if (x % 11 == 0) {
            op = Math.min(op, 1 + helper(x / 11, y));
        } else {
            op = Math.min(op, (x % 11) + 1 + helper(x / 11, y));

            op = Math.min(op, (11 - x % 11) + 1 + helper(x / 11 + 1, y));
        }

        if (x % 5 == 0) {
            op = Math.min(op, 1 + helper(x / 5, y));
        } else {
            op = Math.min(op, (x % 5) + 1 + helper(x / 5, y));

            op = Math.min(op,(5 - x % 5) + 1 + helper(x / 5 + 1, y));
        }
        dp.put(x, op);
        return op;
    }
}
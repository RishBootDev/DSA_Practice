class Solution {

    public int rotatedDigits(int n) {

        int count = 0;
        for (int i = 1; i <= n; i++) {

            if (helper(i) == 2) {
                count++;
            }
        }
        return count;
    }

    public int helper(int n) {

        if (n < 10) {
            if (n == 0 || n == 1 || n == 8) {
                return 1;
            }
            if (n == 2 || n == 5 || n == 6 || n == 9) {
                return 2;
            }
            return 0;
        }

        int left = helper(n / 10);
        int right = helper(n % 10);

        if (left == 0 || right == 0) {
            return 0;
        }
        if (left == 2 || right == 2) {
            return 2;
        }
        return 1;
    }
}
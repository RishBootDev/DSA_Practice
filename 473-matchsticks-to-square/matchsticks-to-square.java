class Solution {

    public boolean makesquare(int[] matchsticks) {

        int sum = 0;
        for (int x : matchsticks) {
            sum += x;
        }

        if (sum % 4 != 0) {
            return false;
        }

        Arrays.sort(matchsticks);
        int l = 0;
        int r = matchsticks.length - 1;

        while (l < r) {
            int temp = matchsticks[l];
            matchsticks[l] = matchsticks[r];
            matchsticks[r] = temp;
            l++;
            r--;
        }

        return helper(matchsticks, 0, 0, 0, 0, 0, sum);
    }

    public boolean helper(int[] match, int i,
                          int a, int b, int c, int d,
                          int sum) {

        int side = sum / 4;

        if (a > side || b > side || c > side || d > side) {
            return false;
        }

        if (i == match.length) {
            return a == side &&
                   b == side &&
                   c == side &&
                   d == side;
        }

        if (helper(match, i + 1,
                a + match[i], b, c, d, sum)) {
            return true;
        }

        if (a != b) {
            if (helper(match, i + 1,
                    a, b + match[i], c, d, sum)) {
                return true;
            }
        }

        if (b != c) {
            if (helper(match, i + 1,
                    a, b, c + match[i], d, sum)) {
                return true;
            }
        }

        if (c != d) {
            if (helper(match, i + 1,
                    a, b, c, d + match[i], sum)) {
                return true;
            }
        }
        return false;
    }
}
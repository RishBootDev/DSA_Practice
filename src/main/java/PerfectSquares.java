public class PerfectSquares {

    public int numSquares(int n) {
        return helper(n);
    }

    public int helper(int n) {

        if (n == 0) return 0;

        int j = 1;
        int min = Integer.MAX_VALUE;

        while (j * j <= n) {
            int take = 1 + helper(n - j * j);
            min = Math.min(min, take);
            j++;
        }

        return min;
    }
}
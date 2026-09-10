public class IntegerBreak {

    public int integerBreak(int n) {
       return helper(n);
    }
    public int helper(int n) {
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            max = Math.max(max, i * helper(n - i));
        }
        return max;
    }
}

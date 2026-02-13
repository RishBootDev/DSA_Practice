public class RodCuttingProblem {

    public static int rodCuttingProblem(int n, int v[], int i, int dp[]) {
        if(i <= 0) return 0;

        if(dp[i] != -1) return dp[i];

        int max = 0;
        for(int len = 1; len <= i; len++) {
            int profitAtThisCut = v[len-1] + rodCuttingProblem(n, v, i-len, dp);
            max = Math.max(max, profitAtThisCut);
        }

        return dp[i] = max;
    }

    // this is the recursion problem for the rod cutting problem
    public static int rodCuttingProblem(int n, int v[], int i) {
        if(i <= 0) return 0;

        int max = 0;
        for(int len = 1; len <= i; len++) {
            int profitAtThisCut = v[len-1] + rodCuttingProblem(n, v, i-len);
            max = Math.max(max, profitAtThisCut);
        }

        return max;
    }
}

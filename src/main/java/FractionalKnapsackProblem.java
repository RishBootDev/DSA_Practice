import java.util.Arrays;

public class FractionalKnapsackProblem {

    public static void main(String[] args) {

        int v[] = {1,2,3,4,5};
        int p[] = {1,2,3,4,5};
        int w = 5;

        int dp[][] = new int[v.length][p.length];
        Arrays.fill(dp, -1);

    }
// this the solution of the zero knapsack using the Plain Recursion
    public static int zeroOneKnapsack(int p[], int []v, int w, int i){

        if (i == -1) return 0;

        if (p[i] > w) return zeroOneKnapsack(p, v, w, i-1);

        else{
            int take = zeroOneKnapsack(p, v, w-p[i], i-1) + v[i];
            int nottake = zeroOneKnapsack(p,v,w,i-1);

            return Math.max(take, nottake);
        }
    }
// this is using the memoization
    public static int zeroOneKnapsack1(int p[], int []v, int w, int i, int dp[][]){

        if (i == -1) return 0;

        if(dp[i][w] == -1) return dp[i][w];

        if (p[i] > w) return dp[i][w] = zeroOneKnapsack1(p, v, w, i-1,dp);

        else{
            int take = zeroOneKnapsack1(p, v, w-p[i], i-1, dp) + v[i];
            int nottake = zeroOneKnapsack1(p,v,w,i-1, dp);

            return dp[i][w] = Math.max(take, nottake);
        }
    }
}

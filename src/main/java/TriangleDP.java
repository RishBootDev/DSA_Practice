import java.util.Arrays;
import java.util.List;


public class TriangleDP {

    public int minimumTotal(List<List<Integer>> triangle) {

        int dp[][] = new int[triangle.size()][triangle.getLast().size()];
        for(int [] d : dp)
            Arrays.fill(d, -1);

        return helper(triangle, 0, 0, dp);
    }

    public int helper(List<List<Integer>> tri, int i, int j, int dp[][]) {
        if(i == tri.size()) {
            return 0;
        }

        if(dp[i][j] != -1) return dp[i][j];

        int path1 = helper(tri, i + 1, j, dp) + tri.get(i).get(j);
        int path2 = helper(tri, i + 1, j+1, dp) + tri.get(i).get(j);

        return dp[i][j] = Math.min(path1, path2);
    }
}

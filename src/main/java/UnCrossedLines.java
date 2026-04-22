import java.util.Arrays;

public class UnCrossedLines {

    public int maxUncrossedLines(int[] nums1, int[] nums2) {

        int n = nums1.length;
        int m = nums2.length;

        int dp[][] = new int[n][m];
        for (int[] row : dp) Arrays.fill(row, -1);

        return helper(nums1, nums2, 0, 0, dp);
    }

    public int helper(int[] a, int[] b, int i, int j, int[][] dp) {

        if (i == a.length || j == b.length) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        if (a[i] == b[j]) {
            return dp[i][j] = 1 + helper(a, b, i + 1, j + 1, dp);
        }

        return dp[i][j] = Math.max(
                helper(a, b, i + 1, j, dp),
                helper(a, b, i, j + 1, dp)
        );
    }
}

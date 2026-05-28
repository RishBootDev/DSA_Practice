class Solution {

    int[][] dir = {
        {-1, 0}, {0, -1}, {0, 1}, {1, 0}
    };

    final long MOD = 1_000_000_007L;
    long[][] memo = new long[1001][1001]; 


    public int countPaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        long result = 0;

        for(long[] temp : memo) {
            Arrays.fill(temp, -1);
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
               result = (result + dfs(i, j, grid, m, n)) % MOD;
            }
        }
        return (int)result;
    }

    private long dfs(int i, int j, int[][] grid, int m, int n) {
        if(memo[i][j] != - 1) return (int)memo[i][j];
        long result = 1; 

        for(int[] arr : dir){
            int i_ = i + arr[0];
            int j_ = j + arr[1];

            if(isSafe(i_, j_, m ,n) && grid[i_][j_] < grid[i][j]) {
                result =  (int)(result +  dfs(i_, j_, grid, m ,n)) % MOD;
            }
        }
        return memo[i][j] = result;
    }

    private boolean isSafe(int i, int j, int m, int n) {
        return (i < m && i >= 0 && j < n && j >= 0);
    }
}
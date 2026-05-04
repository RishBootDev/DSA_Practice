public class LargestPlusSign {

    public int orderOfLargestPlusSign(int n, int[][] mines) {

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int size = helper(mines, i, j);
                max = Math.max(size, max);
            }
        }
        return max;
    }
    
    public int helper(int grid[][], int i, int j) {
        if (i < 0 || j < 0) {
             return 0;            
        }
        if(i >= grid.length || j >= grid[0].length) return 0;
        
        if(grid[i][j] == '0') return 0;
        
        int up = helper(grid, i - 1, j);
        int down = helper(grid, i + 1, j);
        int left = helper(grid, i, j - 1);
        int right = helper(grid, i, j + 1);
        
        return 1 + Math.min(up, Math.min(down, Math.min(left, right)));
    }
}

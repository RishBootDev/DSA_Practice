class Solution {

    public int getMaximumGold(int[][] grid) {

        int max = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {

                if(grid[i][j] == 0) continue;
                int temp = grid[i][j];
                grid[i][j] = 0;
                max = Math.max(max, helper(grid, i, j) + temp);
                grid[i][j] = temp;
            }
        }

        return max;
    }

    public int helper(int [][] grid, int i , int j) {

        int up = 0;
        int down = 0;
        int left = 0;
        int right = 0;

        if(check(grid, i - 1, j) && grid[i - 1][j] != 0) {
            int temp = grid[i - 1][j];
            grid[i - 1][j] = 0;
            up = helper(grid, i - 1, j) + temp;
            grid[i - 1][j] = temp;
        }

        if(check(grid, i + 1, j) && grid[i + 1][j] != 0) {
            int temp = grid[i + 1][j];
            grid[i + 1][j] = 0;
            down = helper(grid, i + 1, j) + temp;
            grid[i + 1][j] = temp;
        }

        if(check(grid, i , j - 1) && grid[i][j - 1] != 0) {
            int temp = grid[i][j - 1];
            grid[i][j - 1] = 0;
            left = helper(grid, i , j - 1) + temp;
            grid[i][j - 1] = temp;
        }

        if(check(grid, i , j + 1) && grid[i][j + 1] != 0) {
            int temp = grid[i][j + 1];
            grid[i][j + 1] = 0;
            right = helper(grid, i , j + 1) + temp;
            grid[i][j + 1] = temp;
        }

        return Math.max(up, Math.max(down, Math.max(left, right)));
    }

    public boolean check(int[][] grid, int i , int j) {
        return i >= 0 && i < grid.length &&
               j >= 0 && j < grid[0].length;
    }
}
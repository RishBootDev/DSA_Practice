class Solution {
   
    public boolean checkValidGrid(int[][] grid) {

       if (grid[0][0] != 0) return false;

        int last = grid.length * grid.length - 1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {

                if (grid[i][j] == last) continue;
                if (!helper(grid, i, j)) return false;
            }
        }
        return true;
    }

    public boolean helper(int [][] grid, int i, int j) {

        if(check(grid, i - 1, j - 2)) {
            if(grid[i-1][j-2] == grid[i][j] + 1) return true;
        }
        if(check(grid, i - 2, j - 1)) {
            if(grid[i-2][j - 1] == grid[i][j] + 1) return true;
        }
        if(check(grid, i - 2, j + 1)) {
            if(grid[i-2][j + 1] == grid[i][j] + 1) return true;
        }
        if(check(grid, i - 1, j + 2)) {
            if(grid[i-1][j + 2] == grid[i][j] + 1) return true;
        }
        if(check(grid, i + 1, j - 2)) {
            if(grid[i+1][j - 2] == grid[i][j] + 1) return true;
        }
        if(check(grid, i + 2, j - 1)) {
            if(grid[i+2][j - 1] == grid[i][j] + 1) return true;
        }
        if(check(grid, i + 1, j + 2)) {
            if(grid[i+1][j + 2] == grid[i][j] + 1) return true;
        }
        if(check(grid, i + 2, j + 1)) {
            if(grid[i+2][j + 1] == grid[i][j] + 1) return true;
        }
        return false;
    }
    public boolean check(int [][] grid, int i ,int j) {
        int m = grid.length;
        int n = grid[0].length;
        if(i < 0 || j < 0) return false;
        if(i >= m || j >= n ) return false;
        return true;
    }
}
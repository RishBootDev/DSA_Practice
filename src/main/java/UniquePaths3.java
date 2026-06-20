public class UniquePaths3 {

    public int uniquePathsIII(int[][] grid) {
        return helper(grid, 0, 0, new boolean[grid.length][grid[0].length]);
    }
    public int helper(int [][] grid, int i, int j, boolean vis[][]) {

        if(i == grid.length - 1 && j == grid[0].length) return 1;

        int up = 0, down = 0, left = 0, right = 0;
        if(check(grid, i- 1,j) && !vis[i-1][j]) {
            vis[i-1][j] = true;
            up = helper(grid, i - 1, j, vis) + 1;
            vis[i - 1][j] = false;
        }
        if(check(grid, i+ 1,j) && !vis[i+1][j]) {
            vis[i+1][j] = true;
            down = helper(grid, i + 1, j, vis) + 1;
            vis[i + 1][j] = false;
        }
        if(check(grid, i ,j - 1) && !vis[i][j-1]) {
            vis[i][j-1] = true;
            left = helper(grid, i , j-1, vis) + 1;
            vis[i][j-1] = false;
        }
        if(check(grid, i,j+1) && !vis[i][j+1]) {
            vis[i][j+1] = true;
            right = helper(grid, i , j+1, vis) + 1;
            vis[i][j+1] = false;
        }
        return up + down + left + right;
    }

    public boolean check(int grid[][], int i, int j) {
        if(i == grid.length || j == grid[0].length) return false;
        if(i < 0 || j < 0) return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println();

    }
}

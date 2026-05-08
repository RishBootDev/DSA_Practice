public class CherryPickUp {

    private int max = Integer.MIN_VALUE;
    public int cherryPickup(int[][] grid) {
         helper(grid, 0, 0, 0);
         return max;
    }
    public void helper(int [][] grid, int i, int j, int count) {
        if(i == grid.length && j == grid[0].length) {
             this.max = Math.max(count, max);
        }

        if(grid[i][j] == 1) count++;

        // come right
        if(j + 1 < grid[0].length && grid[i][j+1] != -1) {
            helper(grid, i, j+1, count);
        }
        // come down
        if(i + 1 < grid.length && grid[i+1][j] != -1) {
            helper(grid, i + 1, j, count);
        }
    }
}

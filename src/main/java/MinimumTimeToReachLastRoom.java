public class MinimumTimeToReachLastRoom {

//    public int minTimeToReach(int[][] moveTime) {
//
//
//    }
//    public int helper(int[][] grid, int i, int j, boolean[][] vis, int t) {
//
//        if (i == grid.length - 1 && j == grid[0].length - 1) {
//            return grid[i][j];
//        }
//
//        int up = Integer.MAX_VALUE;
//        int down = Integer.MAX_VALUE;
//        int left = Integer.MAX_VALUE;
//        int right = Integer.MAX_VALUE;
//
////        // up
////        if (check(grid, i - 1, j) && !vis[i - 1][j]) {
////            vis[i - 1][j] = true;
////            up = helper(grid, i - 1, j, vis);
////            if (up != Integer.MAX_VALUE)
////                up += grid[i][j];
////            vis[i - 1][j] = false;
////        }
//
//        // down
//        if (check(grid, i + 1, j) && !vis[i + 1][j]) {
//            vis[i + 1][j] = true;
//            down = helper(grid, i + 1, j, vis);
//            if (down != Integer.MAX_VALUE)
//                down += grid[i][j];
//            vis[i + 1][j] = false;
//        }
//
//        // left
//        if (check(grid, i, j - 1) && !vis[i][j - 1]) {
//            vis[i][j - 1] = true;
//            left = helper(grid, i, j - 1, vis);
//            if (left != Integer.MAX_VALUE)
//                left += grid[i][j];
//            vis[i][j - 1] = false;
//        }
//
//        // right
//        if (check(grid, i, j + 1) && !vis[i][j + 1]) {
//            vis[i][j + 1] = true;
//            right = helper(grid, i, j + 1, vis);
//            if (right != Integer.MAX_VALUE)
//                right += grid[i][j];
//            vis[i][j + 1] = false;
//        }
//
//        return Math.min(up, Math.min(down, Math.min(left, right)));
//    }
//
//    public boolean check(int[][] grid, int i, int j) {
//        return i >= 0 && j >= 0 && i < grid.length && j < grid[0].length;
//    }
}

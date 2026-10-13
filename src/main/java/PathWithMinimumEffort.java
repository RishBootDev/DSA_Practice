public class PathWithMinimumEffort {


    // this is the correct dfs approach to solve this question but due to constraints the optimal solution is using dijkstra algorithm
    public int minimumEffortPath(int[][] heights) {
        boolean vis[][] = new boolean[heights.length][heights[0].length];
        vis[0][0] = true;

        if(heights.length == 1 && heights[0].length == 1) return 0;
        return helper(heights, 0, 0, vis);
    }
    public boolean check(int [][] heights, int i, int j) {
        if(i < 0 || j < 0) return false;
        if(i >= heights.length || j >= heights[0].length) return false;
        return true;
    }

    public int helper(int [][] heights, int i, int j, boolean vis[][]) {
        if(i == heights.length - 1 && j == heights[0].length - 1) {
            return Integer.MIN_VALUE;
        }
        int up, down, left, right;
        up = down = left = right = Integer.MAX_VALUE;
        // up
        if(check(heights, i - 1, j) && !vis[i - 1][j]) {
            vis[i - 1][j] = true;
            int temp = helper(heights, i - 1, j, vis);
            if(temp != Integer.MAX_VALUE)
                up = Math.max(temp, Math.abs(heights[i][j] - heights[i - 1][j]));
            vis[i - 1][j] = false;
        }

        // down
        if(check(heights, i + 1, j) && !vis[i + 1][j]) {
            vis[i + 1][j] = true;
            int temp = helper(heights, i + 1, j, vis);
            if(temp != Integer.MAX_VALUE)
                down = Math.max(temp, Math.abs(heights[i][j] - heights[i + 1][j]));
            vis[i + 1][j] = false;
        }

        // left
        if(check(heights, i, j - 1) && !vis[i][j - 1]) {
            vis[i][j - 1] = true;
            int temp = helper(heights, i, j - 1, vis);
            if(temp != Integer.MAX_VALUE)
                left = Math.max(temp, Math.abs(heights[i][j] - heights[i][j - 1]));
            vis[i][j - 1] = false;
        }

        // right
        if(check(heights, i, j + 1) && !vis[i][j + 1]) {
            vis[i][j + 1] = true;
            int temp = helper(heights, i, j + 1, vis);
            if(temp != Integer.MAX_VALUE)
                right = Math.max(temp, Math.abs(heights[i][j] - heights[i][j+1]));
            vis[i][j + 1] = false;
        }
        return Math.min(up , Math.min(down , Math.min(left, right)));
    }
}

import java.util.LinkedList;
import java.util.Queue;

public class MaxAreaOfIslands {

    public int maxAreaOfIsland(int[][] grid) {

        return maxIslands(grid);
    }

    public int maxIslands(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        int max = 0;

        boolean vis[][] = new boolean[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1 && !vis[i][j]){
                    max = Math.max(bfs(grid, i, j, vis), max);

                }
            }
        }

        return max;
    }

    public int bfs(int [][] grid, int x, int y, boolean vis[][]) {

        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(x,y));
        vis[x][y] = true;

        int size = 1;

        while (!queue.isEmpty()) {

            Pair curr = queue.poll();

            int r = curr.x;
            int c = curr.y;

            if(r-1 >= 0 && !vis[r-1][c] && grid[r-1][c] == 1){
                queue.add(new Pair(r-1,c));
                vis[r-1][c] = true;
                size++;
            }

            if(c-1 >= 0 && !vis[r][c-1] && grid[r][c-1] == 1){
                queue.add(new Pair(r,c-1));
                vis[r][c-1] = true;
                size++;
            }

            if(r+1 < n && !vis[r+1][c] && grid[r+1][c] == 1){
                queue.add(new Pair(r+1,c));
                vis[r+1][c] = true;
                size++;
            }

            if(c+1 < m && !vis[r][c+1] && grid[r][c+1] == 1){
                queue.add(new Pair(r,c+1));
                vis[r][c+1] = true;
                size++;
            }
        }

        return size;
    }

    public static class Pair{
        int x,y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

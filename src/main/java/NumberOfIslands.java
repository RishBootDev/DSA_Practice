import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

    public int numIslands(char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        boolean vis[][] = new boolean[n][m];
        int count = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == '1' && !vis[i][j]){
                    bfs(grid, i, j, vis);
                    count++;
                }
            }
        }

        return count;
    }

    public void bfs(char [][] grid, int x, int y, boolean vis[][]) {

        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(x,y));
        vis[x][y] = true;

        while (!queue.isEmpty()) {

            Pair curr = queue.poll();

            int r = curr.x;
            int c = curr.y;

            if(r-1 >= 0 && !vis[r-1][c] && grid[r-1][c] == '1'){
                queue.add(new Pair(r-1,c));
                vis[r-1][c] = true;
            }

            if(c-1 >= 0 && !vis[r][c-1] && grid[r][c-1] == '1'){
                queue.add(new Pair(r,c-1));
                vis[r][c-1] = true;
            }

            if(r+1 < n && !vis[r+1][c] && grid[r+1][c] == '1'){
                queue.add(new Pair(r+1,c));
                vis[r+1][c] = true;
            }

            if(c+1 < m && !vis[r][c+1] && grid[r][c+1] == '1'){
                queue.add(new Pair(r,c+1));
                vis[r][c+1] = true;
            }
        }
    }

    public static class Pair{
        int x,y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
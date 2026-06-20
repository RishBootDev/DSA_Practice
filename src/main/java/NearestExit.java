import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NearestExit {

    public int nearestExit(char[][] maze, int[] entrance) {
          return bfs(maze, entrance[0], entrance[1]);
    }

    public int bfs(char [][]grid, int r, int c) {

        boolean vis[][] = new boolean[grid.length][grid[0].length];
        vis[r][c] = true;
        int m = grid.length;
        int n = grid[0].length;
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(List.of(r, c));
        int dr[] = {-1, 1, 0, 0};
        int ds[] = {0, 0, -1, 1};
        int count = 0;

        while (!queue.isEmpty()) {
            List<Integer> curr = queue.poll();
            int row = curr.getFirst();
            int col = curr.getLast();

            for (int k = 0; k < 4; k++) {

                int nr = row + dr[k];
                int nc = col + ds[k];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n && !vis[nr][nc]) {
                   if(grid[nr][nc] != '*') {
                       if(isBoundary(grid, nr, nc)) {
                           return count;
                       }
                       vis[nr][nc] = true;
                       queue.offer(List.of(nr, nc));
                   }
                }
            }
            count++;
        }
        return -1;
    }

    public boolean isBoundary(char grid[][], int i , int j) {
        if(i == 0) return true;
        if(j == 0) return true;
        if(i == grid.length - 1) return true;
        if(j == grid[0].length - 1) return true;
        return false;
    }
}

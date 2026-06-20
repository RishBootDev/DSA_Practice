import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RottingOranges {

    public int orangesRotting(int[][] grid) {
        return bfs(grid, 0, 0);
    }
    public int bfs(int [][] grid, int i, int j) {

        boolean vis[][] = new boolean[grid.length][grid[0].length];
        vis[i][j] = true;

        int m = grid.length;
        int n = grid[0].length;

        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(List.of(i, j));
        int dr[] = {-1, 1, 0, 0};
        int dc[] = {0, 0, -1, 1};
        int count = 0;

        while(!queue.isEmpty()) {
            List<Integer> curr = queue.poll();

            for (int k = 0; k < 4; k++) {
                int nr = curr.getFirst() + dr[k];
                int nc = curr.getLast() + dc[k];

                if (nr >= 0 && nr < m &&
                        nc >= 0 && nc < n &&
                        !vis[nr][nc] &&
                        grid[nr][nc] == 1) {

                    vis[nr][nc] = true;
                    queue.offer(List.of(nr, nc));
                }
            }
            count++;
        }
       return count;
    }
}

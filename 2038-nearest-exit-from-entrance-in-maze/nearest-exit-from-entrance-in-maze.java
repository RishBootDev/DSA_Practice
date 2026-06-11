class Solution {

    public int nearestExit(char[][] maze, int[] entrance) {
        return bfs(maze, entrance[0], entrance[1]);
    }

    public int bfs(char[][] grid, int r, int c) {

        boolean[][] vis = new boolean[grid.length][grid[0].length];

        int m = grid.length;
        int n = grid[0].length;

        Queue<List<Integer>> queue = new LinkedList<>();
        queue.offer(List.of(r, c));

        vis[r][c] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        int steps = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int s = 0; s < size; s++) {

                List<Integer> curr = queue.poll();

                int row = curr.get(0);
                int col = curr.get(1);

                for (int k = 0; k < 4; k++) {

                    int nr = row + dr[k];
                    int nc = col + dc[k];

                    if (nr >= 0 && nr < m &&
                        nc >= 0 && nc < n &&
                        !vis[nr][nc] &&
                        grid[nr][nc] == '.') {

                        if (isBoundary(grid, nr, nc)) {
                            return steps + 1;
                        }

                        vis[nr][nc] = true;
                        queue.offer(List.of(nr, nc));
                    }
                }
            }

            steps++;
        }

        return -1;
    }

    public boolean isBoundary(char[][] grid, int i, int j) {
        return i == 0 ||
               j == 0 ||
               i == grid.length - 1 ||
               j == grid[0].length - 1;
    }
}
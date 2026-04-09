public class CountGuardedCells {

        public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {

            int [][] grid = new int[m][n];
        /*
             1 -> guards
             2 -> walls
             0 -> cells unvisited
             3 -> cells visited
         */

            for(int [] guard : guards) {
                int i = guard[0];
                int j = guard[1];
                grid[i][j] = 1;
            }

            for(int [] wall : walls) {
                int i = wall[0];
                int j = wall[1];
                grid[i][j] = 2;
            }

            for (int[] guard : guards) {
                int i = guard[0];
                int j = guard[1];

                // move left
                int up = j - 1;
                while(up >= 0 && grid[i][up] != 2 && grid[i][up] != 1) {
                    grid[i][up] = 3;
                    up--;
                }

                // move up
                int left = i - 1;
                while(left >= 0 && grid[left][j] != 2 && grid[left][j] != 1) {
                    grid[left][j] = 3;
                    left--;
                }

                // move down
                int right = i + 1;
                while(right < grid.length && grid[right][j] != 2 && grid[right][j] != 1) {
                    grid[right][j] = 3;
                    right++;
                }

                // move right
                int down = j + 1;
                while(down < grid[i].length && grid[i][down] != 2 && grid[i][down] != 1) {
                    grid[i][down] = 3;
                    down++;
                }
            }

            int count = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if(grid[i][j] == 0) count++;
                }
            }

            return count;
        }

}

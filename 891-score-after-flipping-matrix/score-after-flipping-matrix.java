class Solution {
    public int matrixScore(int[][] grid) {
        
        for(int i = 0; i < grid.length; i++) {

            if(grid[i][0] == 1) continue;
            for(int j = 0; j < grid[0].length; j++) {

                if(grid[i][j] == 0) {
                    grid[i][j] = 1;
                }
                else grid[i][j] = 0;
            }
        }

        int n = grid.length;

        for(int i = 0; i< grid[0].length; i++) {
            int count = 0;
            for(int j = 0; j < grid.length; j++) {
                 if(grid[j][i] == 0) count++;
            }

            int ones = n - count;

            if(count > ones) {
                for(int j = 0; j < grid.length; j++) {
                   if(grid[j][i] == 0) {
                    grid[j][i] = 1;
                }
                else grid[j][i] = 0;
                }
            }
        }
        int ans = 0;

        for(int i = 0; i < grid.length; i++) {

            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < grid[0].length; j++) {
                sb.append(grid[i][j]);

            }
            ans += Integer.parseInt(sb.toString(), 2);
        }
        return ans;


    }
}
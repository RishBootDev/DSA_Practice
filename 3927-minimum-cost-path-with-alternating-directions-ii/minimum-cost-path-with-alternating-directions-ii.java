class Solution {
    
    Map<String, Long> map;
    public long minCost(int m, int n, int[][] waitCost) {
        map = new HashMap<>();
        int[][] grid = new int[m][n];
        return 1 + helper(grid, 0, 0, waitCost, true);
    }

    public long helper(int grid[][], int i, int j, int[][] wait, boolean flag) {

        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return 0;
        }

        String key = i + " " + j + " " + flag;
        if(map.containsKey(key)) return map.get(key);

        long right = Long.MAX_VALUE;
        long down = Long.MAX_VALUE;

        if (flag) {
            if (inside(grid, i, j + 1)) {
                right = helper(grid, i, j + 1, wait, false) + (long) (i + 1) * (j + 2);
            }
            if (inside(grid, i + 1, j)) {
                down = helper(grid, i + 1, j, wait, false) + (long) (i + 2) * (j + 1);
            }
        } else {
            right = helper(grid, i, j, wait, true) + wait[i][j];
            down = right;

        }
        long temp = Math.min(right, down);
        map.put(key, temp);
        return temp;
    }

    public boolean inside(int grid[][], int i, int j) {
        return i >= 0 && j >= 0
                && i < grid.length
                && j < grid[0].length;
    }
}
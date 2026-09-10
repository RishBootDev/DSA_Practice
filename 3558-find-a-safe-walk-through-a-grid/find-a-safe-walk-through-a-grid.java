class Solution {

    int memo[][];

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {

        int m = grid.size();
        int n = grid.get(0).size();

        memo = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(memo[i], -1);
        }

        if (grid.get(0).get(0) == 1) {
            health--;
        }

        return helper(grid, 0, 0, health);
    }

    public boolean helper(List<List<Integer>> grid, int i, int j, int health) {

        if (health <= 0) return false;

        if (i == grid.size() - 1 && j == grid.get(0).size() - 1)
            return true;

    
        if (memo[i][j] >= health)
            return false;

        memo[i][j] = health;

        boolean up = false, down = false, left = false, right = false;

        if (check(grid, i - 1, j)) {
            int h = health - grid.get(i - 1).get(j);
            up = helper(grid, i - 1, j, h);
        }

        if (check(grid, i + 1, j)) {
            int h = health - grid.get(i + 1).get(j);
            down = helper(grid, i + 1, j, h);
        }

        if (check(grid, i, j - 1)) {
            int h = health - grid.get(i).get(j - 1);
            left = helper(grid, i, j - 1, h);
        }

        if (check(grid, i, j + 1)) {
            int h = health - grid.get(i).get(j + 1);
            right = helper(grid, i, j + 1, h);
        }

        return up || down || left || right;
    }

    public boolean check(List<List<Integer>> grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.size() || j >= grid.get(0).size())
            return false;
        return true;
    }
}
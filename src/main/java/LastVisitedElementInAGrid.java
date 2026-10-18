public class LastVisitedElementInAGrid {

    public int[] lastVisitedCell(char[][] grid) {

        int x = 0, y = 0;
        boolean vis[][] = new boolean[grid.length][grid[0].length];

        int tempx = 0;
        int tempy = 0;
        while(check(vis, x, y)) {
            tempx = x;
            tempy = y;
            vis[x][y] = true;
            if(grid[x][y] == 'R') {
                y++;
            }else if (grid[x][y] == 'L') {
                y--;
            }else if (grid[x][y] == 'D') {
                x++;
            }else {
                x--;
            }
        }
        return new int[]{tempx,tempy};
    }
    public boolean check(boolean vis[][], int i, int j) {
        if(i < 0 || j < 0) return false;
        if(i >= vis.length || j >= vis[0].length) return false;
        return !vis[i][j];
    }
}

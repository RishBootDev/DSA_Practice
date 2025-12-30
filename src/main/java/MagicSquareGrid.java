import java.util.HashSet;
import java.util.Set;

public class MagicSquareGrid {

    public int numMagicSquaresInside(int[][] grid) {

        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (checkMagic(i,j,grid)) count++;
            }
        }
        return count;

    }
    public boolean checkMagic(int r, int c, int[][] grid) {

        // boundary check
        if (r + 2 >= grid.length || c + 2 >= grid[0].length)
            return false;

        // center must be 5
        if (grid[r+1][c+1] != 5)
            return false;

        Set<Integer> set = new HashSet<>();

        // check range 1–9 and uniqueness
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                int val = grid[i][j];
                if (val < 1 || val > 9 || set.contains(val))
                    return false;
                set.add(val);
            }
        }

        int sum = grid[r][c] + grid[r][c+1] + grid[r][c+2];

        // rows
        for (int i = r; i < r + 3; i++) {
            int rowSum = 0;
            for (int j = c; j < c + 3; j++)
                rowSum += grid[i][j];
            if (rowSum != sum) return false;
        }

        // columns
        for (int j = c; j < c + 3; j++) {
            int colSum = 0;
            for (int i = r; i < r + 3; i++)
                colSum += grid[i][j];
            if (colSum != sum) return false;
        }

        // diagonals
        if (grid[r][c] + grid[r+1][c+1] + grid[r+2][c+2] != sum)
            return false;

        if (grid[r][c+2] + grid[r+1][c+1] + grid[r+2][c] != sum)
            return false;

        return true;
    }

}


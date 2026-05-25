import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CyclicallyRotatingAGrid {

    public int[][] rotateGrid(int[][] grid, int k) {

        int rows = grid.length;
        int cols = grid[0].length;

        int layers = Math.min(rows, cols) / 2;

        for (int layer = 0; layer < layers; layer++) {

            List<Integer> list = new ArrayList<>();
            int top = layer;
            int bottom = rows - layer - 1;
            int left = layer;
            int right = cols - layer - 1;

            for (int j = left; j <= right; j++) {
                list.add(grid[top][j]);
            }

            for (int i = top + 1; i <= bottom; i++) {
                list.add(grid[i][right]);
            }

            for (int j = right - 1; j >= left; j--) {
                list.add(grid[bottom][j]);
            }

            for (int i = bottom - 1; i > top; i--) {
                list.add(grid[i][left]);
            }

            rotate(list, k);

            top = layer;
            bottom = rows - layer - 1;
            left = layer;
            right = cols - layer - 1;
            int idx = 0;

            for (int j = left; j <= right; j++) {
                grid[top][j] = list.get(idx);
                idx++;
            }

            for (int i = top + 1; i <= bottom; i++) {
                grid[i][right] = list.get(idx);
                idx ++;
            }

            for (int j = right - 1; j >= left; j--) {
                grid[bottom][j] = list.get(idx);
                idx ++;
            }

            for (int i = bottom - 1; i > top; i--) {
                grid[i][left] = list.get(idx);
                idx ++;
            }

        }

        return grid;

    }

    public void rotate(List<Integer> list, int k) {
        int n = list.size();
        if (n == 0) return;

        k = k % n;
        Collections.reverse(list);
        reverse(list, 0, k - 1);
        reverse(list, k, n - 1);
    }

    private void reverse(List<Integer> list, int left, int right) {

        while (left < right) {
            int temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);

            left++;
            right--;
        }
    }
}

/*
     00 01 02 03
     10 11 12 13
     20 21 22 23
     30 31 32 33


 */

class Solution {

    HashMap<String, Integer> set = new HashMap<>();
    int ans = Integer.MAX_VALUE;

    public int slidingPuzzle(int[][] board) {
        int i = 0;
        int j = 0;

        for(int x = 0; x < 2; x++) {
            for(int y = 0; y < 3; y++) {
                if(board[x][y] == 0) {
                    i = x;
                    j = y;
                }
            }
        }

        helper(board, i, j, 0);

        if(ans == Integer.MAX_VALUE) {
            return -1;
        }

        return ans;
    }

    public void helper(int[][] board, int i, int j, int steps) {

        if(Arrays.deepEquals(board, new int[][]{{1, 2, 3}, {4, 5, 0}})) {
            ans = Math.min(ans, steps);
            return;
        }

        if(steps >= ans) {
            return;
        }

        String curr = Arrays.deepToString(board);

        if(set.containsKey(curr) && set.get(curr) <= steps) {
            return;
        }

        set.put(curr, steps);

        if(i == 0) {

            if(j == 0) {

                swap(board, i, j, i, j + 1);
                helper(board, i, j + 1, steps + 1);
                swap(board, i, j, i, j + 1);

                swap(board, i, j, i + 1, j);
                helper(board, i + 1, j, steps + 1);
                swap(board, i, j, i + 1, j);

            } else if(j == 2) {

                swap(board, i, j, i, j - 1);
                helper(board, i, j - 1, steps + 1);
                swap(board, i, j, i, j - 1);

                swap(board, i, j, i + 1, j);
                helper(board, i + 1, j, steps + 1);
                swap(board, i, j, i + 1, j);

            } else {

                swap(board, i, j, i, j + 1);
                helper(board, i, j + 1, steps + 1);
                swap(board, i, j, i, j + 1);

                swap(board, i, j, i, j - 1);
                helper(board, i, j - 1, steps + 1);
                swap(board, i, j, i, j - 1);

                swap(board, i, j, i + 1, j);
                helper(board, i + 1, j, steps + 1);
                swap(board, i, j, i + 1, j);
            }

        } else {

            if(j == 0) {

                swap(board, i, j, i, j + 1);
                helper(board, i, j + 1, steps + 1);
                swap(board, i, j, i, j + 1);

                swap(board, i, j, i - 1, j);
                helper(board, i - 1, j, steps + 1);
                swap(board, i, j, i - 1, j);

            } else if(j == 2) {

                swap(board, i, j, i, j - 1);
                helper(board, i, j - 1, steps + 1);
                swap(board, i, j, i, j - 1);

                swap(board, i, j, i - 1, j);
                helper(board, i - 1, j, steps + 1);
                swap(board, i, j, i - 1, j);

            } else {

                swap(board, i, j, i, j + 1);
                helper(board, i, j + 1, steps + 1);
                swap(board, i, j, i, j + 1);

                swap(board, i, j, i, j - 1);
                helper(board, i, j - 1, steps + 1);
                swap(board, i, j, i, j - 1);

                swap(board, i, j, i - 1, j);
                helper(board, i - 1, j, steps + 1);
                swap(board, i, j, i - 1, j);
            }
        }
    }

    public void swap(int[][] board, int i1, int j1, int i2, int j2) {
        int temp = board[i1][j1];
        board[i1][j1] = board[i2][j2];
        board[i2][j2] = temp;
    }
}
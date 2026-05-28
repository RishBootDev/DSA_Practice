class MinimumComingHomeGrid {

    private int min = Integer.MAX_VALUE;


    // this approach is pure recursion based and mostly test cases were solved
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {

        boolean visited[][] = new boolean[rowCosts.length][colCosts.length];
        visited[startPos[0]][startPos[1]] = true;

        helper(startPos[0], startPos[1],
                homePos[0], homePos[1],
                rowCosts, colCosts,
                0, visited);

        return min;
    }

    public void helper(int i , int j, int x , int y,
                       int row[], int col[],
                       int cost, boolean visited[][]) {

        if(i == x && j == y) {
            min = Math.min(min, cost);
            return;
        }

        // move down
        if(i + 1 < row.length && !visited[i + 1][j]) {

            visited[i + 1][j] = true;
            helper(i + 1, j, x, y,
                    row, col,
                    cost + row[i + 1],
                    visited);
            visited[i + 1][j] = false;
        }

        // move up
        if(i - 1 >= 0 && !visited[i - 1][j]) {

            visited[i - 1][j] = true;
            helper(i - 1, j, x, y,
                    row, col,
                    cost + row[i - 1],
                    visited);
            visited[i - 1][j] = false;
        }

        // move left
        if(j - 1 >= 0 && !visited[i][j - 1]) {

            visited[i][j - 1] = true;
            helper(i, j - 1, x, y,
                    row, col,
                    cost + col[j - 1],
                    visited);
            visited[i][j - 1] = false;
        }

        // move right
        if(j + 1 < col.length && !visited[i][j + 1]) {

            visited[i][j + 1] = true;
            helper(i, j + 1, x, y,
                    row, col,
                    cost + col[j + 1],
                    visited);
            visited[i][j + 1] = false;
        }
    }

    // this is the memoized version of the above recursion of this problem and it solved 80 percent of the test cases
    static class OptimizedSolutionInDp{

            Integer dp[][];

            public int minCost(int[] startPos, int[] homePos,
                               int[] rowCosts, int[] colCosts) {

                dp = new Integer[rowCosts.length][colCosts.length];

                return helper(startPos[0], startPos[1],
                        homePos[0], homePos[1],
                        rowCosts, colCosts);
            }

            public int helper(int i , int j, int x , int y,
                              int row[], int col[]) {

                if(i == x && j == y) {
                    return 0;
                }

                if(dp[i][j] != null) {
                    return dp[i][j];
                }

                int min = Integer.MAX_VALUE;

                // move down
                if(i < x) {
                    min = Math.min(min,
                            row[i + 1] +
                                    helper(i + 1, j, x, y, row, col));
                }

                // move up
                if(i > x) {
                    min = Math.min(min,
                            row[i - 1] +
                                    helper(i - 1, j, x, y, row, col));
                }

                // move right
                if(j < y) {
                    min = Math.min(min,
                            col[j + 1] +
                                    helper(i, j + 1, x, y, row, col));
                }

                // move left
                if(j > y) {
                    min = Math.min(min,
                            col[j - 1] +
                                    helper(i, j - 1, x, y, row, col));
                }

                return dp[i][j] = min;
            }
        }


        // this is the greedy solution of the above code and it worked passed all the test cases.For this question the dp was overkill
        static class GreedySolution{

            public int minCost(int[] startPos, int[] homePos,
                               int[] rowCosts, int[] colCosts) {

               int ans = 0;
               int start = startPos[1];
               int end = homePos[1];
               while(start != end) {
                   if(start > end ) start --;
                   else start ++;
                   ans += colCosts[start];
               }

               start = startPos[0];
               end = homePos[0];

               while(start != end) {
                   if(start > end) start--;
                   else start ++;

                   ans += rowCosts[start];
               }

               return ans;
            }

        }

}
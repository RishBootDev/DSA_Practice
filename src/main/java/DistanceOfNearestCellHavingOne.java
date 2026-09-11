import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// This is the accepted approach but the time complexity is not good
// the another approach to solve this question is the Multi source BFS
public class DistanceOfNearestCellHavingOne {

    public ArrayList<ArrayList<Integer>> nearest(int[][] grid) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for(int i = 0; i < grid.length; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for(int j = 0; j < grid[0].length; j++) {
                list.add(bfs(grid, i, j));
            }
            ans.add(list);
        }

        return ans;
    }

    public int bfs(int grid[][], int i, int j) {
        Queue<Pair> queue = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        queue.offer(new Pair(i, j));
        visited[i][j] = true;

        int count = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();

            while(size-- > 0) {
                Pair pair = queue.poll();

                if(grid[pair.i][pair.j] == 1) return count;

                if(check(grid, pair.i - 1, pair.j) && !visited[pair.i - 1][pair.j]) {
                    visited[pair.i - 1][pair.j] = true;
                    queue.offer(new Pair(pair.i - 1, pair.j));
                }

                if(check(grid, pair.i + 1, pair.j) && !visited[pair.i + 1][pair.j]) {
                    visited[pair.i + 1][pair.j] = true;
                    queue.offer(new Pair(pair.i + 1, pair.j));
                }

                if(check(grid, pair.i, pair.j + 1) && !visited[pair.i][pair.j + 1]) {
                    visited[pair.i][pair.j + 1] = true;
                    queue.offer(new Pair(pair.i, pair.j + 1));
                }

                if(check(grid, pair.i, pair.j - 1) && !visited[pair.i][pair.j - 1]) {
                    visited[pair.i][pair.j - 1] = true;
                    queue.offer(new Pair(pair.i, pair.j - 1));
                }
            }

            count++;
        }

        return -1;
    }

    static class Pair {
        int i;
        int j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public boolean check(int grid[][], int i, int j) {
        if(i < 0 || j < 0) return false;
        if(i == grid.length || j == grid[0].length) return false;
        return true;
    }
}
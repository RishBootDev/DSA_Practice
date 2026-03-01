import java.util.*;

public class CelebrityProblem {


    // I used the graph to solve this problem but the optimal solution expects the use of stack
    public int celebrity(int mat[][]) {

        int n = mat.length;

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[n];

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (i != j && mat[i][j] == 1) {
                    graph.get(i).add(j);
                    indegree[j]++;
                }
            }
        }

        for (int i = 0; i < n; i++) {

            if (graph.get(i).isEmpty() && indegree[i] == n - 1) {
                return i;
            }
        }

        return -1;
    }
}
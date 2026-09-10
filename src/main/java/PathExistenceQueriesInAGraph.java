import java.util.ArrayList;
import java.util.List;

public class PathExistenceQueriesInAGraph {

    // this is the working approach ans solved around 530 / 560 test cases.
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if(Math.abs(nums[i] - nums[j])<= maxDiff) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }
        boolean ans [] = new boolean[n];
        int i = 0;
        for(int[] query : queries) {
            int start = query[0];
            int end = query[1];
            boolean vis[] = new boolean[n];
            ans[i] = dfs(graph, start, vis, end);
        }
        return ans;
    }

    public boolean dfs(List<List<Integer>> graph, int start, boolean []vis, int target) {
        if(start == target) return true;
        vis[start] = true;
        boolean check = false;

        for(int node : graph.get(start)) {
            if(!vis[node] && dfs(graph, node, vis, target)) return true;
        }
        return check;
    }
}

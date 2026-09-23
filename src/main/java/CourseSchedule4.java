import java.util.ArrayList;
import java.util.List;

public class CourseSchedule4 {

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for(int [] t : prerequisites) {
            graph.get(t[0]).add(t[1]);
        }
        List<Boolean> ans = new ArrayList<>();
        for(int q[] : queries) {
            ans.add(dfs(graph, q[0], q[1], new boolean[numCourses]));
        }
        return ans;
    }

    public Boolean dfs(List<List<Integer>> graph, int start, int end, boolean vis[]) {
        if(start == end) return true;

        vis[start] = true;

        for(int node : graph.get(start)) {
            if(!vis[node] && dfs(graph, node, end, vis)) return true;
        }
        return false;
    }
}

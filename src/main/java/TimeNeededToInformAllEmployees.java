import java.util.ArrayList;
import java.util.List;

public class TimeNeededToInformAllEmployees {

    private int max = Integer.MIN_VALUE;
    private int informTime[];

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        this.informTime = informTime;
         List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
           graph.add(new ArrayList<>());
        }

        for (int i = 0; i < manager.length; i++) {
            int emp = i;
            int man = manager[i];
            if(man == -1) continue;
            graph.get(emp).add(man);
            graph.get(man).add(emp);
            graph.get(headID).add(i);
        }

        System.out.println(graph);
        boolean vis[] = new boolean[n];
        dfs(graph, headID, vis, informTime[headID]);
        return max;
    }
    public void dfs(List<List<Integer>> graph, int start, boolean vis[], int time) {
        vis[start] = true;
        System.out.println(start);
        max = Math.max(max, time);

        for(int n : graph.get(start)) {
            if(!vis[n]) {
                dfs(graph, n, vis, informTime[n]);
            }
        }
    }
}

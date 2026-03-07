import java.util.ArrayList;

public class CompleteComponentsGraph {

    int nodes;
    int edges;

    public int countCompleteComponents(int n, int[][] edgesArr) {

        boolean[] visited = new boolean[n];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i=0;i<n;i++)
            graph.add(new ArrayList<>());

        for(int[] e : edgesArr){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        int count = 0;
        for(int i=0;i<n;i++){

            if(!visited[i]){
                nodes = 0;
                edges = 0;
                dfs(i, visited, graph);
                edges /= 2;
                if(edges == nodes*(nodes-1)/2)
                    count++;
            }
        }

        return count;
    }

    public void dfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>> graph){

        visited[node] = true;
        nodes++;

        edges += graph.get(node).size();

        for(int neigh : graph.get(node)){
            if(!visited[neigh]){
                dfs(neigh, visited, graph);
            }
        }
    }
}

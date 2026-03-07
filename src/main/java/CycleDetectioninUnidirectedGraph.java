import java.util.ArrayList;

public class CycleDetectioninUnidirectedGraph {


        public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {

            boolean[] visited = new boolean[V];

            for(int i = 0; i < V; i++){
                if(!visited[i]){
                    if(dfs(i, -1, visited, adj))
                        return true;
                }
            }

            return false;
        }

        public boolean dfs(int node, int parent, boolean[] visited, ArrayList<ArrayList<Integer>> adj){

            visited[node] = true;

            for(int neighbor : adj.get(node)){

                if(!visited[neighbor]){
                    if(dfs(neighbor, node, visited, adj))
                        return true;
                }
                else if(neighbor != parent){
                    return true;
                }
            }

            return false;
        }

}

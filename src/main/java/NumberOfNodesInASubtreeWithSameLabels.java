import java.util.ArrayList;
import java.util.List;

public class NumberOfNodesInASubtreeWithSameLabels {

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }
        for(int edge[] : edges) {
            tree.get(edge[0]).add(edge[1]);
        }

        int res[] = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = dfs(tree, i, labels, labels.charAt(i), new boolean[n]);
        }
        return res;
    }

    public int dfs(List<List<Integer>> tree, int start,String labels, char ch, boolean vis[]) {
        if(labels.charAt(start) == ch) return 1;

        vis[start] = true;
        int count = 0;
        for(int node : tree.get(start)) {
            if(!vis[node]) {
                count += 1 + dfs(tree, node, labels, ch, vis);
            }
        }
        return count;
    }
}

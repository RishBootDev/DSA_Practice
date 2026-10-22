import java.util.ArrayList;
import java.util.List;


// this is the correct approach but gave me tle
public class LongestPathWithDifferentAdjacentCharacters {

    String str;
    public int longestPath(int[] parent, String s) {
        str = s;
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < parent.length; i++) {
            tree.add(new ArrayList<>());
        }
        for (int i = 1; i < parent.length; i++) {
            tree.get(parent[i]).add(i);
            tree.get(i).add(parent[i]);
        }
        int max = 1;
        for (int i = 0; i < parent.length; i++) {
            int temp = helper(tree, i, new boolean[parent.length]);
            max = Math.max(temp, max);
        }
        return max;
    }
    public int helper(List<List<Integer>> tree, int start, boolean vis[]) {

        vis[start] = true;
        int max = 1;
        for(int node : tree.get(start)) {
            if(str.charAt(node) != str.charAt(start) && !vis[node]) {
                int temp = helper(tree, node, vis) + 1;
                max = Math.max(max, temp);
                //  System.out.println(temp);
            }
        }
        return max;
    }
}

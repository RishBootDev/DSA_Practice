/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        Map<Integer, List<Integer>> graph = new HashMap<>();

        buildGraph(root, graph);

        return bfs(graph, target.val, k);
    }

    public List<Integer> bfs(Map<Integer, List<Integer>> graph, int start, int k) {

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> vis = new HashSet<>();

        queue.offer(start);
        vis.add(start);

        while (!queue.isEmpty() && k > 0) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int node = queue.poll();

                for (int nei : graph.getOrDefault(node, new ArrayList<>())) {
                    if (!vis.contains(nei)) {
                        vis.add(nei);
                        queue.offer(nei);
                    }
                }
            }
            k--;
        }

        return new ArrayList<>(queue);
    }

    public void buildGraph(TreeNode root, Map<Integer, List<Integer>> graph) {

        if (root == null) return;

        graph.putIfAbsent(root.val, new ArrayList<>());

        if (root.left != null) {
            graph.putIfAbsent(root.left.val, new ArrayList<>());

            graph.get(root.val).add(root.left.val);
            graph.get(root.left.val).add(root.val);
        }

        if (root.right != null) {
            graph.putIfAbsent(root.right.val, new ArrayList<>());

            graph.get(root.val).add(root.right.val);
            graph.get(root.right.val).add(root.val);
        }

        buildGraph(root.left, graph);
        buildGraph(root.right, graph);
    }
}
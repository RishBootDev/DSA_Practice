import java.util.*;

public class BurningTree {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
    Map<Integer, List<Integer>> graph;

    public int minTime(Node root, int target) {
        graph = new HashMap<>();
        buildGraph(root);
        return bfs(target);
    }

    public void buildGraph(Node root) {
        if (root == null) return;

        graph.putIfAbsent(root.data, new ArrayList<>());

        if (root.left != null) {
            graph.putIfAbsent(root.left.data, new ArrayList<>());

            graph.get(root.data).add(root.left.data);
            graph.get(root.left.data).add(root.data);
        }

        if (root.right != null) {
            graph.putIfAbsent(root.right.data, new ArrayList<>());

            graph.get(root.data).add(root.right.data);
            graph.get(root.right.data).add(root.data);
        }

        buildGraph(root.left);
        buildGraph(root.right);
    }

    public int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> vis = new HashSet<>();

        queue.offer(start);
        vis.add(start);

        int time = -1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            time++;

            for (int i = 0; i < size; i++) {
                int curr = queue.poll();

                for (int nei : graph.get(curr)) {
                    if (!vis.contains(nei)) {
                        vis.add(nei);
                        queue.offer(nei);
                    }
                }
            }
        }

        return time;
    }
}

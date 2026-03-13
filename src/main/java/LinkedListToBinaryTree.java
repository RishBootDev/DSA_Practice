import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LinkedListToBinaryTree {

    static class NodeLL {
        int data;
        NodeLL next;

        NodeLL(int x) {
            data = x;
            next = null;
        }
    }

    static class Node {
        int data;
        Node left, right;

        Node(int x) {
            data = x;
            left = right = null;
        }
    }

    public Node linkedListToBinaryTree(NodeLL head) {

        Queue<Node> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        NodeLL temp = head;
        while (temp != null) {
            list.add(temp.data);
            temp = temp.next;
        }

        if (list.size() == 0) return null;

        int idx = 0;
        Node root = new Node(list.get(idx));
        queue.add(root);

        while (!queue.isEmpty() && idx < list.size() - 1) {

            Node parent = queue.poll();

            idx++;
            Node left = new Node(list.get(idx));
            parent.left = left;
            queue.add(left);

            if (idx >= list.size() - 1) break;

            idx++;
            Node right = new Node(list.get(idx));
            parent.right = right;
            queue.add(right);
        }

        return root;
    }
}
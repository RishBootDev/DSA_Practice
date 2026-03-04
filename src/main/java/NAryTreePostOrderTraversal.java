import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class NAryTreePostOrderTraversal {


    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;

        Stack<Node> st = new Stack<>();
        st.push(root);

        while(!st.isEmpty()) {
            Node top = st.pop();
            list.add(top.val);

            for(Node child : top.children) {
                st.push(child);
            }
        }

        Collections.reverse(list);
        return list;
    }
}

import java.util.Scanner;

// what we have to do is take the lca of the two nodes node A, node B then the answer LCA of these two nodes will be the third node and now take out the LCA with the third node
public class TripletLCA {

    static class Node {
        int val;
        Node left, right;
        Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-- > 0) {
            int N = sc.nextInt();
            Node[] nodes = new Node[N + 1];
            Node root = null;
            for (int i = 0; i < N; i++) {
                int parentVal = sc.nextInt();
                int childVal = sc.nextInt();
                if(nodes[childVal] == null) {
                    nodes[childVal] = new Node(childVal);
                }
                if(parentVal == -1) {
                    root = nodes[childVal];
                } else {
                    if(nodes[parentVal] == null) {
                        nodes[parentVal] = new Node(parentVal);
                    }
                    if(nodes[parentVal].left == null) {
                        nodes[parentVal].left = nodes[childVal];
                    } else {
                        nodes[parentVal].right = nodes[childVal];
                    }
                }
            }
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            Node lcaAB = lca(root, a, b);
            Node lcaABC = lca(root, lcaAB.val, c);

            System.out.println(lcaABC.val);
        }
        sc.close();
    }

    private static Node lca(Node root, int n1, int n2) {
        if(root == null) return null;
        if(root.val == n1 || root.val == n2) return root;

        Node left = lca(root.left, n1, n2);
        Node right = lca(root.right, n1, n2);

        if(left != null && right != null) return root;

        return (left != null) ? left : right;
    }
}

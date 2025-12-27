import java.util.PriorityQueue;

public class FlatteningLinkedList {

    public static void main(String[] args) {
        test2();
    }

    public static void test1() {

        Node head = new Node(5);
        Node n10 = new Node(10);
        Node n19 = new Node(19);
        Node n28 = new Node(28);

        head.next = n10;
        n10.next = n19;
        n19.next = n28;

        head.bottom = new Node(7);
        head.bottom.bottom = new Node(8);

        n10.bottom = new Node(20);

        n19.bottom = new Node(22);

        n28.bottom = new Node(40);
        n28.bottom.bottom = new Node(45);


        Node flatHead = flatten(head);

        Node curr = flatHead;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }

    public static void test2(){

        Node head = new Node(5);
        Node n10 = new Node(10);
        Node n19 = new Node(19);
        Node n28 = new Node(28);

        head.next = n10;
        n10.next = n19;
        n19.next = n28;

        head.bottom = new Node(7);
        head.bottom.bottom = new Node(8);
        head.bottom.bottom.bottom = new Node(30);

        n19.bottom = new Node(22);
        n19.bottom.bottom = new Node(50);

        Solution sol = new Solution();
        Node flatHead = flatten(head);

        Node curr = flatHead;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }

    public static Node flatten(Node root) {

        if (root == null) return root;
        Node temp = root;

        while (temp != null) {

            Node bottom = temp.bottom;
            Node next = temp.next;

            while (bottom != null) {
                temp.next = bottom;
                temp = temp.next;
                bottom = bottom.bottom;
            }

            temp.next = next;
            temp = temp.next;
        }

        PriorityQueue<Node> pq=new PriorityQueue<>((a, b)->a.data-b.data);

        temp=root;

        while(temp!=null) {
            pq.add(temp);
            temp=temp.next;
        }

        Node root2 = pq.poll();
        Node ans = root2;
        ans.next = null;
        ans.bottom = null;

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            curr.next = null;
            curr.bottom = null;

            ans.next = curr;
            ans = ans.next;
        }

        return root2;
    }

        static class Node {
            int data;
            Node next;
            Node bottom;

            Node(int x) {
                data = x;
                next = null;
                bottom = null;
            }

            @Override
            public String toString() {
                return "Node{" +
                        "data=" + data +
                        '}';
            }
        }
}

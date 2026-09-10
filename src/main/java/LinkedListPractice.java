public class LinkedListPractice {

    static class Node{
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(100);
        head = addFirst(head, 200);
        printList(head);
    }

    public static Node addFirst(Node head, int data) {
        if(head == null) {
            Node node = new Node(data);
            head = node;
        }else {
            Node node = new Node(data);
            node.next = head;
            head = node;
        }
        return head;
    }

    public static void printList(Node head) {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println();
    }
}

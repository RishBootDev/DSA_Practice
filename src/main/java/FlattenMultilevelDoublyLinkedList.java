public class FlattenMultilevelDoublyLinkedList {

    public Node flatten(Node head) {

         helper(head);
         return head;

    }

    public Node helper(Node head) {

        if (head == null) return null;

        Node curr = head;
        Node tail = head;

        if (head.child != null) {

            Node child = head.child;
            Node childTail = helper(child);
            Node next = head.next;

            head.next = child;
            child.prev = head;
            head.child = null;

            if (next != null) {
                childTail.next = next;
                next.prev = childTail;
                tail = helper(next);
            } else {
                tail = childTail;
            }

        } else if (head.next != null) {
            tail = helper(head.next);
        }

        return tail;
    }


    static class Node{

        int val;
        Node prev;
        Node next;
        Node child;
    }
}

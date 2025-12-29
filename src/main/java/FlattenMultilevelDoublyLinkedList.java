public class FlattenMultilevelDoublyLinkedList {

    public Node flatten(Node head) {

         helper(head);
         return head;

    }

    public Node helper(Node head){

        if(head == null) return null;
        if (head.next == null) return head;

        Node next = head.next;
        Node tail = head;

        if (head.child != null) {
            Node child = head.child;
            Node childTail = helper(child);

            head.next = child;
            child.prev = head;
            head.child = null;

            if (next != null) {
                childTail.next = next;
                next.prev = childTail;
            }

            tail = childTail;
        }
        tail = helper(next);

        return tail;
    }


    static class Node{

        int val;
        Node prev;
        Node next;
        Node child;
    }
}

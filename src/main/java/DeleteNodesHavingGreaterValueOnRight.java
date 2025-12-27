public class DeleteNodesHavingGreaterValueOnRight {

    public Node compute(Node head) {

        Node head2 = reverseList(head);
        int max = Integer.MIN_VALUE;

        Node temp = head2;
        Node prev = null;

        while (temp != null) {
            if (temp.data < max) {
                prev.next = temp.next;
            } else {
                max = temp.data;
                prev = temp;
            }
            temp = temp.next;
        }
        return reverseList(head2);
    }

    public Node reverseList(Node head){

        if(head==null || head.next==null) return head;

        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }
}

public class SwapNodesK {

    public ListNode swapNodes(ListNode head, int k) {

        if (head == null || head.next == null) return head;

        ListNode first = firstKNode(head, k);
        ListNode last = lastKNode(head, k);

        int temp = first.val;
        first.val = last.val;
        last.val = temp;

        return head;
    }

    public ListNode firstKNode(ListNode head, int k) {

        k--;
        ListNode temp = head;

        while(k-->0 && temp != null) {
            temp = temp.next;
        }

        return temp;
    }

    public int getSize(ListNode head) {

        ListNode temp = head;
        int count =0;

        while(temp!=null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public ListNode lastKNode(ListNode head, int k) {

        int size = getSize(head);

        int target = size - k;

        ListNode temp = head;

        while(temp != null && target-->0) {
            temp = temp.next;
        }

        return temp;

    }

    static class ListNode {
        int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}

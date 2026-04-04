public class InsertionSortList {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


        public ListNode insertionSortList(ListNode head) {
            if (head == null || head.next == null) return head;

            ListNode sorted = null;
            ListNode temp = head;

            while (temp != null) {
                ListNode curr = temp;
                temp = temp.next;
                curr.next = null;
                sorted = insert(sorted, curr);
            }

            return sorted;
        }

        public ListNode insert(ListNode head, ListNode x) {
            if (head == null || x.val < head.val) {
                x.next = head;
                return x;
            }

            ListNode temp = head;

            while (temp.next != null && temp.next.val <= x.val) {
                temp = temp.next;
            }

            x.next = temp.next;
            temp.next = x;

            return head;
        }

}

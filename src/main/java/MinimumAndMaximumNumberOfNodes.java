public class MinimumAndMaximumNumberOfNodes {

    static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public int[] nodesBetweenCriticalPoints(ListNode head) {

        if(head == null) return new int[0];
        if(head.next == null) return new int[]{0, 0};
        int count1 = 0;
        int count2 = 0;
        ListNode temp = head;
        ListNode aage = head.next;
        ListNode peeche = null;

        while(temp != null) {
            if(peeche != null && aage != null) {
                if(peeche.val < temp.val && aage.val > temp.val) count1++;
                else if(peeche.val > temp.val && aage.val < temp.val) count2++;
            }
            peeche = temp;
            temp = temp.next;
            aage = temp.next;
        }
        return new int[]{count1, count2};
    }
}

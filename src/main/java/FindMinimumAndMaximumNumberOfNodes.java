public class FindMinimumAndMaximumNumberOfNodes {

    public int[] nodesBetweenCriticalPoints(ListNode head) {

        int first = -1, last = -1;
        int minDist = Integer.MAX_VALUE;

        ListNode prev = head;
        ListNode curr = head.next;
        ListNode next = head.next.next;

        int index = 1;

        while (next != null) {

            boolean isCritical =
                    (curr.val > prev.val && curr.val > next.val) ||
                            (curr.val < prev.val && curr.val < next.val);

            if (isCritical) {
                if (first == -1) {
                    first = index;
                } else {
                    minDist = Math.min(minDist, index - last);
                }
                last = index;
            }

            prev = curr;
            curr = next;
            next = next.next;
            index++;
        }

        if (first == -1 || first == last) {
            return new int[]{-1, -1};
        }

        return new int[]{minDist, last - first};
    }



    static class ListNode{
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val){
            this.val = val;
        }
        ListNode(int val,ListNode next){
            this.val = val;
            this.next = next;
        }
    }
}

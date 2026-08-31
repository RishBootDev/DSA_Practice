class Solution {
    
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        ListNode previous = head;
        ListNode current = head.next;

        int first = -1;
        int prev = -1;
        int min = Integer.MAX_VALUE;
        int index = 1;

        while(current.next != null) {

            if((current.val > previous.val && current.val > current.next.val) ||
               (current.val < previous.val && current.val < current.next.val)) {

                if(first == -1) {
                    first = index;
                } else {
                    min = Math.min(min, index - prev);
                }

                prev = index;
            }
            previous = current;
            current = current.next;
            index++;
        }

        if(first == -1 || first == prev) {
            return new int[]{-1, -1};
        }

        return new int[]{min, prev - first};
    }
}
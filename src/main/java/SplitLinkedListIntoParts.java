public class SplitLinkedListIntoParts {

    public static void main(String[] args) {

    }
    public ListNode[] splitListToParts(ListNode head, int k) {

        if (head == null) return new ListNode[0];

        ListNode[] parts = new ListNode[k];
        int size = getSize(head);

        ListNode temp = head;
        ListNode prev = null;

        int n = size / k, r = size % k;

        // Loop through each part.
        for (int i = 0; temp != null && i < k; i++, r--) {
            // Store the current node as the start of the current part.
            parts[i] = temp;

            // Traverse n + 1 nodes if there are remaining extra nodes (r > 0).
            // Otherwise, traverse only n nodes.
            for (int j = 0; j < n + (r > 0 ? 1 : 0); j++) {
                prev = temp;
                temp = temp.next;
            }

            // Disconnect the current part from the rest of the list by setting prev.next to null.
            if (prev != null) {
                prev.next = null;
            }
        }
        // Return the array of k parts.
        return parts;
    }

    public int getSize(ListNode head) {
        int count = 0;
        ListNode temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        return count;
    }

    static class ListNode{
        int val;
        ListNode next;

        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
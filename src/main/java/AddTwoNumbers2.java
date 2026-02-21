import java.util.ArrayList;

public class AddTwoNumbers2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        l1 = reverseList(l1);
        l2 = reverseList(l2);

        ArrayList<Integer> arr = new ArrayList<>();
        ListNode temp = l1;
        ListNode bemp = l2;

        int carry = 0;
        while (temp != null || bemp != null) {
            int val1 = (temp != null) ? temp.val : 0;
            int val2 = (bemp != null) ? bemp.val : 0;
            int sum = val1 + val2 + carry;

            arr.add(unitDigit(sum));
            carry = carry(sum);

            if (temp != null) temp = temp.next;
            if (bemp != null) bemp = bemp.next;
        }

        if (carry != 0) arr.add(carry);

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        for (int digit : arr) {
            curr.next = new ListNode(digit);
            curr = curr.next;
        }

        return reverseList(dummy.next);
    }

    public int carry(int data) {
        String temp = String.valueOf(data);
        if (temp.length() == 1) return 0;
        return temp.charAt(0) - '0';
    }

    public int unitDigit(int data) {
        String temp = String.valueOf(data);
        return temp.charAt(temp.length() - 1) - '0';
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }

        return prev;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
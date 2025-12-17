public class MinimumPairRemovalToSort {
    public int minimumPairRemoval(int[] nums) {

        Node prev = null;
        Node head = new Node(nums[0]);
        Node temp = head;

        for (int i = 1; i < nums.length; i++) {
            Node newNode = new Node(nums[i]);
            temp.next = newNode;
            newNode.prev = temp;
            temp = temp.next;
        }

        int count = 0;

        while (!isSorted(head)) {
            temp = head;
            Node rem = null;
            int min = Integer.MAX_VALUE;

            printList(head);

            while (temp.next != null) {

                int a = temp.data;
                int b = temp.next.data;

                if (a + b < min) {
                    rem = temp;
                    min = a + b;
                }
                temp = temp.next;
            }

            Node first = rem;
            Node second = rem.next;

            Node newNode = new Node(min);


            if (first.prev != null) {
                first.prev.next = newNode;
                newNode.prev = first.prev;
            } else {
                head = newNode;
            }


            if (second.next != null) {
                second.next.prev = newNode;
                newNode.next = second.next;
            } else {
                newNode.next = null;
            }

            System.out.println(" we chosed the " + first.data + " and the second one is " + second.data);

            count++;
        }
        return count;

    }

    public boolean isSorted(Node head) {

        if (head == null || head.next == null)
            return true;

        while (head.next != null) {
            int a = head.data;
            int b = head.next.data;

            if (a > b)
                return false;
            head = head.next;
        }

        return true;
    }

    public void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) {
                System.out.print(" -> ");
            }
            temp = temp.next;
        }
        System.out.println();
    }

    static class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
        }
    }
}
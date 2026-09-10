public class StackUsingLinkedList {

    static class Node{
        int data;
        Node next;
        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
        public Node(int data) {
            this.data = data;
        }
    }

    Node top;

    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }
    public void push(Node newNode) {
        newNode.next = top;
        top = newNode;
    }
    public int pop() {
        if(this.top == null) return Integer.MIN_VALUE;
        int data = top.data;
        top = top.next;
        return data;
    }
    public int peek() {
        return this.top != null ?this.top.data : Integer.MIN_VALUE;
    }

    public boolean isEmpty() {
        return top != null;
    }

    public void print() {
        Node temp = top;
        while(temp != null) {
            System.out.print(temp.data + " , ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StackUsingLinkedList stack = new StackUsingLinkedList();
        stack.top = new Node(10);
        Node newNode = new Node(60);

        stack.print();
        stack.push(20);
        stack.push(30);
        stack.print();
        stack.pop();
        stack.push(newNode);
        stack.print();
    }
}

public class QueueUsingArray {

    private int arr[];
    private int size;
    int front;
    int rear;

    public QueueUsingArray(int arr[], int size) {
        this.arr = new int[size];
        this.size = size;
        this.front = -1;
        this.rear = -1;
    }
    // enqueue
    public void enqueue(int data) {
        if (rear == size - 1) {
            System.out.println("Queue is full");
            return;
        }
        arr[++rear] = data;
    }

    public int dequeue() {
        if (front > rear) {
            System.out.println("Queue is empty");
            return -1;
        }
        return arr[front++];
    }

    public int peek() {
        if (front > rear)
            return -1;

        return arr[front];
    }
}






import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class ProductOfNumbers {

    ArrayDeque<Integer> queue;
    public ProductOfNumbers() {
         this.queue = new ArrayDeque<>();
    }

    public void add(int num) {
        this.queue.offerLast(num);
    }

    public int getProduct(int k) {
        int prod = 1;
        while(k-- > 0) {
            prod *= queue.peekLast();
        }
        return prod;
    }
}

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class RunningMedianFromArray {

    public static List<Double> runningMedian(List<Integer> a) {

        List<Double> ans = new ArrayList<>();

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : a) {

            maxHeap.add(num);
            minHeap.add(maxHeap.poll());

            if (minHeap.size() > maxHeap.size()) {
                maxHeap.add(minHeap.poll());
            }

            if (maxHeap.size() == minHeap.size()) {
                ans.add((maxHeap.peek() + minHeap.peek()) / 2.0);
            } else {
                ans.add((double) maxHeap.peek());
            }
        }

        return ans;
    }

    public static void test() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

    }
}

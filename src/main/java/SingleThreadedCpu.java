import java.util.Arrays;
import java.util.PriorityQueue;

public class SingleThreadedCpu {

    public int[] getOrder(int[][] tasks) {

        int n = tasks.length;
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            arr[i][0] = tasks[i][0];
            arr[i][1] = tasks[i][1];
            arr[i][2] = i;
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<Pair> available = new PriorityQueue<>(
                (p1, p2) -> {
                    if (p1.processingTime != p2.processingTime)
                        return Integer.compare(p1.processingTime, p2.processingTime);
                    return Integer.compare(p1.index, p2.index);
                }
        );

        int[] ans = new int[n];
        int k = 0;

        int time = 0;
        int i = 0;

        while (i < n || !available.isEmpty()) {

            if (available.isEmpty() && time < arr[i][0]) {
                time = arr[i][0];
            }

            while (i < n && arr[i][0] <= time) {
                available.add(new Pair(arr[i][0], arr[i][1], arr[i][2]));
                i++;
            }

            Pair currentPair = available.poll();
            ans[k++] = currentPair.index;
            time += currentPair.processingTime;
        }

        return ans;
    }

    static class Pair {
        int start;
        int processingTime;
        int index;

        public Pair(int start, int processingTime, int index) {
            this.start = start;
            this.processingTime = processingTime;
            this.index = index;
        }
    }
}
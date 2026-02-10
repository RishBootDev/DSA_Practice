import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class FindScoreOfArrayAfterAllElements {


    // this is the bruteforce approach of this problem and hardly meets the constraints
    public long findScore1(int[] nums) {

        List<Pair> pairs = new ArrayList<>();
        long score = 0;

        for (int num : nums) {
            pairs.add(new Pair(num));
        }

        while (isAvailable(pairs)) {

            int minIndex = -1;
            int min = Integer.MAX_VALUE;

            for (int i = 0; i < pairs.size(); i++) {
                Pair pair = pairs.get(i);

                if (!pair.isMarked && pair.data < min) {
                    min = pair.data;
                    minIndex = i;
                }
            }

            score += min;
            markPairs(pairs, minIndex);
        }

        return score;
    }

    private void markPairs(List<Pair> pairs, int i) {

        pairs.get(i).isMarked = true;

        if (i - 1 >= 0) {
            pairs.get(i - 1).isMarked = true;
        }

        if (i + 1 < pairs.size()) {
            pairs.get(i + 1).isMarked = true;
        }
    }

    private boolean isAvailable(List<Pair> pairs) {
        for (Pair pair : pairs) {
            if (!pair.isMarked) return true;
        }
        return false;
    }

    static class Pair {
        int data;
        int index;
        boolean isMarked;

        Pair(int data, int index) {
            this.data = data;
            this.index = index;
            this.isMarked = false;
        }

        Pair(int data){
            this.data = data;
        }
    }


    // this is the heap approach to solve the same problem and it is slightly optimized
    public long findScore(int[] nums) {

        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> {
            if (p1.data == p2.data) return p1.index - p2.index;
            return p1.data - p2.data;
        });

        int n = nums.length;
        boolean[] marked = new boolean[n];
        long score = 0;

        for (int i = 0; i < n; i++) {
            pq.add(new Pair(nums[i], i));
        }

        while (!pq.isEmpty()) {

            Pair pair = pq.poll();
            int idx = pair.index;

            if (marked[idx]) continue;

            score += pair.data;

            marked[idx] = true;
            if (idx - 1 >= 0) {
                marked[idx - 1] = true;
            }
            if (idx + 1 < n) {
                marked[idx + 1] = true;
            }
        }

        return score;
    }

}

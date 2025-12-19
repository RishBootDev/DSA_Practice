import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JobSequencingProblem {

    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {

        int n = profit.length;

        List<Pair> pairs = new ArrayList<>();
        int maxDeadline = 0;

        for (int i = 0; i < n; i++) {
            pairs.add(new Pair(profit[i], deadline[i]));
            maxDeadline = Math.max(maxDeadline, deadline[i]);
        }

        Collections.sort(pairs, (a, b) -> b.profit - a.profit);

        boolean[] slot = new boolean[maxDeadline + 1];

        int jobCount = 0;
        int totalProfit = 0;

        for (Pair job : pairs) {

            for (int t = job.deadline; t > 0; t--) {
                if (!slot[t]) {
                    slot[t] = true;
                    jobCount++;
                    totalProfit += job.profit;
                    break;
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add(jobCount);
        result.add(totalProfit);

        return result;
    }

    static class Pair {
        int profit;
        int deadline;

        public Pair(int profit, int deadline) {
            this.profit = profit;
            this.deadline = deadline;
        }
    }

}

// this is the greedy solution of this problem and more optimal solution for
// this problem exists by disjoint set union approach

import java.util.Collections;
import java.util.List;

public class MaximizeProfitByAsSalesman {


    // this is valid dp solution for the problem
    public int maximizeTheProfit(int n, List<List<Integer>> offers) {
        offers.sort((l1, l2) ->
                l1.getFirst() - l2.getFirst());
        return helper(n, 0, -1, offers);
    }

    public int helper(int n, int i, int prev, List<List<Integer>> offers) {
        if(i == n) return 0;
        int take = 0;
        int not = 0;
        if(prev == -1) {
            // take
            take = helper(n, i + 1, i, offers) + offers.get(i).getLast();
            // not take
            not = helper(n, i + 1, prev, offers);
        }else {
            List<Integer> pre = offers.get(prev);
            int start = pre.getFirst();
            int end = pre.get(1);
            List<Integer> curr = offers.get(i);
            if(curr.getFirst() >= end) {
                // take
                take = helper(n, i + 1, i, offers) + curr.get(2);
                // not take
                not = helper(n, i + 1, prev, offers);
            }else {
                // not take
                not = helper(n, i + 1, prev, offers);
            }
        }
        return Math.max(take, not);
    }
}

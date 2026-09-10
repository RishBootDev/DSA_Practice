import java.util.List;

public class SortingThreeGroups {

    int max = Integer.MIN_VALUE;
    public int minimumOperations(List<Integer> nums) {
        helper(nums, 0, -1, 0);
        return nums.size() - max;
    }
    public void helper(List<Integer> list, int i, int prev, int count) {
        if(i == list.size()) {
           max = Math.max(max, count);
           return;
        }
        if(prev == -1) {
            // take
            helper(list, i + 1, list.get(i), count + 1);
            // not take
            helper(list, i + 1, -1, count + 1);
        }else {
            if(list.get(i) >= list.get(prev)) {
                // take
                helper(list, i + 1, i, count + 1);
            }
            helper(list, i + 1, i, count);
        }

    }
}
// central idea to solve this question is to find the largest increasing
// sequence array in this
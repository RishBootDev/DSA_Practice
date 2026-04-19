import java.util.List;

public class ReachEndOfArrayWithMaxScore {

    public long findMaximumScore(List<Integer> nums) {

        long ans = 0;
        int temp = nums.getFirst();
        int idx = 0;

        for (int i = 1; i < nums.size() - 1; i++) {
            if(nums.get(i) >= temp) {
                ans += (long) temp * (i - idx);
                temp = nums.get(i);
                idx = i;
            }
        }

        ans += (long) temp *(nums.size() - idx);

        return ans;
    }
}

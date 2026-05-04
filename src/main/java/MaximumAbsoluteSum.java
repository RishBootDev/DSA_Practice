import java.util.HashSet;

public class MaximumAbsoluteSum {

    HashSet<String> vis = new HashSet<>();
    int ans = 0;

    public int maxAbsoluteSum(int[] nums) {

        helper(nums, 0, 0);
        return ans;
    }

    public void helper(int[] arr, int i, int sum) {

        if (i == arr.length) {
            return;
        }
        String key = i + "," + sum;
        if (vis.contains(key)) {
            return;
        }
        vis.add(key);

        int take = sum + arr[i];
        ans = Math.max(ans, Math.abs(take));
        helper(arr, i + 1, take);
        helper(arr, i + 1, 0);
    }
}

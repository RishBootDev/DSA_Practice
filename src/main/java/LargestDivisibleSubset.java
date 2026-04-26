import java.util.*;

public class LargestDivisibleSubset {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        return helper(nums, 0, -1);
    }

    public List<Integer> helper(int[] nums, int i, int pv) {

        if (i == nums.length) {
            return new ArrayList<>();
        }

        List<Integer> notTake = helper(nums, i + 1, pv);

        List<Integer> take = new ArrayList<>();
        if (pv == -1 || nums[i] % nums[pv] == 0) {

            take = helper(nums, i + 1, i);
            take = new ArrayList<>(take);
            take.add(0, nums[i]);
        }

        return take.size() > notTake.size() ? take : notTake;
    }
}

class LargestDivisibleSubsetUsingDp {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        List<Integer>[][] dp = new ArrayList[nums.length][nums.length + 1];
        return helper(nums, 0, -1, dp);
    }

    public List<Integer> helper(int[] nums, int i, int pv, List<Integer>[][] dp) {

        if (i == nums.length) {
            return new ArrayList<>();
        }

        if (dp[i][pv + 1] != null) {
            return dp[i][pv + 1];
        }

        List<Integer> notTake = helper(nums, i + 1, pv, dp);

        List<Integer> take = new ArrayList<>();
        if (pv == -1 || nums[i] % nums[pv] == 0) {

            List<Integer> next = helper(nums, i + 1, i, dp);
            take = new ArrayList<>(next);
            take.add(0, nums[i]);
        }

        List<Integer> res = take.size() > notTake.size() ? take : notTake;

        dp[i][pv + 1] = res;
        return res;
    }
}
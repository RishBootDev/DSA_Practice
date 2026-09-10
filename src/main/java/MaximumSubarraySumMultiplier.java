import java.util.Map;

class MaximumSubarraySumMultiplier{

    private long ans;
    private Map<String , Long> map;

    public long maxSubarraySum(int[] nums, int k) {

        ans = Long.MIN_VALUE;

        helper(nums, 0, k, Task.FREE);
        helper(nums, 0, k, Task.MULTIPLY);
        helper(nums, 0, k, Task.DIVIDE);

        return ans;
    }

    public long helper(int nums[], int i, int k, Task task) {
        return solve(nums, i, k, task, false, false, 0);
    }

    private long solve(int[] nums, int i, int k, Task task, boolean subStarted, boolean opUsed, long sum) {
        if (i == nums.length) {
            if (subStarted && opUsed) {
                ans = Math.max(ans, sum);
            }
            return Long.MIN_VALUE;
        }
        String key = i + " " +  task + " " + subStarted + " " + opUsed + " " +  sum;
        if(map.containsKey(key)) return map.get(key);

        if (!subStarted) {
            solve(nums, i + 1, k, Task.FREE, false, false, 0);
            solve(nums, i + 1, k, Task.FREE, true, false, nums[i]);
            solve(nums, i + 1, k, Task.MULTIPLY, true, true, (long) nums[i] * k);
            solve(nums, i + 1, k, Task.DIVIDE, true, true, nums[i] / k);
        } else {
            if (opUsed) {
                ans = Math.max(ans, sum);
            }

            solve(nums, i + 1, k, Task.FREE, true, opUsed, sum + nums[i]);

            if (task == Task.FREE && !opUsed) {
                solve(nums, i + 1, k, Task.MULTIPLY, true, true, sum + (long) nums[i] * k);
                solve(nums, i + 1, k, Task.DIVIDE, true, true, sum + nums[i] / k);
            } else if (task == Task.MULTIPLY) {
                solve(nums, i + 1, k, Task.MULTIPLY, true, true, sum + (long) nums[i] * k);
                solve(nums, i + 1, k, Task.FREE, true, true, sum + nums[i]);
            } else if (task == Task.DIVIDE) {
                solve(nums, i + 1, k, Task.DIVIDE, true, true, sum + nums[i] / k);
                solve(nums, i + 1, k, Task.FREE, true, true, sum + nums[i]);
            }
        }

        map.put(key, ans);
        return ans;
    }

    public static enum Task {
        MULTIPLY,
        DIVIDE,
        FREE
    }
}
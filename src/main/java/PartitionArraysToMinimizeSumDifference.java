import java.util.ArrayList;
import java.util.List;

public class PartitionArraysToMinimizeSumDifference {

    // this is the correct approach to solve this question but it gave me time limit exceeded error 134 / 201
    int min;
    public int minimumDifference(int[] nums) {
        this.min = Integer.MAX_VALUE;
        helper(nums, nums.length / 2, 0, new ArrayList<>(), new ArrayList<>());
        return min;
    }

    public void helper(int[] nums, int n, int i, List<Integer> l1, List<Integer> l2) {

        if(l1.size() == n && l2.size() == n) {
            int sum1 = 0;
            int sum2 = 0;
            for(int c : l1) sum1 += c;
            for(int c : l2) sum2 += c;
            min = Math.min(min, Math.abs(sum1 - sum2));
            return;
        }

        if(i == nums.length) return;

        if(l1.size() == n) {
            for(int j = i; j < nums.length; j++) {
                l2.add(nums[j]);
            }
            int sum1 = 0;
            int sum2 = 0;
            for(int c : l1) sum1 += c;
            for(int c : l2) sum2 += c;
            min = Math.min(min, Math.abs(sum1 - sum2));
            for(int j = i; j < nums.length; j++) {
                l2.removeLast();
            }
            return;
        }

        if(l2.size() == n) {
            for(int j = i; j < nums.length; j++) {
                l1.add(nums[j]);
            }
            int sum1 = 0;
            int sum2 = 0;
            for(int c : l1) sum1 += c;
            for(int c : l2) sum2 += c;
            min = Math.min(min, Math.abs(sum1 - sum2));
            for(int j = i; j < nums.length; j++) {
                l1.removeLast();
            }
            return;
        }

        l1.add(nums[i]);
        helper(nums, n, i + 1, l1, l2);
        l1.removeLast();

        l2.add(nums[i]);
        helper(nums, n, i + 1, l1, l2);
        l2.removeLast();
    }
}

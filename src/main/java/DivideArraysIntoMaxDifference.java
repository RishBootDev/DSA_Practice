import java.util.Arrays;
import java.util.Collection;

public class DivideArraysIntoMaxDifference {

    public int[][] divideArray(int[] nums, int k) {

        int ans [][] = new int[nums.length/3][3];

        Arrays.sort(nums);

        int j = -1;
        for (int i = 0; i < nums.length; i++) {
            if(i % 3 == 0) j++;
            ans[j][i%3] = nums[i];

        }

        for (int i = 0; i < ans.length; i++) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int l = 0; l < ans[i].length; l++) {
                min = Math.min(ans[i][l], min);
                max = Math.max(ans[i][l], max);
            }

            if(max - min > k) return new int[0][0];
        }

        return ans;
    }
}

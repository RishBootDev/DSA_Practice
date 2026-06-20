import java.util.Arrays;

public class FrequencyOfTheMostFrequentElement {

    public int maxFrequency(int[] nums, int k) {

        Arrays.sort(nums);
        int max = Integer.MIN_VALUE;

        for (int i = nums.length - 1; i > 0 ; i--) {
            int start = nums[i];
            int temp = k;
            int count = 1;
            for(int j = start - 1; j > 0; j++) {
                if(nums[i] - nums[j] <= temp) {
                    count++;
                    temp -= (nums[i] - nums[j]);
                }else break;
            }
            max = Math.max(count, max);
        }
        return max;
    }
}

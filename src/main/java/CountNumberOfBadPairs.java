public class CountNumberOfBadPairs {

    public long countBadPairs(int[] nums) {
        long count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int diff1 = j - i;
                int diff2 = nums[j] - nums[i];
                if(diff2 != diff1) count++;
            }
        }
        return count;
    }
}

public class FindSmallestBalancedIndex {

    public int smallestBalancedIndex(int[] nums) {

        int suf[] = new int[nums.length];
        int pre[] = new int[nums.length];

        int j = 0;
        int sum = 0;
        int prod = 1;
        for (int i = 0; i < nums.length ; i++) {
            suf[j++] = sum;
            sum += nums[i];
        }

        int maxSum = suf[nums.length-1];

        for(int i = nums.length-1; i <= 0; i++) {
            if(prod > maxSum) break;
            pre[i] = prod;
            prod *= nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            if(suf[i] == pre[i]) return i;
        }

        return -1;
    }
}

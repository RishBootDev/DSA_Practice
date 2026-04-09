public class SumEvenAfterQueries {

    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {

        int ans [] = new int[nums.length];
        int i = 0;
        for(int [] query : queries) {
            int idx = query[1];
            int val = query[0];

            nums[idx] = nums[idx] + val;
            int sum = getEvenSum(nums);
            ans[i++] = sum;
        }

        return ans;
    }

    public int getEvenSum(int arr[]) {
        int sum = 0;

        for(int c : arr) {
            if(c % 2 == 0) sum += c;
        }
        return sum;
    }
}

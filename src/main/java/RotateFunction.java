public class RotateFunction {


    // this is bruteforce approach and solves 45 / 58 test cases
    public int maxRotateFunction(int[] nums) {

        int max = Integer.MIN_VALUE;

        for (int k = 0; k < nums.length; k++) {

            int ans = 0;
            for (int i = 0; i < nums.length; i++) {
                ans += (i * nums[i]);
            }
            max = Math.max(max, ans);
            rotateByOne(nums);
        }
        return max;
    }

    public void rotateByOne(int[] arr) {

        int n = arr.length;

        reverse(arr, 0, n - 1);
        reverse(arr, 0, 0);
        reverse(arr, 1, n - 1);
    }

    private void reverse(int[] arr, int start, int end) {

        while (start < end) {

            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }

    Integer dp[];

    public int maxRotateFunction2(int[] nums) {
        this.dp = new Integer[nums.length];
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int c : nums) sum += c;

        for (int i = 0; i < nums.length; i++) {
            int ans = helper(i,nums,sum);
            max = Math.max(ans, max);
        }

        return max;
    }

    // i am writing the recursion of the above problem
    public int helper(int k, int arr[], int sum) {

        int n = arr.length;
        if(k == 0) {
           int ans = 0;
            for (int i = 0; i < arr.length; i++) {
                ans += (i * arr[i]);
            }
            return ans;
        }
        if(dp [k] != null) return dp[k];
        return dp[k] =  helper(k - 1 , arr, sum)+sum-n*arr[n-k];
    }
}

// F(k)=F(k−1)+sum−n⋅nums[n−k]  ->   this is the observed recurrence relation between states

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
}

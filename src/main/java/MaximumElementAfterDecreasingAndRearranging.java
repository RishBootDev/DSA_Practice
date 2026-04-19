import java.util.Arrays;

public class MaximumElementAfterDecreasingAndRearranging {

    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {

        Arrays.sort(arr);
        arr[0] = 1;

        for (int i = 1; i < arr.length; i++) {

            int diff = Math.abs(arr[i] - arr[i-1]);
            if(diff >= 1) arr[i] = arr[i-1] + 1;
        }

        int ans = Integer.MIN_VALUE;
        for(int x : arr) ans = Math.max(x, ans);
        return ans;
    }
}

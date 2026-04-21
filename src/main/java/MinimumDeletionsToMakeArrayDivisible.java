import java.util.Arrays;

public class MinimumDeletionsToMakeArrayDivisible {

    public int minOperations(int[] nums, int[] numsDivide) {
        Arrays.sort(nums);
        int gcd = gcdOfArray(numsDivide);

        System.out.println(Arrays.toString(nums));

        for(int i = 0; i< nums.length; i++) {
            if( gcd % nums[i] == 0) return i;
        }
        System.out.println(Arrays.toString(nums));
        return -1;
    }

    public int gcdOfArray(int[] arr) {
        int result = arr[0];

        for (int i = 1; i < arr.length; i++) {
            result = gcd(result, arr[i]);
        }

        return result;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}

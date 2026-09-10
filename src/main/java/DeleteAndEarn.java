import java.util.Arrays;

public class DeleteAndEarn {

    public int deleteAndEarn(int[] nums) {
        return helper(nums, 0);
    }
    public int helper(int nums [], int i) {
        if(i == nums.length) return 0;

        // not take
        int not = helper(nums, i + 1);
        // take
        int ans = nums[i];
        int take = helper(nums, i + 1) + ans;

        for (int j = 0; j < nums.length; j++) {
            if(nums[i] == ans - 1 || nums[i] == ans + 1) nums[i] = 0;
        }
        return Math.max(take, not);
    }

    public static void main(String[] args) {
        int arr[] = new int[5];
        arr[0] = 1;
        arr[1] = 2;
        arr[3] = 3;
        arr[4] = 4;
        arr[2] = 5;

        for(int c : arr) c = 0;

        System.out.println(Arrays.toString(arr));
    }
}

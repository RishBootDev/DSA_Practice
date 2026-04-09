import java.util.Arrays;

public class PolygonWithLargestPerimeter {

    // 50, 12, 5, 3, 2, 1, 1

    public long largestPerimeter(int[] nums) {

        Arrays.sort(nums);
        long sum = 0;
        long pre[] = new long[nums.length];

        for (int i = 0; i < nums.length; i++) {
            pre[i] += sum;
            sum += nums[i];
        }

        // System.out.println(Arrays.toString(pre));
        long temp = -1;
        int idx = -1;
        for (int i = nums.length-1; i >= 0 ; i--) {
            if(nums[i] < pre[i]) {
                temp = pre[i] + nums[i];
                idx = i;
                break;
            }
        }
        if(idx < 2) return -1;
        return temp;
    }
}

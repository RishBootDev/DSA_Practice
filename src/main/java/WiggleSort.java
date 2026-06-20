import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WiggleSort {


    // this approach worked for 47 / 52 test cases
    public void wiggleSort(int[] nums) {

        Arrays.sort(nums);
        int[] arr = new int[nums.length];
        int i = 0;
        for (int j = 0; j < arr.length; j+=2) {
            arr[j] = nums[i++];
        }
        for (int j = 1; j < arr.length; j+=2) {
            arr[j] = nums[i++];
        }
        System.out.println(Arrays.toString(arr));
    }
}

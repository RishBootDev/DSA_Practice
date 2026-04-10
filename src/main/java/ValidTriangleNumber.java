import java.util.Arrays;

public class ValidTriangleNumber {


    // this is valid bruteforce approach and got TLE after 232 / 241 testcases passed
    public int triangleNumber(int[] nums) {

        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int a = nums[i];
                    int b = nums[j];
                    int c = nums[k];
                    if(isTriangle(a, b, c)) count++;
                }
            }
        }
        return count;
    }
    public boolean isTriangle(int a, int b, int c) {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }

}

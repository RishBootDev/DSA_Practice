import java.util.Arrays;

public class LexicographicalLargestValidSequence {

    int[] max;
    public int[] constructDistancedSequence(int n) {
        this.max = new int[2 * (n - 1) + 1];
        int arr[] = new int[max.length];
        helper(n, arr, n);
        return max;
    }

    public void helper(int n, int arr[], int x) {

        if (x == 0) {
            System.out.println(Arrays.toString(arr));
            updateMax(arr, max);
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (x == 1) {
                if (arr[i] != 0) continue;
                arr[i] = x;
                helper(n, arr, x - 1);
                arr[i] = 0;

            } else {
                if (i + x >= arr.length) continue;
                if (arr[i] != 0 || arr[i + x] != 0) continue;

                arr[i] = x;
                arr[i + x] = x;
                helper(n, arr, x - 1);
                arr[i] = 0;
                arr[i + x] = 0;
            }
        }
    }

    public void updateMax(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] > arr2[i]) {
                max = Arrays.copyOf(arr1, arr1.length);
                return;
            }
            if (arr1[i] < arr2[i]) {
                return;
            }
        }
    }

    public static void main(String[] args) {

        LexicographicalLargestValidSequence ob =
                new LexicographicalLargestValidSequence();
        System.out.println(Arrays.toString(ob.constructDistancedSequence(12)));
    }
}

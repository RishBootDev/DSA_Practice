public class RangeSumQuery {
    public static void main(String[] args) {

    }
}

class NumArray {
    private int [] arr;

    public NumArray(int[] nums) {
        this.arr = nums;
    }

    public void update(int index, int val) {
        arr[index] = val;
    }

    public int sumRange(int left, int right) {
        int sum = 0;
        for (int i = left; i <= right; i++) {
            sum += arr[i];
        }
        return sum;
    }
}

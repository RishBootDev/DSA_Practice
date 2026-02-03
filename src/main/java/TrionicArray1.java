public class TrionicArray1 {

    public boolean isTrionic(int[] nums) {
        if (nums == null || nums.length < 3) return false;

        int i = beginIndex(nums);
        int j = lastIndex(nums);

        if (i <= 0 || j <= i || j >= nums.length - 1) return false;

        for (int k = i; k < j; k++) {
            if (nums[k] <= nums[k + 1]) return false;
        }

        return true;
    }

    public int beginIndex(int[] nums) {
        int i = 0;

        while (i + 1 < nums.length && nums[i] < nums[i + 1]) {
            i++;
        }

        return i;
    }

    public int lastIndex(int[] nums) {
        int i = nums.length - 1;

        while (i - 1 >= 0 && nums[i - 1] < nums[i]) {
            i--;
        }

        return i;
    }

    public boolean isSorted(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] >= nums[i + 1]) return false;
        }
        return true;
    }

    public boolean isSortedReverse(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] <= nums[i + 1]) return false;
        }
        return true;
    }
}

class Solution {
    
    public int minOperations(int[] nums) {
        int n = nums.length;

        if (isSorted(nums)) return 0;
        if (isReverseSorted(nums)) return 1;
        if (n == 2) return 1;
        if (!isCyclic(nums)) return -1;

        int idx = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                idx = i;
                break;
            }
        }
        if (nums[(idx + 1) % n] == 1) {
            return Math.min(idx, (n - idx) + 2);
        } else {
            return Math.min(idx + 2, n - idx);
        }
    }

    public boolean isCyclic(int[] arr) {
        int n = arr.length;
        int left = 0, right = 0;

        for (int i = 0; i < n; i++) {
            int next = (i + 1) % n;
            int prev = (i - 1 + n) % n;

            if (arr[next] != arr[i] + 1) right++;
            if (arr[prev] != arr[i] + 1) left++;
        }

        return right == 1 || left == 1;
    }

    public boolean isSorted(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) return false;
        }
        return true;
    }

    public boolean isReverseSorted(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) return false;
        }
        return true;
    }
}
public class MaximumDistanceBetweenAPairOfValues {

    public int maxDistance(int[] nums1, int[] nums2) {

        int max = 0;

        for (int i = 0; i < nums1.length; i++) {

            int j = i;
            int k = nums2.length - 1;

            while (j <= k) {
                int mid = j + (k - j) / 2;

                if (nums2[mid] >= nums1[i]) {
                    j = mid + 1;
                } else {
                    k = mid - 1;
                }
            }

            if (k >= i) {
                max = Math.max(max, k - i);
            }
        }

        return max;
    }
}

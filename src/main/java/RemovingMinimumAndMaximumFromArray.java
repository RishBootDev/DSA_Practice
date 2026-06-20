public class RemovingMinimumAndMaximumFromArray {

    public int minimumDeletions(int[] nums) {

        int i1 = -1;
        int i2 = -1;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if(min > nums[i]) {
                min = nums[i];
                i1 = i;
            }
            if(max < nums[i]) {
                max = nums[i];
                i2 = i;
            }
        }

        if(i1 == i2) {
            return Math.min(i1 + 1, nums.length - i1);
        }else {
            if(i1 > i2) {
                int dist1 = i2 + 1;
                int dist2 = nums.length - i1;
                int dist3 = i1 + nums.length - i2;
                return Math.max(dist1, Math.max(dist2, dist3));
            }else {
                int dist1 = i1 + 1;
                int dist2 = nums.length - i2;
                int dist3 = i2 + nums.length - i1;
                return Math.max(dist1, Math.max(dist2, dist3));
            }
        }
    }
}

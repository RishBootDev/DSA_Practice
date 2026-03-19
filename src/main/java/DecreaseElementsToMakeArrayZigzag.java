public class DecreaseElementsToMakeArrayZigzag {

    public int movesToMakeZigzag(int[] nums) {

        int countEven = 0;
        int countOdd = 0;

        for (int i = 0; i < nums.length; i++) {

            int left = (i > 0) ? nums[i - 1] : Integer.MAX_VALUE;
            int right = (i < nums.length - 1) ? nums[i + 1] : Integer.MAX_VALUE;

            int minNeighbor = Math.min(left, right);

            int moves = 0;
            if (nums[i] >= minNeighbor) {
                moves = nums[i] - (minNeighbor - 1);
            }

            if (i % 2 == 0) {
                countEven += moves;
            } else {
                countOdd += moves;
            }
        }

        return Math.min(countEven, countOdd);
    }
}

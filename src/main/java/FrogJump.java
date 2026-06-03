public class FrogJump {

    public boolean canCross(int[] stones) {
        return helper(stones, 0, 1);
    }

    public boolean helper(int []stones, int i, int k) {
        if(i == stones.length) {
             return true;
        }
        else if (k < 0) return false;

        boolean ans = false;

        for (int j = i + 1; j < stones.length; j++) {
            if(stones[j] - stones[i] == k - 1) {
                ans |= helper(stones, j, k - 1);
            }else if (stones[j] - stones[i] == k + 1) {
                ans |= helper(stones, j, k + 1);
                break;
            }
        }
        return ans;
    }
}

class Solution {
    public int brokenCalc(int startValue, int target) {
        return helper(startValue, target);
    }

    public int helper(int start, int target) {
        if(target <= start) return start - target;

        if(target % 2== 0) return helper(start, target / 2) + 1;
        return helper(start, target + 1) + 1;
    }
}

// this got a cool recursive solution backwards
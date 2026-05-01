public class CountNumberOfTeams {

    Integer dp[][][];

    public int numTeams(int[] rating) {

        int inc = 0;
        int dec = 0;

        dp = new Integer[rating.length][4][2];

        for (int i = 0; i < rating.length; i++) {
            inc += helper(rating, i, 1, true);
            dec += helper(rating, i, 1, false);
        }
        return inc + dec;
    }

    public int helper(int[] arr, int prev, int count, boolean increasing) {

        if (count == 3) {
            return 1;
        }
        int flag = increasing ? 1 : 0;
        if (dp[prev][count][flag] != null) {
            return dp[prev][count][flag];
        }
        int ans = 0;
        for (int j = prev + 1; j < arr.length; j++) {
            if (increasing) {
                if (arr[j] > arr[prev]) {
                    ans += helper(arr, j, count + 1, true);
                }
            } else {
                if (arr[j] < arr[prev]) {
                    ans += helper(arr, j, count + 1, false);
                }
            }
        }
        return dp[prev][count][flag] = ans;
    }
}
public class HouseRobberProblem {

    public static void main(String[] args) {

        int arr[] = new int[5];
        int dp []= new int[arr.length];
    }

    public static int houseRobber(int arr[], int j) {

        // Base case
        if(j < 0){
            return 0;
        }
        if (j == 0) return 0;
        int taken = arr[j] + houseRobber(arr, j - 2);
        int notTaken = houseRobber(arr, j -1);

        return Math.max(taken, notTaken);
    }

    public static int houseRobberWithDp(int arr[], int j, int dp[]) {

        // Base case
        if(j < 0){
            return 0;
        }
        if (j == 0) return 0;

        if (dp[j] !=-1) return dp[j];

        int taken = arr[j] + houseRobber(arr, j - 2);
        int notTaken = houseRobber(arr, j -1);

        return dp[j] = Math.max(taken, notTaken);
    }


    public static int houseRobberWithbottomUpApproach(int arr[], int dp[]) {

        int n = arr.length;

        if (n == 0) return 0;
        if (n == 1) return arr[0];

        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);

        for (int i = 2; i < n; i++) {
            int taken = arr[i] + dp[i - 2];
            int notTaken = dp[i - 1];

            dp[i] = Math.max(taken, notTaken);
        }

        return dp[n - 1];
    }


}

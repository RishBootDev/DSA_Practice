class Solution {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {

        int cost = 0;
        int maxCost = 0;
        int ans = -1;

        int wait = 0;
        int rotation = 0;

        for (int i = 0; i < customers.length; i++) {
            wait += customers[i];

            if (wait >= 4) {
                wait -= 4;
                cost += 4 * boardingCost - runningCost;
            } else {
                cost += wait * boardingCost - runningCost;
                wait = 0;
            }
            rotation++;
            if (cost > maxCost) {
                maxCost = cost;
                ans = rotation;
            }
        }

        while (wait > 0) {
            if (wait >= 4) {
                wait -= 4;
                cost += 4 * boardingCost - runningCost;
            } else {
                cost += wait * boardingCost - runningCost;
                wait = 0;
            }
            rotation++;
            if (cost > maxCost) {
                maxCost = cost;
                ans = rotation;
            }
        }
        return ans;
    }
}
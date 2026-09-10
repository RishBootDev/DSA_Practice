public class MaximumWheelOperatingCelennialWheel {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {

        int cost = 0;
        int wait = 0;
        for (int i = 0; i < customers.length; i++) {
            wait += customers[i];
            if(wait >= 4) {
                wait -= 4;
                cost += 4 * boardingCost - runningCost;
            }
            else {
                cost += wait * boardingCost - runningCost;
                wait = 0;
            }
        }
        cost +=  wait * boardingCost - Math.ceilDiv(wait, 4) * runningCost;
        if(cost < 0) return -1;
        return cost;
    }
}

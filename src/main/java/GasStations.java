public class GasStations {
    public static void main(String[] args) {

        int [] gas={1,2,3,4,5};
        int [] cost={3,4,5,1,2};
        System.out.println(canCompleteCircuit(gas,cost));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {

        int n = gas.length;
        for (int i = 0; i < n; i++) {

            int sum = 0;
            boolean possible = true;

            for (int j = i; j < i + n; j++) {

                int idx = j%n;
                if (sum+gas[idx]<cost[idx]) {
                    possible=false;
                    break;
                }
                sum+=gas[idx]-cost[idx];
            }
            if(possible) return i;
        }

        return -1;
    }
    public static int canCompleteCircuitOptimized(int[] gas, int[] cost) {

        int totalGas = 0;
        int currentGas = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {

            int diff = gas[i] - cost[i];

            totalGas += diff;
            currentGas += diff;

            if (currentGas < 0) {
                start = i + 1;
                currentGas = 0;
            }
        }

        return totalGas >= 0 ? start : -1;
    }

}

class Solution {
   
    public double averageWaitingTime(int[][] customers) {

        long wt = 0;
        long total = 0;

        for (int i = 0; i < customers.length; i++) {
            int arrival = customers[i][0];
            int cook = customers[i][1];
            if (wt < arrival) {
                wt = arrival;
            }
            wt += cook;
            total += wt - arrival;
        }

        return (double) total / customers.length;
    }
}
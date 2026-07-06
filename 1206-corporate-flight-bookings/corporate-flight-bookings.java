class Solution {

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n];

        for (int[] booking : bookings) {
            int first = booking[0];
            int last = booking[1];
            int seats = booking[2];

            for (int i = first - 1; i <= last - 1; i++) {
                ans[i] += seats;
            }
        }

        return ans;
    }

}
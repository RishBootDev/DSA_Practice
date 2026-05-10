class Solution {
    
    public int findBestValue(int[] arr, int target) {

        Arrays.sort(arr);
        long sum = 0;
        int n = arr.length;

        for (int i = 0; i < arr.length; i++) {
            int x = n - i;
            long temp = sum + (long) x * arr[i];

            if (temp >= target) {
                int v = (int) ((target - sum) / x);
                long s1 = sum + (long) v * x;
                long s2 = sum + (long) (v + 1) * x;

                if (Math.abs(s1 - target) <= Math.abs(s2 - target)) {
                    return v;
                } else {
                    return v + 1;
                }
            }

            sum += arr[i];
        }

        return arr[n - 1];
    }
}
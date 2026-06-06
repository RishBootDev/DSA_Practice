class Solution {
    private final  int MOD = 1000000007;
    public int valueAfterKSeconds(int n, int k) {

        int arr[]= new int[n];
        Arrays.fill(arr, 1);

        //int i = 0;
        
        while(k --> 0) {
            int sum = 0;
            for(int i = 0; i< arr.length; i++) {
               sum = (sum + arr[i])%MOD;
               arr[i] = sum;
            }
        }
        return arr[n - 1];
        
    }
}
class Solution {

    public int minimizeSum(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        return Math.min(Math.min(arr[n - 1] - arr[2], arr[n - 3] - arr[0]), arr[n - 2] - arr[1]);
    }
}
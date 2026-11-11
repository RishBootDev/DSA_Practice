class Solution {
    
    Map<String, Integer> map;
    public int maxSumAfterPartitioning(int[] arr, int k) {
        this.map = new HashMap<>();
        return helper(arr, 0, k, Integer.MIN_VALUE);
    }

    public int helper(int[] arr, int i, int k, int max) {
        if (i == arr.length) {
            return 0;
        }
        String key = i + ", " + max;
        int sum = 0;
        int count = 1;
        if(map.containsKey(key)) return map.get(key);
        for (int j = i; j < i + k && j < arr.length; j++) {
            max = Math.max(max, arr[j]);
            int take = helper(arr, j + 1, k, Integer.MIN_VALUE) + count * max;

            sum = Math.max(sum, take);
            count++;
        }
        map.put(key, sum);
        return sum;
    }
}
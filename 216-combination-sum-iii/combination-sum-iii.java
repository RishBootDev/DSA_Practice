class Solution {
   
   private List<List<Integer>> ans;
    public List<List<Integer>> combinationSum3(int k, int n) {
          this.ans = new ArrayList<>();
          int arr[] = new int[9];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        helper(arr, 0, n, k, new ArrayList<>());
        return ans;
    }

    public void helper(int arr[], int i, int sum, int k, List<Integer> temp) {
        if(sum < 0) return;
        if(i == arr.length) {
            if(sum == 0 && k == 0) {
                ans.add(new ArrayList<>(temp));
            }
            return;
        }
        // take
        if(k > 0) {
            temp.add(arr[i]);
            helper(arr, i + 1, sum - arr[i], k - 1, temp);
            temp.removeLast();
        }
        // not take
        helper(arr, i + 1, sum, k, temp);
    }
}
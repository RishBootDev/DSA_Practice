class Solution {
   
   public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(n, 1, k, new ArrayList<>(), ans);
        return ans;
    }

     public void helper(int n, int i, int k,
                       List<Integer> temp,
                       List<List<Integer>> ans) {

        if(k == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        if(i > n) return;

        // take
        temp.add(i);
        helper(n, i + 1, k - 1, temp, ans);
        temp.remove(temp.size() - 1);

        // not take
        helper(n, i + 1, k, temp, ans);
    }
}
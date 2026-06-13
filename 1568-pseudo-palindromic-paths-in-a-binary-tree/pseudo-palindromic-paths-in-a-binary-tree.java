class Solution {
    int cnt;
    HashMap<Integer,Integer> mp;
    
    private Boolean check() {
        int odd = 0;

        for(Map.Entry<Integer,Integer> it : mp.entrySet()) {
            if(it.getValue()%2 != 0) {
                odd++;
            }
        }
        
        return odd<=1;
    }

    private void solve(TreeNode root) {
        if(root==null)  return;

        this.mp.put(root.val, this.mp.getOrDefault(root.val, 0)+1);
        
        solve(root.left);
        solve(root.right);

        if(root.left==null && root.right==null) {
            if(check())  cnt++;
        }

        this.mp.put(root.val, this.mp.get(root.val)-1);
    }

    public int pseudoPalindromicPaths (TreeNode root) {
        this.mp = new HashMap<>();
        this.cnt = 0;
        solve(root);
        return this.cnt;
    }
}
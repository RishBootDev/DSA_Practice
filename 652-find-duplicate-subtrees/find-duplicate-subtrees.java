class Solution {
    
    private Set<String> set;
    private Set<String> duplicateSet;
    private List<TreeNode> ans;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        set = new HashSet<>();
        duplicateSet = new HashSet<>();
        ans = new ArrayList<>();

        check(root);

        return ans;
    }

    public void check(TreeNode root) {
        if(root == null) return;

        String p = path(root);

        if(set.contains(p)) {
            if(!duplicateSet.contains(p)) {
                ans.add(root);
                duplicateSet.add(p);
            }
        } else {
            set.add(p);
        }

        check(root.left);
        check(root.right);
    }

    public String path(TreeNode root) {
        List<String> temp = new ArrayList<>();
        preorder(root, temp);
        return temp.toString();
    }

    public void preorder(TreeNode root, List<String> temp) {
        if(root == null) {
            temp.add("null");
            return;
        }

        temp.add(String.valueOf(root.val));

        preorder(root.left, temp);
        preorder(root.right, temp);
    }
}
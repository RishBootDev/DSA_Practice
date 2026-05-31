class Solution {

    public String smallestFromLeaf(TreeNode root) {

        List<String> ans = new ArrayList<>();

        helper(root, new StringBuilder(), ans);
        Collections.sort(ans);
        return ans.get(0);
    }

    public void helper(TreeNode root, StringBuilder sb, List<String> list) {
        if (root == null) return;
        sb.append((char)('a' + root.val));

        if (root.left == null && root.right == null) {

            String str = new StringBuilder(sb)
                    .reverse()
                    .toString();

            list.add(str);
            sb.deleteCharAt(sb.length() - 1);
            return;
        }

        helper(root.left, sb, list);
        helper(root.right, sb, list);

        sb.deleteCharAt(sb.length() - 1);
    }
}
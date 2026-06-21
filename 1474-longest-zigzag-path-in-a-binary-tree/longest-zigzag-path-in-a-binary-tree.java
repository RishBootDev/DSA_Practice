class Solution {

    Map<String, Integer> map = new HashMap<>();

    public int longestZigZag(TreeNode root) {
        if (root == null) return 0;

        String key = System.identityHashCode(root) + "";

        if (map.containsKey(key)) {
            return map.get(key);
        }

        int left = helper(root.left, "left");
        int right = helper(root.right, "right");

        int startLeft = longestZigZag(root.left);
        int startRight = longestZigZag(root.right);

        int ans = Math.max(
                Math.max(left, right),
                Math.max(startLeft, startRight)
        );

        map.put(key, ans);

        return ans;
    }

    public int helper(TreeNode root, String dir) {
        if (root == null) return 0;

        String key = System.identityHashCode(root) + "-" + dir;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        int ans;
        if (dir.equals("left")) {
            ans = 1 + helper(root.right, "right");
        } else {
            ans = 1 + helper(root.left, "left");
        }
        map.put(key, ans);
        return ans;
    }
}
import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, List<Pair>> map = new TreeMap<>();

        marking(root, 0, 0, map);

        List<List<Integer>> ans = new ArrayList<>();

        for (List<Pair> list : map.values()) {
            Collections.sort(list, (p1, p2) -> {
                if (p1.i == p2.i) {
                    return p1.j - p2.j;
                }

                return p1.i - p2.i;
            });

            List<Integer> temp = new ArrayList<>();

            for (Pair p : list) {
                temp.add(p.j);
            }

            ans.add(temp);
        }

        return ans;
    }

    public void marking(TreeNode root, int i, int j, TreeMap<Integer, List<Pair>> map) {
        if (root == null) {
            return;
        }

        Pair key = new Pair(i, root.val);

        if (map.containsKey(j)) {
            map.get(j).add(key);
        } else {
            List<Pair> temp = new ArrayList<>();
            temp.add(key);
            map.put(j, temp);
        }

        marking(root.left, i + 1, j - 1, map);
        marking(root.right, i + 1, j + 1, map);
    }

    static class Pair {

        int i;
        int j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}

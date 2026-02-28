import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostFrequentSubtreeSum {

    public int[] findFrequentTreeSum(TreeNode root) {

        if (root == null) return new int[0];

        Map<Integer, Integer> map = new HashMap<>();
        subtree(root, map);

        int maxFreq = 0;

        for (int freq : map.values()) {
            maxFreq = Math.max(maxFreq, freq);
        }

        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxFreq) {
                list.add(entry.getKey());
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }

    public int subtree(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) {
            return 0;
        }

        int left = subtree(root.left, map);
        int right = subtree(root.right, map);

        int sum = left + right + root.val;
        map.put(sum, map.getOrDefault(sum, 0) + 1);

        return sum;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
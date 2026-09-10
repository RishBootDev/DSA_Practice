import java.util.*;

public class VerticalOrderTraversal {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        marking(root, 0, 0, map);
        Collection<List<Integer>> col = map.values();
        for(List<Integer> list : col) {
            Collections.sort(list);
        }
        return new ArrayList<>(col);
    }
    public void marking(TreeNode root, int i, int j, TreeMap<Integer, List<Integer>> map) {
        if(root == null) return;
        int key = j;
        if(map.containsKey(key)) {
            map.get(key).add(root.val);
        }else {
            List<Integer> temp = new ArrayList<>();
            temp.add(root.val);
            map.put(key, temp);
        }
        marking(root.left, i + 1, j - 1, map);
        marking(root.right, i + 1, j + 1, map);
    }

    public void printPath(TreeNode root, List<Integer> list) {
        if(root == null) return;

        list.add(root.val);
        if(root.left == null && root.right == null) {
            System.out.println(list);
        }
        printPath(root.left, list);
        printPath(root.right, list);
        list.removeLast();
    }
}

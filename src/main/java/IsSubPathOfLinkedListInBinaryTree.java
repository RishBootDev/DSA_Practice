public class IsSubPathOfLinkedListInBinaryTree {

    public boolean isSubPath(ListNode head, TreeNode root) {

        TreeNode found = isFound(head, root);

        if(found == null) return false;

        return isPresent(head, found);


    }

    public boolean isPresent(ListNode head, TreeNode root) {

        if (head == null) return true;
        if (root == null) return false;

        if (root.val != head.val) return false;

        return isPresent(head.next, root.left)
                || isPresent(head.next, root.right);
    }


    public TreeNode isFound(ListNode head, TreeNode root) {

        if (root == null || head == null) return null;

        if(root.val == head.val) return root;
        isFound(head,root.left);
        isFound(head,root.right);

        return null;
    }


    static class ListNode {
     int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
}

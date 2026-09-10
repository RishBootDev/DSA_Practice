/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

     public String serialize(TreeNode root) {

       List<Integer> list = new ArrayList<>();
       //inorder(root, list);
        preorder(root, list);
       return list.toString();
    }


    public TreeNode deserialize(String data) {
        if(data.length() == 2) return null;
        List<Integer> ans = process(data);
        TreeNode root = new TreeNode(ans.getFirst());
        for (int i = 1; i < ans.size(); i++) {
            insert(root, ans.get(i));
        }
        return root;
    }
    public TreeNode insert(TreeNode root, int data) {

        if(root == null) {
            root = new TreeNode(data);
            return root;
        }
        else if(root.val > data) {
            root.left = insert(root.left, data);
        }else {
            root.right = insert(root.right, data);
        }
        return root;
    }

    public List<Integer> process(String str) {
        String temp = str.substring(1, str.length() - 1);
        String fin[] = str.substring(1, str.length() - 1).split(", ");
        List<Integer> ans = new ArrayList<>();
        for(String f : fin) {
            ans.add(Integer.parseInt(f));
        }
        return ans;
    }
    
    public void preorder(TreeNode root, List<Integer> list) {
        if(root == null) return;
        list.add(root.val);
        preorder(root.left, list);
        preorder(root.right, list);
    }

    public void inorder(TreeNode root, List<Integer> list) {
        if(root == null) return;

        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
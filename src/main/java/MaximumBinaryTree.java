public class MaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] arr) {
        return helper(arr, 0, arr.length - 1);
    }

    public TreeNode helper(int[] arr, int i, int j) {

        if (i > j) return null;

        int mid = getMax(arr,i,j);
        TreeNode root = new TreeNode(arr[mid]);
        root.left = helper(arr, i, mid - 1);
        root.right = helper(arr, mid + 1, j);

        return root;
    }

    public int getMax(int arr[],int i,int j){

        int max=Integer.MIN_VALUE;
        int temp=-1;

        for (int k = i; k <=j ; k++) {
            if(max<arr[k]){
                max=Math.max(max,arr[k]);
                temp=k;
            }
        }

        return temp;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

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

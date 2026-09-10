class Solution {

    long ans = 0;
    public long weightedSum(int[] parent, int[] nums) {
        List<List<Integer>> tree = new ArrayList<>();
        for(int i = 0; i< parent.length; i++) tree.add(new ArrayList<>());

        for(int i = 1; i < parent.length; i++) {
            int p = parent[i];

            tree.get(p).add(i);
        }

        int height = height(tree, 0);

        weight(tree, 0, nums, 1, height);
        return ans;
    }

    public void weight(List<List<Integer>> tree, int start, int nums[], int depth, int height) {

        ans += (long)nums[start]*(height - depth + 1);

        for(int node : tree.get(start)) {
            weight(tree, node, nums, depth + 1, height);
        }
    }
    

    public int height(List<List<Integer>> tree, int start) {

        int ht = 1;
        for(int node : tree.get(start)) {
            int temp = height(tree, node);
            ht = Math.max(ht, temp + 1);
        }
        return ht;
    }

    
}
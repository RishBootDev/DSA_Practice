class Solution {
    
    public boolean canReach(int[] arr, int start) {
        boolean vis[] = new boolean[arr.length];
        return helper(arr, start, vis);
    }
    public boolean helper(int arr[], int i, boolean vis[]) {
        if(i >= arr.length || i < 0) {
            return false;
        }
        if(arr[i] == 0) return true;
        if(vis[i]) return false;
        vis[i] = true;
        
        boolean aage = helper(arr, i + arr[i], vis);
        boolean peeche = helper(arr, i - arr[i], vis);
        return aage || peeche;
    }
}
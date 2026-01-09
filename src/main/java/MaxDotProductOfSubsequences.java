public class MaxDotProductOfSubsequences {

    int arr[],barr[];
    int neg = Integer.MIN_VALUE/2;

    public int maxDotProduct(int[] nums1, int[] nums2) {

        this.arr=nums1;
        this.barr=nums2;
        return solve(0,0);
    }

    public int solve(int i, int j) {
        if(i == arr.length || j == barr.length) {
            return neg;
        }

        int take = arr[i]*barr[i] + Math.max(0, solve(i+1,j+1));
        int skip1 = solve(i+1,j);
        int skip2 = solve(i,j+1);

        return Math.max(take, Math.max(skip1,skip2));
    }
}

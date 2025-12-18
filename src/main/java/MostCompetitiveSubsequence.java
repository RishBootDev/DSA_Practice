public class MostCompetitiveSubsequence {
    public static void main(String[] args) {

    }

    public int[] mostCompetitive(int[] nums, int k) {

        int j=nums.length-k;
        int i=0;

        int ans[]=new int[k];

        for (int l = 0; l < ans.length; l++) {
            int min=Integer.MAX_VALUE;
            int idx=-1;

            System.out.println("Searching min between i="+i +" and j="+j);
            for (int m = i; m <=j ; m++) {
                if(min>nums[m]){
                    min=Math.min(min,nums[m]);
                    idx=m;
                }
                min=Math.min(min,nums[m]);
            }
            ans[l]=min;
            j++;
            i=idx;
        }

        return ans;
    }

}

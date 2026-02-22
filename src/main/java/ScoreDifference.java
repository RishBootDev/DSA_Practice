public class ScoreDifference {

    public int scoreDifference(int[] nums) {

        boolean swap = true;
        int count1 = 0;
        int count2 = 0;

        for (int i = 0; i < nums.length; i++) {

            if(nums[i] % 2 != 0 || i%6 == 0) swap = !swap;

            if(swap) count1+=nums[i];
            else count2+=nums[i];
        }

        return count1 - count2;
    }

    public static void main(String[] args) {
        System.out.println(5%6);
    }
}

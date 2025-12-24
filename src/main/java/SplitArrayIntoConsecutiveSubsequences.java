import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SplitArrayIntoConsecutiveSubsequences {

    public boolean isPossible(int[] nums) {


        int count=0;

        for (int i = 0; i < nums.length-1; i++) {
            int diff=nums[i+1]-nums[i];

            if(diff==1) count++;
        }

        if(count>=3) return true;
        return false;
    }
}

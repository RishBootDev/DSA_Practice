import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArithmeticSubarrays {

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {

        List<Boolean> ans=new ArrayList<>();

        for (int i = 0; i < l.length; i++) {
            List<Integer> list=new ArrayList<>();

            for(int j=l[i];j<=r[i];j++){
                list.add(nums[j]);
            }

            Collections.sort(list);

            if(list.size()==1) ans.add(true);
            else {
                int temp = list.get(1) - list.get(0);
                boolean flag = true;
                for (int j = 1; j < list.size() - 1; j++) {
                    if (list.get(i + 1) - list.get(i) != temp) {
                        flag = false;
                        break;
                    }
                }

                ans.add(flag);
            }
        }

        return ans;
    }
}

import java.util.ArrayList;
import java.util.List;

public class TriangularSumOfAnArray {

    public int triangularSum(int[] nums) {

        int temp = nums.length;
        List<Integer> list = new ArrayList<>();

        for(int x : nums) list.add(x);

        while(temp-->0) {

            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < list.size()-1; i++) {

                int sum = list.get(i) + list.get(i+1);
                res.add(sum);
            }
            list = res;
        }

        return list.getFirst();
    }
}

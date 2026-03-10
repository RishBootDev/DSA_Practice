import java.util.ArrayList;
import java.util.List;

public class TriangularSumInArray {

    public int triangularSum(int[] nums) {

        int temp = nums.length;
        List<Integer> list = new ArrayList<>();

        for(int x : nums) list.add(x);

        while(list.size() > 1) {

            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < list.size()-1; i++) {

                int sum = list.get(i) + list.get(i+1);
                res.add(sum);
            }
            list = res;
        }

        return list.getFirst();
    }


    // this version of the above problem is slightly optimized!!
        public int triangularSum2(int[] nums) {
            if (nums.length == 1) {
                return nums[0];
            }

            int n = nums.length;
            int[] newNums = new int[n - 1];


            for (int i = 0; i < n - 1; i++) {
                newNums[i] = (nums[i] + nums[i + 1]) % 10;
            }

            return triangularSum2(newNums);
        }
    }


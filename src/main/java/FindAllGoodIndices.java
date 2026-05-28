import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllGoodIndices {

        public List<Integer> goodIndices(int[] nums, int k) {

            int n = nums.length;
            int[] pre = new int[n];
            int[] suf = new int[n];

            pre[0] = 1;

            for (int i = 1; i < n; i++) {

                if (nums[i] <= nums[i - 1]) {
                    pre[i] = pre[i - 1] + 1;
                } else {
                    pre[i] = 1;
                }
            }

            suf[n - 1] = 1;

            for (int i = n - 2; i >= 0; i--) {

                if (nums[i] <= nums[i + 1]) {
                    suf[i] = suf[i + 1] + 1;
                } else {
                    suf[i] = 1;
                }
            }

            List<Integer> ans = new ArrayList<>();

            for (int i = k; i < n - k; i++) {

                if (pre[i - 1] >= k &&
                        suf[i + 1] >= k) {
                    ans.add(i);
                }
            }

            return ans;
        }

}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdvantageShuffle {

    public int[] advantageCount(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            Pair pair = new Pair(nums2[i], i);
            list.add(pair);
        }
        list.sort((a, b) -> a.dt - b.dt);

        int [] ans = new int[nums1.length];
        List<Integer> fill = new ArrayList<>();
        int j = 0;

        for (int k = 0; k < nums1.length; k++) {
            Pair pair = list.get(j);
            if(nums1[k] > pair.dt) {
                int idx = pair.idx;
                ans[idx] = nums1[k];
                j++;
            }else fill.add(nums1[k]);
        }

        int m = 0;
        for(int i = 0; i<nums1.length; i++) {
            if(ans[i] == 0) ans[i] = fill.get(m++);
        }

        System.out.println(Arrays.toString(ans));
        return ans;
    }

    static class Pair {
        int dt;
        int idx;

        public Pair(int dt, int idx) {
            this.dt = dt;
            this.idx = idx;
        }
    }
}

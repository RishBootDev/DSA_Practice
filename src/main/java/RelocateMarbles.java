import java.util.*;

public class RelocateMarbles {

    public List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {

        Set<Integer> set = new HashSet<>();
        for (int c : nums) {
            set.add(c);
        }

        for (int i = 0; i < moveFrom.length; i++) {
            set.remove(moveFrom[i]);
            set.add(moveTo[i]);
        }

        List<Integer> ans = new ArrayList<>();
        for(int x : set) ans.add(x);

        Collections.sort(ans);
        return ans;
    }
}

import java.util.ArrayList;
import java.util.List;

public class EliminationGame {

    public int lastRemaining(int n) {

        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        return helper(0, list).get(0);
    }

    public List<Integer> helper(int turn, List<Integer> nums) {

        if (nums.size() == 1) return nums;

        List<Integer> temp = new ArrayList<>();
        if (turn % 2 == 0) {
            for (int i = 1; i < nums.size(); i += 2) {
                temp.add(nums.get(i));
            }
        }
        else {
            int start;
            if (nums.size() % 2 == 0) {
                start = nums.size() - 2;
            } else {
                start = nums.size() - 1;
            }
            for (int i = start; i >= 0; i -= 2) {
                temp.add(0, nums.get(i));
            }
        }
        return helper(turn + 1, temp);
    }
}

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(n, 1, k, new ArrayList<>(), ans);
        return ans;
    }

    public void helper(int n, int i, int k, List<Integer> temp, List<List<Integer>> ans) {

        if(i > n) {
            ans.add(temp);
            return;
        }
        if(k == 0) {
            ans.add(temp);
            return;
        }
        // not take
        helper(n, i + 1, k, temp, ans);
        // take
        temp.add(i);
        helper(n, i + 1, k - 1, temp, ans);
        temp.removeLast();
    }


}

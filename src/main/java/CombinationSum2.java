import java.util.*;

public class CombinationSum2 {

    Set<List<Integer>> ans;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.ans = new HashSet<>();
        Arrays.sort(candidates);
        helper(new ArrayList<>(), 0, candidates, target);
        return new ArrayList<>(ans);
    }
    public void helper(List<Integer> list, int i, int cc[], int target) {
        if(i == cc.length) {
            if(target == 0) {
                ans.add(new ArrayList<>(list));
                list.clear();
            }
            return;
        }

        if(target < 0) return;
        // take
        list.add(cc[i]);
        helper(list, i + 1, cc, target - cc[i]);
        list.removeLast();

        // not take
        helper(list, i + 1, cc, target);
    }
    public static void main(String[] args) {

    }
}

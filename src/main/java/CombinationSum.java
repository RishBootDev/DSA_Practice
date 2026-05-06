import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    private List<List<Integer>> ans;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        helper(candidates, 0, target, new ArrayList<>());
        return ans;
    }

    public void helper(int arr[], int idx, int target, List<Integer> temp) {

        if(target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        if(target < 0) return;

        for (int i = idx; i < arr.length; i++) {
            temp.add(arr[i]);
            helper(arr, i, target - arr[i], temp);
            temp.removeLast();
        }
    }
}

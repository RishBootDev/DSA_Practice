import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
         return helper(numRows, list);

    }
    public List<List<Integer>> helper(int num, List<List<Integer>> ans) {

        if(num == 1) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            ans.add(list);
            return ans;
        }

        if(num == 2) {
            List<Integer> list1 = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();
            list1.add(1);
            ans.add(list1);
            list2.addFirst(1);
            list2.addLast(1);
            ans.add(list2);
            return ans;
        }
        List<List<Integer>> list = helper(num - 1, ans);
        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        for (int i = 0; i < list.getLast().size() - 1; i++) {
            temp.add(list.getLast().get(i) + list.getLast().get(i + 1));
        }
        temp.add(1);
        ans.add(temp);
        return ans;
    }
}

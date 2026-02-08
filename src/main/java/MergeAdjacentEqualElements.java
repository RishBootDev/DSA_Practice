import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class MergeAdjacentEqualElements {

    public List<Long> mergeAdjacent(int[] nums) {
        ArrayDeque<Long> st = new ArrayDeque<>();

        for (int x : nums) {
            long num = x;
            while (!st.isEmpty() && st.peekLast() == num)
                num += st.pollLast();
            st.addLast(num);
        }

        return new ArrayList<>(st);
    }
}

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PathInZigzagLabelledBinaryTree {

    public List<Integer> pathInZigZagTree(int label) {

        List<List<Integer>> levels = new ArrayList<>();

        int level = 1;
        int current = 1;

        while (true) {
            int size = (int)Math.pow(2, level - 1);
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                list.add(current++);
            }

            if (level % 2 == 0) {
                Collections.reverse(list);
            }

            levels.add(list);

            if (list.contains(label)) break;
            level++;
        }

        List<Integer> result = new ArrayList<>();

        int currLabel = label;

        for (int l = levels.size() - 1; l >= 0; l--) {
            List<Integer> currLevel = levels.get(l);
            result.add(currLabel);

            int index = currLevel.indexOf(currLabel);

            if (l == 0) break;

            List<Integer> parentLevel = levels.get(l - 1);
            currLabel = parentLevel.get(index / 2);
        }

        Collections.reverse(result);
        return result;
    }
}

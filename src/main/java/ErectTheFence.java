import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ErectTheFence {

    public int[][] outerTrees(int[][] trees) {

        Set<List<Integer>> left = new HashSet<>();
        Set<List<Integer>> right = new HashSet<>();
        Set<List<Integer>> up = new HashSet<>();
        Set<List<Integer>> down = new HashSet<>();

        int minx = Integer.MAX_VALUE;
        int maxx = Integer.MIN_VALUE;
        int miny = Integer.MAX_VALUE;
        int maxy = Integer.MIN_VALUE;

        for(int tree[] : trees) {
            int x = tree[0];
            int y = tree[1];
            minx = Math.min(x, minx);
            miny = Math.min(y, miny);
            maxx = Math.max(x, maxx);
            maxy = Math.max(y, maxy);
        }
        for(int tree[] : trees) {
            int x = tree[0];
            int y = tree[1];
            List<Integer> tr = new ArrayList<>();
            tr.add(x);
            tr.add(y);

            if(minx == x) left.add(tr);
            else if(miny == y) right.add(tr);
            else if (maxx == x) up.add(tr);
            else if (maxx == y) down.add(tr);
        }

        System.out.println(left);
        System.out.println(right);
        System.out.println(up);
        System.out.println(down);

        return new int[1][1];

    }
}

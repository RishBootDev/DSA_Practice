import java.util.*;

public class HIndex {

    public int hIndex(int[] arr) {

        List<Integer> list = new ArrayList<>();
        for (int x : arr) list.add(x);

        list.sort(Collections.reverseOrder());

        for (int i = 0; i < arr.length; i++) {
            if (list.get(i) < i + 1) return i;
        }

        return arr.length;
    }
}

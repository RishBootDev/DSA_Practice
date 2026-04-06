import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QueriesOnPermutation {

    public int[] processQueries(int[] queries, int m) {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            list.add(i + 1);
        }

        int ans [] = new int[queries.length];
        int i = 0;

        for(int x : queries) {
            int idx = getIndex(list, x);
            ans[i++] = idx;
            removeAndAddFirst(list, x);
        }
        return ans;

    }

    public void removeAndAddFirst(List<Integer> list, int key) {

        Iterator<Integer> iterator = list.iterator();

        while(iterator.hasNext()) {
            int el = iterator.next();
            if(el == key) {
                iterator.remove();
                break;
            }
        }
        list.addFirst(key);
    }

    public int getIndex(List<Integer> list, int key) {
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) == key) return i;
        }

        return -1;
    }
}

import java.util.Arrays;
import java.util.HashMap;

public class SortRelated {

    static void relativeSort(int[] a1, int[] a2) {
        // code here
        HashMap<Integer, Integer> map = new HashMap<>();
        int a1Index = 0;
        for(int i : a1){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for(int i : a2){
            while(map.containsKey(i)){
                a1[a1Index++] = i;
                map.put(i, map.getOrDefault(i, 0) - 1);
                if(map.get(i) == 0) map.remove(i);
            }
        }
        int index = a1Index;
        for(int key : map.keySet()){
            while(map.get(key) != 0){
                a1[a1Index++] = key;
                map.put(key, map.get(key) - 1);
            }
        }
        Arrays.sort(a1,index,a1.length);
    }
}

import java.util.*;

public class MissingNumbers {

    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {

        Map<Integer,Integer> map=new HashMap<>();
        Map<Integer,Integer> temp=new HashMap<>();

        for (int i = 0; i < brr.size(); i++) {
            map.put(brr.get(i),map.getOrDefault(brr.get(i),0)+1);
        }

        for (int i = 0; i < arr.size(); i++) {
            temp.put(arr.get(i),temp.getOrDefault(arr.get(i),0)+1);
        }

        List<Integer> list=new ArrayList<>();

        for (Map.Entry<Integer, Integer> ent : map.entrySet()) {
            int num = ent.getKey();
            int freqB = ent.getValue();
            int freqA = temp.getOrDefault(num, 0);

            if (freqB > freqA) {
                list.add(num);
            }
        }
        Collections.sort(list);
        return list;
    }
}

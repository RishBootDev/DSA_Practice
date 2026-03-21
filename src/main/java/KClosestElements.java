import java.util.*;

public class KClosestElements {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {


        Comparator<Integer> com = (o1, o2) -> {
            int diff = Math.abs(o1 - x) - Math.abs(o2 - x);
            return (diff == 0) ? (o1 - o2) : diff;
        };

        PriorityQueue<Integer> pq=new PriorityQueue<>(com);

        for(int i=0;i<arr.length;i++){
            pq.add(arr[i]);
        }

        System.out.println(pq);

        List<Integer> list=new ArrayList<>();
        while(k-->0){

            list.add(pq.poll());
        }
        Collections.sort(list);
        return list;
    }
}

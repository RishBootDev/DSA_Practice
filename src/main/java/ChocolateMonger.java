import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ChocolateMonger {

    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int a = sc.nextInt();
            int k = sc.nextInt();
            int arr[] = new int[a];
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
                map.put(arr[i], map.getOrDefault(arr[i], 0)+ 1);
            }
            PriorityQueue<Integer> pq = new PriorityQueue<>(
                    (k1, k2) -> map.get(k2) - map.get(k1)
            );

            pq.addAll(map.keySet());

            while(k -- > 0 && !pq.isEmpty()) {
                int temp = pq.poll();
                int value = map.get(temp);
                value--;
                if(value != 0) {
                    map.put(temp, value);
                    pq.add(temp);

                }else map.remove(temp);
            }
            System.out.println(map.size());

        }
    }
}

import java.util.HashMap;
import java.util.Map;

public class MinimumSwapsUniqueIdentical {

    public static int makeIdentical(int arr[], int barr[]) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }

        int swap = 0;
        for (int i = 0; i < barr.length; i++) {

            if(barr[i] != arr[i]) {
                int temp = barr[i];
                barr[i] = barr[map.get(barr[i])];
                barr[map.get(temp)] = temp;
                swap++;

                i--;
            }
        }

        return swap;
    }
}

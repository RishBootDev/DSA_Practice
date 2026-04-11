import java.util.*;

public class MinimumSwapsToSortArray {

    public static int minSwaps(int arr[]) {

        int[] barr = arr.clone();
        Arrays.sort(barr);

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }

        int count = 0;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] != barr[i]) {

                int correctValue = barr[i];
                int idx = map.get(correctValue);

                int temp = arr[i];
                arr[i] = arr[idx];
                arr[idx] = temp;

                map.put(arr[i], i);
                map.put(arr[idx], idx);

                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int arr[] = {32524 ,30965, 30657, 18612, 29956, 15628, 16059, 10826, 23546, 22340};
        System.out.println(minSwaps(arr));
    }
}
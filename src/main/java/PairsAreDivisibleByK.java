import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PairsAreDivisibleByK {

    public static boolean canArrange(int[] arr, int k) {

        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : arr) {
            int rem = ((num%k)+k)%k;
            System.out.println(" the number is "+num + " and the remainder is "+rem);
            freq.put(rem, freq.getOrDefault(rem, 0) + 1);
        }

        List<Integer> list = new ArrayList<>(freq.values());

        for(int x : list) {
            if(x % 2 == 1) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,10,6,7,8,9};
        int barr[] = {1,2,3,4,5,6};
        canArrange(barr,5);
        System.out.println(9);
    }
}

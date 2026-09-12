import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class DivisibleSubset {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int a = sc.nextInt();
            int arr[] = new int[a];

            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
            }

            System.out.println(helper(arr, 0, new ArrayList<>(), 0));
        }
    }

    public static List<Integer> helper(int arr[], int i, List<Integer> temp, int sum) {

        if (i == arr.length) {
            if (!temp.isEmpty() && sum % arr.length == 0) {
                return temp;
            }
            return List.of(-1);
        }
        // take
        temp.add(i);
        List<Integer> l1 = helper(arr, i + 1, temp, sum + arr[i]);
        temp.removeLast();
        // not take
        List<Integer> l2 = helper(arr, i + 1, temp, sum);

        if(l1.equals(l2) && l1.getFirst().equals(-1)) return List.of(-1);
        if(!l1.getFirst().equals(-1)) return l1;
        return l2;
    }


}
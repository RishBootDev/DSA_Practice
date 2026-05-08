import java.util.Scanner;

// this a codechef problem 4 star rated
public class SubsetMinMax {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int x = sc.nextInt();

        int arr[] = new int[a];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        String str = sc.next();

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                min = Math.min(arr[i], min);
                max = Math.max(arr[i], max);
            }
        }

        long ans = 0;

        if (min != Integer.MAX_VALUE) {
            ans = 1L * min * max;
        }

        for (int i = 0; i < a; i++) {
            if (str.charAt(i) == '1' && arr[i] == min) {

                int newMin = Integer.MAX_VALUE;
                int newMax = Integer.MIN_VALUE;

                for (int j = 0; j < a; j++) {
                    if (i != j && str.charAt(j) == '1') {
                        newMin = Math.min(newMin, arr[j]);
                        newMax = Math.max(newMax, arr[j]);
                    }
                }

                if (newMin == Integer.MAX_VALUE) {
                    ans = Math.max(ans, 1L * max * max - x);
                }
                else {
                    ans = Math.max(ans, 1L * newMin * newMax - x);
                }
            }
        }

        for (int i = 0; i < a; i++) {

            if (str.charAt(i) == '0') {
                int newMin = min;
                int newMax = max;

                if (min == Integer.MAX_VALUE) {
                    newMin = arr[i];
                    newMax = arr[i];
                }
                else {
                    newMin = Math.min(newMin, arr[i]);
                    newMax = Math.max(newMax, arr[i]);
                }

                ans = Math.max(ans, 1L * newMin * newMax - x);
            }
        }

        System.out.println(ans);
    }
}
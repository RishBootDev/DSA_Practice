import java.util.*;

public class TripleThreat {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();
            int x = sc.nextInt();

            char[] a = new char[3 * n];
            Arrays.fill(a, '0');

            int k = Math.max(0, (x - n + 1) / 2);
            int z = n - k;

            for (int i = 0; i < z && x > 0; i++) {
                a[i] = '1';
                x--;
            }

            for (int i = n - 1; i >= z; i--) {
                a[i] = '1';
                a[i + n] = '1';
                x -= 2;
            }

            for (int i = n - 1; i >= z && x > 0; i--) {
                a[i + 2 * n] = '1';
                x--;
            }

            System.out.println(new String(a));
        }
    }
}
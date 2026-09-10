import java.util.Scanner;

public class GridJump {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t -- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            int p = sc.nextInt();
            int q = sc.nextInt();
            int r = sc.nextInt();
            System.out.println(helper(0, 0, a, b, p, q, r));
        }
    }
    public static int helper(int i , int j, int a, int b , int p , int q , int r) {
        if(i == a && j == b) {
            return 0;
        }
        if(i > b || j > a) return Integer.MAX_VALUE;

        // path 1
        int first = helper(i + 1, j, a, b, p, q, r) + p;
        int second = helper(i + 2, j , a, b, p, q, r) + p;

        // path 2
        int third = helper(i, j + 1, a, b, p, q, r) + q;
        int fourth = helper(i, j + 2 , a, b, p, q, r) + q;

        // path 3
        int fifth = helper(i + 1, j + 1, a, b, p, q, r) + r;
        return Math.min(first, Math.max(second, Math.min(third, Math.min(fourth, fifth))));
    }
}

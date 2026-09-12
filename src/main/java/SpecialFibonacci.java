import java.util.Scanner;

public class SpecialFibonacci {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int t = sc.nextInt();

        while(t-- > 0 && sc.hasNextInt()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int n = sc.nextInt();
            System.out.println(fib(n, a, b));
        }
    }
    public static int fib(int n, int a, int b) {
        if(n == 0) return a;
        if(n == 1) return b;

        return  fib(n-1, a, b) ^ fib(n-2, a, b);
    }
}

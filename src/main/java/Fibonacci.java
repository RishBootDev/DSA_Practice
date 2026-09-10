import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fibonacci {

    public static int fib(int n) {
        if(n == 0 || n == 1) return n;
        return fib(n - 2) + fib(n - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(bf.readLine().split(" ")[0]);

        System.out.println(a);
        for (int i = 0; i < a; i++) {
            System.out.println(fib(i));
        }

        System.out.println(" printing using fibonacci loop ");
        fibloop(5);
    }

    public static void fibloop(int n) {

        int a = 0;
        int b = 1;
        for (int i = 0; i < n; i++) {
            System.out.println(a);
            int c = a + b;
            a = b;
            b = c;
        }
    }
}

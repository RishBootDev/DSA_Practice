import java.util.Scanner;

public class MinimumNumberOfPizzas {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int count = 0;
            while(b % a != 0) {
                b += b;
                count++;
            }
            System.out.println(count);
        }

    }
}

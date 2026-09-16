import java.util.Scanner;

public class AvoidFixedPoints {

    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         int t = sc.nextInt();
         while(t--> 0) {
             int a = sc.nextInt();
             int arr[] = new int[a];
             for (int i = 0; i < a; i++) {
                 arr[i] = sc.nextInt();
             }
             int count = 0;
             int temp = 1;
             for (int i = 0; i < a; i++) {
                 if(arr[i] == temp) {
                     count++;
                     temp++;
                 }
                 temp++;
             }
             System.out.println(count);
         }
    }
}

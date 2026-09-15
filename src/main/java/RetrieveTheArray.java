import java.util.Scanner;

public class RetrieveTheArray {

    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t --> 0) {
            int a = sc.nextInt();
            int arr[] = new int[a];
            int sum = 0;
            for (int i = 0; i < a; i++) {
                arr[i] = sc.nextInt();
                sum += arr[i];
            }
            int ans[] = new int[a];
            int bum = sum / (a + 1);
            for (int i = 0; i < a; i++) {
                ans[i] = arr[i] - bum;
            }
            System.out.println(ans);
        }

    }
}

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AverageFlex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t= sc.nextInt();
        while(t --> 0) {
            int a = sc.nextInt();
            int arr[] = new int[a];
            for (int i = 0; i < a; i++) {
                arr[i] = sc.nextInt();
            }
            int ans = 0;

            for (int i = 0; i < arr.length; i++) {
                int count1 = 0;
                int count2 = 0;
                for (int j = 0; j < arr.length; j++) {
                    if(arr[i] <= arr[j]) count1++;
                    else count2++;
                }
                if(count2 < count1) ans++;
            }

            System.out.println(ans);
        }

    }
}

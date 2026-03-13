import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class SumNotEqual {


    static class Pair {
        int val, idx;
        Pair(int v, int i){
            val = v;
            idx = i;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0){

            int n = sc.nextInt();
            Pair[] arr = new Pair[n];

            boolean allZero = true;

            for(int i=0;i<n;i++){
                int x = sc.nextInt();
                arr[i] = new Pair(x, i+1);
                if(x != 0) allZero = false;
            }

            if(allZero){
                System.out.println(-1);
                continue;
            }

            Arrays.sort(arr, Comparator.comparingInt(a -> a.val));
            int i = arr[n-1].idx;
            int j = arr[n-2].idx;
            int k = arr[0].idx;

            System.out.println(i + " " + j + " " + k);
        }


    }

    public static long getWays(int n, List<Long> c) {

        long[] dp = new long[n + 1];
        dp[0] = 1;

        for (long coin : c) {
            for (int i = (int) coin; i <= n; i++) {
                dp[i] += dp[Math.toIntExact(i - coin)];
            }
        }

        return dp[n];
    }
}

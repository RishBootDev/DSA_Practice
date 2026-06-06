import java.util.Arrays;

public class BulbSwitch {


    // first starting the bruteforce approach
    public int bulbSwitch(int n) {
        int arr [] = new int[n];
        Arrays.fill(arr, 1);

        for (int i = 2; i <= n ; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(j % i == 0) {
                    if(arr[j] == 1) arr[j] = 0;
                    else arr[j] = 0;
                }
            }
        }

        int ans = 0;
        for(int c : arr) {
            if(c == 1) ans ++;
        }
        return ans;
    }

    public static void main(String[] args) {
        
    }
}

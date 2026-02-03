import java.util.Arrays;

public class MaximumNumberOfCoins {


    public int maxCoins(int[] piles) {

        Arrays.sort(piles);

        int i = 0;
        int j = piles.length;
        int ans = 0;

        while(i<j){
            i++;
            j-=2;

            ans += piles[j];

        }
        return ans;
    }

}

import java.util.Arrays;

public class MaximumPointsAfterEnemyBattles {

    public long maximumPoints(int[] en, int curr) {

        int point = 0;
        Arrays.sort(en);
        int left = 0;
        int right = curr;

        while(right < left) {
            if(en[right] <= curr) {
                point ++;
                curr += en[right];
                right++;
            }else {
                curr += en[left];
                left --;
            }
        }
        return point;
    }
}

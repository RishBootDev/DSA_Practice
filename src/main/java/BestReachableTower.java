import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


// this approach solved the question efficiently
public class BestReachableTower {

    public int[] bestTower(int[][] towers, int[] center, int radius) {
        Arrays.sort(towers,(a, b)->{
            if (a[2]!=b[2])return Integer.compare(b[2],a[2]);
            if (a[0]!=b[0]) return Integer.compare(a[0],b[0]);
            return Integer.compare(a[1],b[1]);
        });

        for(int i=0;i<towers.length;i++){
            if((Math.abs(towers[i][0]-center[0])+Math.abs(towers[i][1]-center[1]))<=radius){
                return new int[]{towers[i][0],towers[i][1]};
            }
        }
        return new int[]{-1,-1};
    }
}

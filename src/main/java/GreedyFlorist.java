import java.util.Arrays;

public class GreedyFlorist {

    public static int getMinimumCost(int k, int[] c) {

        Arrays.sort(c);
        int sum=0;
        int j=0;
        int temp=0;

        for(int i=c.length-1;i>=0;i--){

            if(temp==k){
                j++;
                temp=0;
            }

            sum+= (c[i]*(j+1));
            temp++;

        }

        return sum;
    }
}

import java.util.Arrays;

public class MinIncrements {

    public int minIncrements(int[] arr) {
        // Code here
        Arrays.sort(arr);
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {

            if(arr[i+1] == arr[i]){
                arr[i+1]+=1;
                count++;
            }else if(arr[i+1] < arr[i]){
                count+=arr[i]-arr[i+1];
                arr[i+1] = arr[i]+1;
                count++;
            }

        }

        return count;

    }
}

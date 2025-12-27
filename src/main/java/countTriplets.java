import java.util.Arrays;

public class countTriplets {
    public long countTriplets1(int n, int sum, long arr[]) {

        long count = 0;

        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                for(int k=j+1;k<arr.length;k++){

                    if(arr[i]+arr[j]+arr[k] < sum) count++;
                }
            }
        }
        return count;
    }

    public long countTriplets2(int n, int sum, long arr[]){

        Arrays.sort(arr);
        long count = 0;

        for (int i = 0; i < n-2; i++) {

            int j=i+1;
            int k=arr.length-1;

            while(j<k){
                if(arr[i] + arr[j] + arr[k]>=sum){
                    k--;
                }else{
                    count += k-j;
                    j++;
                }
            }
        }
        return count;
    }
}

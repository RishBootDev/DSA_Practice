import java.util.Arrays;

public class MaxTripletProduct {
    public Long maxTripletProduct(Long arr[], int n)
    {

        Arrays.sort(arr);

        return (long)Math.max(arr[0]*arr[1]*arr[arr.length-1],arr[arr.length-1]*arr[arr.length-2]*arr[arr.length-3]);
    }
}

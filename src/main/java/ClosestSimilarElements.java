public class ClosestSimilarElements {

    public static boolean closestSimilarElements(int n, int[] arr, int in,
                                                 int v) {
        // code here
        int i=0,j=n-1;
        while(i<j){
            if(i-j <=in && arr[i]-arr[j] <= v){
                return true;
            }
            else{
                i++;
                j--;
            }
        }return false;
    }
}

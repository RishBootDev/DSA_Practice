class Solution {
    public int maxProduct(int[] arr) {
       int max=Integer.MIN_VALUE;
       int temp=0;
       for(int i=0;i<arr.length;i++){
          if(arr[i]>max){
            max=arr[i];
            temp=i;
          }
       }
       int smax=Integer.MIN_VALUE;
       for(int i=0;i<arr.length;i++){
          if(arr[i]>smax && i!=temp){
            smax=arr[i];
          }
       }
       return (max-1)*(smax-1);
    }
}
class Solution {
    public void rotate(int[][] matrix) {
        int l=0,h=0;
        int arr[][]=new int[matrix.length][matrix[0].length];
         for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                arr[i][j]=matrix[i][j];
            }
         }
         for(int i=0;i<arr.length;i++){
            for(int j=arr[i].length-1;j>=0;j--){
                matrix[l][h]=arr[j][i];
                System.out.print(arr[j][i]+" ");
                h++;
            }
            h=0;
            l++;
            System.out.println();
        }
        
    }
}
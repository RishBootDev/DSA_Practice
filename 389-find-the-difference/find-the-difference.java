class Solution {
    public char findTheDifference(String s, String t) {
        
        char[] arr=s.toCharArray();
        char[] barr=t.toCharArray();

        Arrays.sort(arr);
        Arrays.sort(barr);

        for(int i=0;i<barr.length-1;i++){
            if(barr[i]!=arr[i])  return barr[i];
        }


        return barr[barr.length-1];


        
    }
}
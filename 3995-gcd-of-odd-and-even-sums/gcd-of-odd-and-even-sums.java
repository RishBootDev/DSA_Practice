class Solution {
    public int gcdOfOddEvenSums(int n) {
        
        int a = n*n;
        int b = n*(n+1);

        System.out.println(a + " " + b);
        return gcd(a, b);
    }

     public int gcd(int a, int b) {
        if(b == 0) return a;

        return gcd(b, a % b);
     }
}
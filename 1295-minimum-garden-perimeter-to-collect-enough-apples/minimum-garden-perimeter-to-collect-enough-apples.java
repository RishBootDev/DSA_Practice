class Solution {
    
    public long minimumPerimeter(long neededApples) {

        long temp = 12;
        long pem = 1;

        while(temp < neededApples) {
            pem ++ ;
            temp = (2*pem) * (pem + 1) * (2 * pem + 1);
        }
        return 8*pem;
    }
}
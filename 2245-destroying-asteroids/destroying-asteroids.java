class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {

         Arrays.sort(asteroids);
         long mas = (long)mass;

         for(int i=0; i<asteroids.length; i++){
             if(asteroids[i] > mas){
                 return false;
             }
             else {
                 mas += asteroids[i];
             }
         }
         return true;        
    }
}
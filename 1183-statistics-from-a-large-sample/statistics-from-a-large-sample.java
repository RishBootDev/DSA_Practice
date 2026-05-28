class Solution {
    public double[] sampleStats(int[] count) {
        int len = count.length;

        int large = Integer.MIN_VALUE;
        int small = Integer.MAX_VALUE;
        long ttl = 0;
        long sz = 0;
        int frq = 0;
        int unq = 0;
        for(int i = 0;i < len;i++){
            if(count[i] != 0){
                large = Math.max(large, i);
                small = Math.min(small, i);
            }
            ttl += ((long) count[i] *i);
            sz += count[i];
            if(frq < count[i]){
                frq = count[i];
                unq = i;
            }
        }

        double avg = (double) ttl /sz;
        long temp = 0;
        double med = 0;
        boolean even = sz%2 == 0;
        for(int i = 0;i < len;i++){
            temp += count[i];
            if(even && temp == sz/2){
                med += i;
                i++;
                while(i < len){
                    if(count[i] != 0){
                        med += i;
                        break;
                    }
                    i++;
                }
                med /= 2;
                break;
            }
            else if(temp > sz/2) {
                med = i;
                break;
            }
        }

        double[] ans = {small, large, avg, med, unq};
        return ans;
    }
}




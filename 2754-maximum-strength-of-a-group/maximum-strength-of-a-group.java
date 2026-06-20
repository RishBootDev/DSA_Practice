class Solution {
    public long maxStrength(int[] nums) {
        
        ArrayList<Integer> positive = new ArrayList<>();
        ArrayList<Integer> negative = new ArrayList<>();
        
       for(int x : nums){
        if(x > 0) positive.add(x);
        else if(x < 0) negative.add(x);
       }     

       negative.sort((a,b) -> Math.abs(a) - Math.abs(b));

       if(negative.size() % 2 != 0){
        negative.remove(0);
       }

       if(positive.isEmpty() && negative.isEmpty()){
        int m = nums[0];
        for(int x : nums){
            m = Math.max(m,x);
            
        }
        return m; 

       }

        long product = 1;
        for(int x : positive){
            product = product * x;
        }
        for(int x : negative){
            product = product *x;
        }

        return product;
   
    }
}
class Solution {

    Long dp [];
    
     public long mostPoints(int[][] questions) {
        dp = new Long[questions.length];
       return helper(questions, 0);
    }
    
    public long helper(int [][] ques, int i) {
        if(i >= ques.length) return 0;

        if(dp[i] != null) return dp[i];
        
        // take
        long take = helper(ques, i + ques[i][1] + 1) + ques[i][0];
        
        // not take 
        long not = helper(ques, i + 1);
        
        return dp[i] = Math.max(take, not);
    }
}
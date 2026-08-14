class Solution {
    
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {

        boolean check[] = new boolean[mentors.length];
        return helper(students, mentors, 0, check);
    }
    
    public int helper(int [][] stud, int [][] ment, int i, boolean check[]) {

        if(i == stud.length) return 0;
        int ans = 0;
        for (int j = 0; j < ment.length; j++) {
            
            if(!check[j]) {
                int count = 0;
                for (int k = 0; k < stud[i].length; k++) {
                    if (stud[i][k] == ment[j][k]) count++;
                }
                check[j] = true;
                int current = count + helper(stud, ment, i + 1, check);
                ans = Math.max(ans, current);
                check[j] = false;
            }
        }
        return ans;
    }

    
}
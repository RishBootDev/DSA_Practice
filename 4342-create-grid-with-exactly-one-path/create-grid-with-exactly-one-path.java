class Solution {
    public String[] createGrid(int m, int n) {

        String [] ans = new String[m];
        if( m == 1) {
            char [] row = new char[n];
            Arrays.fill(row, '.');
            ans[0] = new String(row);
            return ans;
        }

        if(n == 1) {
            for(int i = 0; i< m; i++) {
                ans[i] = ".";
            }
            return ans;
        }
        for(int i = 0; i< m; i++) {
            char [] row = new char[n];
            for(int j = 0; j< n; j++) {
                if(i == 0 || j == n-1) row[j] = '.';
                else row[j] = '#';
            }
        
        ans[i] = new String(row);
        }
    
    return ans;
    }
}
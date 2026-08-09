class Solution {
    public int maxArea(int[][] a) {

        int m = a.length;
        int n = a[0].length;

        int [][]p = new int[m + 1][n + 1];
        for(int i = 0; i < m ; i++) {
            for(int j = 0; j < n; j++) {
                p[i + 1][j + 1] = a[i][j] + p[i][j + 1] + p[i + 1][j] - p[i][j];
            }
        }

        int l = 1;
        int r = Math.min(m, n);
        int ans = 0;
        while(l <= r) {
            int k = (l + r) /2;

            int r1 = m;
            int r2 = -1;
            int c1 = n;
            int c2 = -1;

            boolean temp = false;

            for(int i = 0; i + k <= m && !temp; i++) {
                for(int j = 0; j + k <= n; j++) {
                    int sum = p[i + k][j + k] - p[i][j + k] - p[i + k][j] + p[i][j];

                    if(sum == k * k) {
                        if(i - r1 >= k || r2 - i >= k || j - c1 >= k || c2 - j >= k) {
                            temp = true;
                            break;
                        }

                        r1= Math.min(r1, i);
                        r2 = Math.max(r2, i);
                        c1 = Math.min(c1, j);
                        c2 = Math.max(c2, j);
                    }
                }
            }

            if(temp) {
                ans = k * k;
                l = k + 1;
            }else {
                r = k - 1;
            }
        }

            return ans;
        }
        
    
}
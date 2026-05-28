class Solution {

    public int[] executeInstructions(int n, int[] startPos, String s) {

        int[] ans = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {

            int x = startPos[0];
            int y = startPos[1];

            int count = 0;
            for (int j = i; j < s.length(); j++) {

                char ch = s.charAt(j);

                if (ch == 'L') {
                    y--;
                } else if (ch == 'R') {
                    y++;
                } else if (ch == 'U') {
                    x--;
                } else {
                    x++;
                }
                if (x < 0 || x >= n || y < 0 || y >= n) {
                    break;
                }
                count++;
            }
            ans[i] = count;
        }
        return ans;
    }
}
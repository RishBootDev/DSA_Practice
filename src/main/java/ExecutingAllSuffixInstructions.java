public class ExecutingAllSuffixInstructions {

    public int[] executeInstructions(int n, int[] startPos, String s) {

        int x = startPos[0];
        int y = startPos[1];
        int ans [] = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {

            int count = 0;
            for (int j = i; j < s.length(); j++) {
                if(s.charAt(j) =='L' && x - 1 >= 0) {
                    x--;
                    count++;
                }else if (s.charAt(j) == 'D' && y + 1 < n){
                    y++;
                    count++;
                }else if (s.charAt(j) =='R' && x + 1 < n) {
                    x++;
                    count++;
                }
                else if (s.charAt(j) =='U' && y - 1 >= 0) {
                    y--;
                    count++;
                }else {
                    break;
                }
            }
            ans[i] = count;
        }
        return ans;
    }
}

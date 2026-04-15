public class BlackAndWhiteBallsSeparate {

    public long minimumSteps(String s) {

        int j = s.length() - 1;
        long ans = 0;
        for (int i = s.length() - 1; i >= 0 ; i--) {

            if(s.charAt(i) =='1') {
                ans += (j - i);
                j--;
            }
        }

        return ans;
    }
}

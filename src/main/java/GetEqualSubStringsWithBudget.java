public class GetEqualSubStringsWithBudget {

    public int equalSubstring(String s, String t, int maxCost) {

       int left = 0;
       int temp = 0;
       int max = 0;

       for (int right = 0; right < s.length(); right++) {
           temp += Math.abs(s.charAt(right) - t.charAt(right));

           while(temp > maxCost) {
               int score = Math.abs(s.charAt(left) - t.charAt(left));
               temp -= score;
           }

           max = Math.max(max, right - left);

       }

       return max;
    }
}

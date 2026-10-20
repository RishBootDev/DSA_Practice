class Solution {
    public int punishmentNumber(int n) {

        int ans = 0;
        for (int i = 1; i <= n ; i++) {
            int sq = i * i;
            if(helper(String.valueOf(sq), 0, 0, new StringBuilder()))  ans += sq;
        }
        return ans;
    }

    public boolean helper(String str, int i, int sum, StringBuilder sb) {
        if(i == str.length()) {
            if(!sb.isEmpty()) sum += Integer.parseInt(sb.toString());
           // System.out.println(str + " -> " + sum);
            if((int)Math.sqrt(Integer.parseInt(str)) == sum) return true;
            return false;
        }

        sb.append(str.charAt(i));
        boolean first = helper(str, i + 1, sum, sb);
        boolean second = helper(str, i + 1, sum + Integer.parseInt(sb.toString()), new StringBuilder());
        sb.deleteCharAt(sb.length() - 1);
        return first || second;
    }
}
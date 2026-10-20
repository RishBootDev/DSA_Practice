class Solution {
    

    List<String> ans;
    public String getHappyString(int n, int k) {
        this.ans = new ArrayList<>();
        helper(new StringBuilder(), n);
        System.out.println(ans);
        if(k > ans.size()) return "";
        return ans.get(k - 1);
    }
    public void helper(StringBuilder sb, int n) {
        if(sb.length() == n) {
            ans.add(sb.toString());
            return;
        }

        for (char ch = 'a'; ch < 'd'; ch++) {
            if(sb.isEmpty()) {
                sb.append(ch);
                helper(sb, n);
                sb.deleteCharAt(sb.length() - 1);
            }else {
                char prev = sb.charAt(sb.length() - 1);
                if(prev != ch) {
                    sb.append(ch);
                    helper(sb, n);
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
    }
}
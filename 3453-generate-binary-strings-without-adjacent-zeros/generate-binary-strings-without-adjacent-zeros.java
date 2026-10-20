class Solution {
   
   private List<String> ans;
    public List<String> validStrings(int n) {
        ans = new ArrayList<>();
        helper(n, new StringBuilder(), false);
        return ans;
    }
    public void helper(int n, StringBuilder sb, boolean flag) {
        if(sb.length() == n) {
            ans.add(sb.toString());
            return;
        }

        if(sb.isEmpty()) {
            sb.append(1);
            helper(n, sb, false);
            sb.deleteCharAt(sb.length() - 1);

            sb.append(0);
            helper(n, sb, true);
            sb.deleteCharAt(sb.length() - 1);
        }else {
            if (flag) {
                sb.append(1);
                helper(n, sb, false);
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(1);
                helper(n, sb, false);
                sb.deleteCharAt(sb.length() - 1);

                sb.append(0);
                helper(n, sb, true);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
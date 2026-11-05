class Solution {
    
    List<String> ans;
    public List<String> restoreIpAddresses(String s) {
        this.ans = new ArrayList<>();
        helper(s, 0, new StringBuilder());
        System.out.println(this.ans);
        return ans;
    }
    public void helper(String s, int i, StringBuilder sb) {
        if(i == s.length()) {
          //  System.out.println(sb);
            String [] arr = sb.toString().split("\\.");
            if(arr.length != 4) return;
            for(String str : arr) {
                if(str.length() > 1 && str.charAt(0) == '0') return;
                if(str.length() >= 10) return;
                int x = Integer.parseInt(str);
                if(x < 0 || x > 255) return;
            }
            ans.add(sb.toString());
            return;
        }

        // path 1
        sb.append(s.charAt(i));
        helper(s, i + 1, sb);
        sb.deleteCharAt(sb.length() - 1);

        // path2
        if(i != s.length() - 1) {
            sb.append(s.charAt(i)).append('.');
            helper(s, i + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
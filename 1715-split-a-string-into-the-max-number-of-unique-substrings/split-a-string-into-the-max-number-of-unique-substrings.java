class Solution {

    private Set<String> set;
    private int ans;

    public int maxUniqueSplit(String s) {
        this.set = new HashSet<>();
        this.ans = 0;
        helper(s, 0, new StringBuilder());
        return ans;
    }

    public void helper(String s, int i, StringBuilder sb) {

        if (i == s.length()) {
            if (!sb.isEmpty() && !set.contains(sb.toString())) {
                set.add(sb.toString());
                ans = Math.max(ans, set.size());
                set.remove(sb.toString());
            }
            return;
        }

        sb.append(s.charAt(i));
        helper(s, i + 1, sb);

        if (!set.contains(sb.toString())) {
            set.add(sb.toString());
            ans = Math.max(ans, set.size());
            helper(s, i + 1, new StringBuilder());
            set.remove(sb.toString());
        }
        sb.deleteCharAt(sb.length() - 1);
    }
}
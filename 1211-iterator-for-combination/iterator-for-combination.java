class CombinationIterator {

    List<String> ans;
    int k;
    int pointer ;
    public CombinationIterator(String characters, int combinationLength) {
        this.ans = new ArrayList<>();
        this.k = combinationLength;
        helper(characters, 0, new StringBuilder());
        System.out.println(ans);
        Collections.sort(ans);
        this.pointer = -1;
    }

    public String next() {
        if(pointer >= ans.size() - 1) return "";
        pointer++;
        return ans.get(pointer);
    }

    public boolean hasNext() {
        if(pointer >= ans.size() - 1) return false;
        return true;
    }

    public void helper(String str, int i, StringBuilder sb) {

        if (sb.length() > k) return;
        if(i == str.length()) {
            if (sb.length() == k) {
                ans.add(sb.toString());
            }
            return;
        }

        // take
        sb.append(str.charAt(i));
        helper(str, i + 1,sb);
        sb.deleteCharAt(sb.length() - 1);

        // not take
        helper(str, i + 1, sb);
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
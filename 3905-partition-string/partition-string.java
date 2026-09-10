class Solution {
    
    public List<String> partitionString(String s) {

        LinkedHashSet<String> set = new LinkedHashSet<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
             sb.append(s.charAt(i));
             if(!set.contains(sb.toString())) {
                 set.add(sb.toString());
                 sb = new StringBuilder();
             }
        }
        return new ArrayList<>(set);
    }
}
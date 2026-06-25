class Solution {

    public String replaceWords(List<String> dictionary, String sentence) {

        Set<String> set = new HashSet<>(dictionary);

        String[] words = sentence.split(" ");
        StringBuilder ans = new StringBuilder();

        for (String word : words) {
            String replace = word;
            for (int i = 1; i <= word.length(); i++) {
                String prefix = word.substring(0, i);
                if (set.contains(prefix)) {
                    replace = prefix;
                    break;
                }
            }
            ans.append(replace).append(" ");
        }
        return ans.toString().trim();
    }
}
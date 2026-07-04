class Solution {
    
    public String largestMerge(String word1, String word2) {

        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;
        int temp = word1.length() + word2.length();

        for (int k = 0; k < temp; k++) {
            if(i == word1.length() && j == word2.length()) {
                break;
            }else if (i == word1.length()) {
                sb.append(word2.charAt(j));
                j++;
            }else if (j == word2.length()){
                sb.append(word1.charAt(i));
                i++;
            }else {
               int cmp = word1.substring(i).compareTo(word2.substring(j));
               if(cmp > 0) {
                   sb.append(word1.charAt(i));
                   i++;
               }else {
                   sb.append(word2.charAt(j));
                   j++;
               }
            }
        }
        return sb.toString();
    }
}
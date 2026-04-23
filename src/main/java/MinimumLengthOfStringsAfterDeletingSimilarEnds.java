public class MinimumLengthOfStringsAfterDeletingSimilarEnds {

    public int minimumLength(String s) {

        int i = 0;
        int j = s.length() - 1;

        while (i < j && s.charAt(i) == s.charAt(j)) {

            char temp = s.charAt(i);
            while (i <= j && s.charAt(i) == temp) {
                i++;
            }
            while (i <= j && s.charAt(j) == temp) {
                j--;
            }
        }
        return j-i+1;
    }
}
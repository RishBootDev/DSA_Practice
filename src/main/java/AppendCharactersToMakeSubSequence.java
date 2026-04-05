public class AppendCharactersToMakeSubSequence {

    public static int appendCharacters(String s, String t) {

        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if(j < t.length() && s.charAt(i) == t.charAt(j)) j++;
        }

        return t.length()-j;
    }

    public static void main(String[] args) {
        System.out.println(appendCharacters("z", "abcde"));
    }
}

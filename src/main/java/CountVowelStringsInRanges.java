import java.util.Arrays;

public class CountVowelStringsInRanges {

    public int[] vowelStrings(String[] words, int[][] queries) {

        int pre[] = new int[words.length];
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            if(check(words[i])) {
                count++;
            }
            pre[i] = count;
        }
        System.out.println(Arrays.toString(pre));
        return pre;
    }
    public boolean check(String word) {
        char first = word.charAt(0);
        char second = word.charAt(word.length() - 1);

        if(first == 'a' || first == 'e' || first == 'i' || first == 'o' || first == 'u' &&
        second == 'a' || second == 'e' || second == 'i' || second == 'o' || second == 'u')
            return true;
        return false;
    }
}

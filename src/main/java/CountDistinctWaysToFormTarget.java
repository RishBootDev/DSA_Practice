public class CountDistinctWaysToFormTarget {

    public int interleaveCharacters(String word1, String word2, String target) {
        return helper(word1, word2, 0, 0, new StringBuilder(), target);
    }

    public int helper(String word1,
                      String word2,
                      int i, int j,
                      StringBuilder curr,
                      String target) {

        if (curr.toString().equals(target)) {
            if (i != 0 && j != 0)
                return 1;
            return 0;
        }

        if (i > word1.length() || j > word2.length()) {
            return 0;
        }

        int a = 0, b = 0, c = 0, d = 0, e = 0, f = 0, g = 0, h = 0, k = 0;

        // take from word1, take from word2
        if (i < word1.length() && j < word2.length()) {
            a = helper(word1, word2, i + 1, j + 1, curr.append(word1.charAt(i)).append(word2.charAt(j)), target);
            b = helper(word1, word2, i + 1, j + 1, curr.append(word2.charAt(j)).append(word1.charAt(i)), target);
        }

        // not take from both the strings
        c = helper(word1, word2, i + 1, j + 1, curr, target);

        if (i < word1.length())
            d = helper(word1, word2, i + 1, j, curr, target);

        if (j < word2.length())
            e = helper(word1, word2, i, j + 1, curr, target);

        // take from word1 but not from word2
        if (i < word1.length()) {
            f = helper(word1, word2, i + 1, j, curr.append(word1.charAt(i)), target);
            g = helper(word1, word2, i + 1, j + 1, curr.append(word1.charAt(i)), target);
        }

        // take from word2 but not from word1
        if (j < word2.length()) {
            h = helper(word1, word2, i, j + 1, curr.append(word2.charAt(j)), target);
            k = helper(word1, word2, i + 1, j + 1, curr.append(word2.charAt(j)), target);
        }

        return a + b + c + d + e + f + g + h + k;
    }
}

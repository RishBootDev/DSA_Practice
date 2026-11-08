class Solution {

    public int maxScoreWords(String[] words, char[] letters, int[] scores) {
        Map<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < letters.length; i++) {
            freq.put(letters[i], freq.getOrDefault(letters[i], 0) + 1);
        }
        return helper(words, 0, freq, scores);
    }

    public int helper(String[] words, int i, Map<Character, Integer> freq, int[] scores) {
        if (i == words.length) {
            return 0;
        }
        // take
        int take = 0;
        if (check(words[i], freq)) {
            for (int j = 0; j < words[i].length(); j++) {
                char ch = words[i].charAt(j);
                freq.put(ch, freq.get(ch) - 1);
            }
            take = helper(words, i + 1, freq, scores) + score(words[i], scores);
            for (int j = 0; j < words[i].length(); j++) {
                char ch = words[i].charAt(j);
                freq.put(ch, freq.get(ch) + 1);
            }
        }
        // not take
        int not = helper(words, i + 1, freq, scores);
        return Math.max(take, not);
    }

    public boolean check(String word, Map<Character, Integer> freq) {
        Map<Character, Integer> temp = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            temp.put(word.charAt(i), temp.getOrDefault(word.charAt(i), 0) + 1);
        }
        for (Map.Entry<Character, Integer> ent : temp.entrySet()) {
            char key = ent.getKey();
            int value = ent.getValue();
            if (!freq.containsKey(key))
                return false;
            if (value > freq.get(key))
                return false;
        }
        return true;
    }

    public int score(String word, int[] scores) {
        int ans = 0;
        for (int i = 0; i < word.length(); i++) {
            ans += scores[word.charAt(i) - 'a'];
        }
        return ans;
    }
}
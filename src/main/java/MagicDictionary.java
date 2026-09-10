public class MagicDictionary {

    String [] dict;
    public MagicDictionary() {

    }

    public void buildDict(String[] dictionary) {
         this.dict = dictionary;
    }

    public boolean search(String searchWord) {
        for(String w : dict) {
            if(check(w, searchWord)) return true;
        }
        return false;
    }
    public boolean check(String word1, String search) {
        int count = 0;
        for (int i = 0; i < word1.length(); i++) {
            if(word1.charAt(i) == search.charAt(i)) count++;
        }
        return count == word1.length() - 1;
    }
}

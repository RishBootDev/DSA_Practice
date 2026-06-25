class MagicDictionary {

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
        if(word1.length() != search.length()) return false;
        for (int i = 0; i < word1.length(); i++) {
            if(word1.charAt(i) == search.charAt(i)) count++;
        }
        return count == word1.length() - 1;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */
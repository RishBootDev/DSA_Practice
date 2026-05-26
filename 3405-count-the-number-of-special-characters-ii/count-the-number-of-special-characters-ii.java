class Solution {
    public int numberOfSpecialChars(String word) {
        
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for(int i = 0; i< word.length(); i++) {
            if(word.charAt(i) >= 'a' && word.charAt(i) <= 'z')
                map1.put(word.charAt(i), i);
            else 
                {
                    if(!map2.containsKey(word.charAt(i))) {
                         map2.put(word.charAt(i), i);
                    }
                }

        }
        int count = 0;

        for(Map.Entry<Character, Integer> ent : map1.entrySet()) {

    char key = ent.getKey();
    int val = ent.getValue();

    int tp = map2.getOrDefault((char)(key - 32), 0);

    if(val < tp)
        count++;
}

        return count;
    }
}
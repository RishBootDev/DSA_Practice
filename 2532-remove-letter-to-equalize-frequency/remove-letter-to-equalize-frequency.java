class Solution {
    
    public boolean equalFrequency(String word) {

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            map.put(word.charAt(i), map.getOrDefault(word.charAt(i), 0) + 1);
        }

        Map<Integer, Integer> mp = new HashMap<>();
        for (int c : map.values()) {
            mp.put(c, mp.getOrDefault(c, 0) + 1);
        }
        if (mp.size() == 1) {
            int frequency = map.values().iterator().next();

            if (frequency == 1) return true;
            return map.size() == 1;
        }

        if (mp.size() != 2) return false;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (Map.Entry<Integer, Integer> ent : mp.entrySet()) {
            int key = ent.getKey();
            max = Math.max(max, key);
            min = Math.min(min, key);
        }
        if (min == 1 && mp.get(min) == 1) {
            return true;
        }
        if (max - min == 1 && mp.get(max) == 1) {
            return true;
        }
        return false;
    }
}
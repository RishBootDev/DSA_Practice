class Solution {

    Map<String, Integer> map;

    public int minFlipsMonoIncr(String s) {
        map = new HashMap<>();
        return helper(s, '#', 0);
    }

    public int helper(String s, char prev, int i) {

        if (i == s.length()) {
            return 0;
        }

        String key = prev + " "+i;
        if(map.containsKey(key)) return map.get(key);

        int flip = Integer.MAX_VALUE;
        int not = Integer.MAX_VALUE;

        if (prev == '#') {

            not = helper(s, s.charAt(i), i + 1);

            char flipped = s.charAt(i) == '0' ? '1' : '0';
            flip = helper(s, flipped, i + 1) + 1;

        } else if (prev == '0') {
            not = helper(s, s.charAt(i), i + 1);
            char flipped = s.charAt(i) == '0' ? '1' : '0';
            flip = helper(s, flipped, i + 1) + 1;

        } else {
            if (s.charAt(i) == '1') {
                not = helper(s, '1', i + 1);
            } else {
                flip = helper(s, '1', i + 1) + 1;
            }
        }
        int ans = Math.min(flip, not);
        map.put(key, ans);

        return ans;
            }
}
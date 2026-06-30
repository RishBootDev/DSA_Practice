class Solution {
    public int maximumLengthSubstring(String s) {
        int left = 0;
        int ans = 0;

        Map<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            while (map.get(ch) > 2) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);

                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }

                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}
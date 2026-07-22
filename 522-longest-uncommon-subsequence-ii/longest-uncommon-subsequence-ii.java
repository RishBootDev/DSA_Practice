class Solution {
    public int findLUSlength(String[] strs) {

        Map<String, Integer> map = new HashMap<>();
        for(String str : strs) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        int max = Integer.MIN_VALUE;
        for(Map.Entry<String, Integer> ent : map.entrySet()) {
            if(ent.getValue() == 1 && !check(strs, ent.getKey())) {
                max = Math.max(max, ent.getKey().length());
            }
        }
        return max == Integer.MIN_VALUE ? -1 : max;
    }
    public boolean check(String[] arr, String target) {

        for (String s : arr) {
            if(s.equals(target)) continue;
            if (isSubsequence(target, s)) {
                return true;
            }
        }

        return false;
    }

    public boolean isSubsequence(String target, String s) {

        int i = 0, j = 0;

        while (i < target.length() && j < s.length()) {
            if (target.charAt(i) == s.charAt(j)) {
                i++;
            }
            j++;
        }

        return i == target.length();
    }
}
class Solution {

    public String shortestBeautifulSubstring(String s, int k) {

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1')
                list.add(i);
        }

        if (k > list.size())
            return "";

        int min = Integer.MAX_VALUE;

        for (int i = 0; i + k - 1 < list.size(); i++) {
            int count = list.get(i + k - 1) - list.get(i);

            if (count < min) {
                min = count;
            }
        }

        List<String> ans = new ArrayList<>();

        for (int i = 0; i + k - 1 < list.size(); i++) {
            int count = list.get(i + k - 1) - list.get(i);

            if (count == min) {
                int start = list.get(i);
                int end = list.get(i + k - 1);

                ans.add(s.substring(start, end + 1));
            }
        }

        Collections.sort(ans);

        return ans.get(0);
    }
}
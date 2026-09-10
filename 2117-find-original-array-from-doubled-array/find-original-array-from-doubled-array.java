class Solution {
    public int[] findOriginalArray(int[] changed) {
        if (changed.length % 2 != 0) return new int[0];

        Arrays.sort(changed);

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : changed) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int[] ans = new int[changed.length / 2];
        int idx = 0;

        for (int num : changed) {
            if (map.get(num) == 0) continue;
            int doubled = num * 2;
            if (num == 0 && map.get(num) < 2) {
                return new int[0];
            }
            if (map.getOrDefault(doubled, 0) == 0) {
                return new int[0];
            }
            ans[idx++] = num;

            map.put(num, map.get(num) - 1);
            map.put(doubled, map.get(doubled) - 1);
        }

        return ans;
    }
}
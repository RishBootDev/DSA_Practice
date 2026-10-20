class Solution {
    public Set<String> set;

    public int numTilePossibilities(String tiles) {
        set = new HashSet<>();
        helper(tiles, 0, new StringBuilder(), new boolean[tiles.length()]);
        return set.size();
    }

    public void helper(String tiles, int i, StringBuilder curr, boolean[] vis) {

        if (!curr.isEmpty()) {
            set.add(curr.toString());
        }

        for (int j = 0; j < tiles.length(); j++) {
            if (vis[j])
                continue;
            // take
            curr.append(tiles.charAt(j));
            vis[j] = true;
            helper(tiles, j, curr, vis);
            // backtrack
            curr.deleteCharAt(curr.length() - 1);
            vis[j] = false;
        }
    }
}
class Solution {

 public int numberOfPairs(int[][] points) {

            List<Pair> pairs = new ArrayList<>();

            for (int[] p : points) {
                pairs.add(new Pair(p[0], p[1]));
            }
            
            pairs.sort((a, b) -> {
                if (a.x != b.x) return a.x - b.x;
                return b.y - a.y;
            });

            int n = pairs.size();
            int ans = 0;

            for (int i = 0; i < n; i++) {

                Pair a = pairs.get(i);
                for (int j = i + 1; j < n; j++) {

                    Pair b = pairs.get(j);
                    if (a.y < b.y) continue;

                    boolean valid = true;
                    for (int k = i + 1; k < j; k++) {
                        Pair c = pairs.get(k);
                        if (c.x >= a.x && c.x <= b.x &&
                                c.y <= a.y && c.y >= b.y) {

                            valid = false;
                            break;
                        }
                    }

                    if (valid) ans++;
                }
            }

            return ans;
        }

        static class Pair {
            int x;
            int y;

            Pair(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }   
}
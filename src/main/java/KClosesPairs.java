import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

class Solution {
    public int findPairs(int[] nums, int k) {

        HashSet<Integer> set = new HashSet<>();
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int x : nums) {
            set.add(x);
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        HashSet<Pair> pairs = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {

            int a = nums[i];
            int b = a + k;

            if (!set.contains(b)) continue;
            if (k == 0 && freq.get(a) < 2) continue;

            pairs.add(new Pair(a, b));
        }
        return pairs.size();
    }

    static class Pair {
        int a;
        int b;
        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Pair ob = (Pair) obj;
            return a == ob.a && b == ob.b;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }
    }
}

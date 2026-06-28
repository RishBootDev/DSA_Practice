class Solution {

    public List<List<Integer>> filterOccupiedIntervals(int[][] occ, int freeStart, int freeEnd) {

        Arrays.sort(occ, (a, b) -> a[0] - b[0]);

        List<List<Integer>> ans = new ArrayList<>();
        List<Pair> pairs = new ArrayList<>();

        for (int[] oc : occ) {
            pairs.add(new Pair(oc[0], oc[1]));
        }

        List<Pair> merge = merge(pairs);

        for (Pair pair : merge) {
            int start = pair.start;
            int end = pair.end;

            if (end < freeStart || start > freeEnd) {
                List<Integer> temp = new ArrayList<>();
                temp.add(start);
                temp.add(end);
                ans.add(temp);
            }

            else {
                if (start < freeStart) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(start);
                    temp.add(freeStart - 1);
                    ans.add(temp);
                }

                if (end > freeEnd) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(freeEnd + 1);
                    temp.add(end);
                    ans.add(temp);
                }
            }
        }

        return ans;
    }

    public List<Pair> merge(List<Pair> pairs) {

    List<Pair> ans = new ArrayList<>();
    if (pairs.isEmpty()) return ans;

    pairs.sort((a, b) -> a.start - b.start);

    Pair p2 = pairs.get(0);

    for (int i = 1; i < pairs.size(); i++) {
        Pair p1 = pairs.get(i);

        if (p1.start <= p2.end + 1) {
            p2.end = Math.max(p2.end, p1.end);
        } else {
            ans.add(p2);
            p2 = p1;
        }
    }

    ans.add(p2);
    return ans;
}

    static class Pair {
        int start;
        int end;

        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
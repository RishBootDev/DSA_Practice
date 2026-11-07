class Solution {

    private List<Integer> list;

    public int[] numsSameConsecDiff(int n, int k) {
        this.list = new ArrayList<>();
        if (k == 0) {
            for (int i = 1; i < 10; i++) {
                int temp = n;
                StringBuilder sb = new StringBuilder();
                while (temp-- > 0) {
                    sb.append(i);
                }
                list.add(Integer.parseInt(sb.toString()));
            }
            int ans[] = new int[list.size()];
            for (int i = 0; i < ans.length; i++) {
                ans[i] = list.get(i);
            }
            return ans;
        }

        for (int i = 1; i < 10; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            helper(n, k, sb, i);
        }
        int ans[] = new int[list.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    public void helper(int n, int k, StringBuilder sb, int t) {

        if (sb.length() == n) {
            list.add(Integer.parseInt(sb.toString()));
            return;
        }
        int temp = t + k;
        if (temp < 10) {
            sb.append(temp);
            helper(n, k, sb, temp);
            sb.deleteCharAt(sb.length() - 1);
        }
        int bemp = t - k;
        if (bemp >= 0) {
            sb.append(bemp);
            helper(n, k, sb, bemp);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
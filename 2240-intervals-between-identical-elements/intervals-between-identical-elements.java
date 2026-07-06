class Solution {
    
    public long[] getDistances(int[] arr) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }
        long[] ans = new long[arr.length];

        for (List<Integer> list : map.values()) {

            long[] pre = new long[list.size()];
            pre[0] = list.get(0);

            for (int i = 1; i < list.size(); i++) {
                pre[i] = pre[i - 1] + list.get(i);
            }

            for (int i = 0; i < list.size(); i++) {
                long idx = list.get(i);

                long leftSum = (i == 0) ? 0 : pre[i - 1];
                long rightSum = pre[list.size() - 1] - pre[i];

                long left = idx * i - leftSum;
                long right = rightSum - idx * (list.size() - i - 1);

                ans[(int) idx] = left + right;
            }
        }
        return ans;

    }
}
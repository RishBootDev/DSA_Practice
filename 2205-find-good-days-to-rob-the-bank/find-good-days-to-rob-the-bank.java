class Solution {

    public List<Integer> goodDaysToRobBank(int[] arr, int time) {

        int n = arr.length;
        List<Integer> ans = new ArrayList<>();
        int[] left = new int[n];
        int[] right = new int[n];

        for (int i = 1; i < n; i++) {

            if (arr[i] <= arr[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
        }

        for (int i = n - 2; i >= 0; i--) {

            if (arr[i] <= arr[i + 1]) {
                right[i] = right[i + 1] + 1;
            }
        }
        for (int i = 0; i < n; i++) {

            if (left[i] >= time &&
                right[i] >= time) {

                ans.add(i);
            }
        }
        return ans;
    }
}
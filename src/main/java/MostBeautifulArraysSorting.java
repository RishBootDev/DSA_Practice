import java.util.Arrays;

public class MostBeautifulArraysSorting {

    public int[] maximumBeauty(int[][] items, int[] queries) {

        Arrays.sort(items, (a, b) -> a[0] - b[0]);

        int maxBeauty = 0;
        for (int i = 0; i < items.length; i++) {
            maxBeauty = Math.max(maxBeauty, items[i][1]);
            items[i][1] = maxBeauty;
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int q = queries[i];
            int start = 0;
            int end = items.length - 1;

            int idx = -1;

            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (items[mid][0] <= q) {
                    idx = mid;
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

            if (idx != -1) {
                ans[i] = items[idx][1];
            }
        }
        return ans;
    }
}
public class SubarrayProductLessThanK {

    public long countSubArrayProductLessThanK(long a[], int n, long k) {

        long p = 1;
        long res = 0;
        for (int start = 0, end = 0; end < n; end++) {

            p *= a[end];

            while (start < end && p >= k)
                p /= a[start++];

            if (p < k) {
                int len = end - start + 1;
                res += len;
            }
        }

        return res;
    }

}

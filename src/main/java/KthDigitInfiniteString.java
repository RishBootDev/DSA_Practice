public class KthDigitInfiniteString {

    public int kthDigit(long k) {

        if(k < 10) return (int)k;
        long rem = k % 10;

        long start = k - rem;
        long end = start + 10;

        long div = k / 10;

        if(div % 2 == 0) {
            return 0;
        }else {

        }

        return 0;
    }
    // this question is incomplete
}

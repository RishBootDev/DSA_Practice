public class CoinGreedy {

    public int findMin(int n) {

        int count = 0;

        count += n / 10;
        n = n % 10;

        count += n / 5;
        n = n % 5;

        count += n / 2;
        n = n % 2;

        count += n;

        return count;
    }
}

public class CountNumberOfWaysToCountHouses {

    public int countHousePlacements(int n) {
      return helper(1, 1, n);
    }

    public int helper(int i, int j, int n) {

        if (i > n && j > n) {
            return 1;
        }

        int count = 0;
        // both take
        count += helper(i + 2, j + 2, n);

        // not take
        count += helper(i + 1, j + 1, n);

        //down take up not take
        count += helper(i + 1, j + 2, n);

        // up take down not take
        count += helper(i + 2, j + 1, n);

        return count;
    }
}

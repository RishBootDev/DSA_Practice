public class CountAllPossibleRoutes {

    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        return helper(locations, start, finish, fuel);
    }
    public int helper(int loc[], int i, int end, int fuel) {

        if(fuel < 0) {
            return 0;
        }
        if(i == end) {
           return 1;
        }

        int count = 0;
        for (int j = 0; j < loc.length; j++) {
            if(i != j && fuel >= Math.abs(loc[i] - loc[j]))
                count += helper(loc, j, end, fuel - Math.abs(loc[i] - loc[j]));
        }
        return count;
    }
}

public class MaximumEnergyDrinksFromTwoDrinks {

    public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
       long first = helper(energyDrinkA, energyDrinkB, 0, 0);
       long second = helper(energyDrinkA, energyDrinkB, 0, 1);
       return Math.max(first, second);
    }

    public long helper(int arr[], int barr[], int i, int state) {
        if(i == arr.length) return 0;

        if(state == 0) {
            // take
            long take = helper(arr, barr, i + 1, 0) + arr[i];
            // change
            long change = helper(arr, barr, i + 2, 1) + arr[i];

            return Math.max(take, change);
        }else {
            // take
            long take = helper(arr, barr, i + 1, 1) + arr[i];
            // change
            long change = helper(arr, barr, i + 2, 0) + arr[i];
            return Math.max(take, change);
        }
    }
}

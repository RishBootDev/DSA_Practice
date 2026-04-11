public class MinimumOperationsToTransformArrayIntoAlternatingPrime {
    public int minOperations(int[] nums) {

        int count = 0;

        for(int i = 0; i < nums.length; i ++) {
            if(i %2 == 0) {
                count += stepPrime(nums[i]);
            }else {
                count += stepNonPrime(nums[i]);
            }
        }
        return count;
    }
    public int stepPrime(int x) {
        int steps = 0;

        while(!isPrime(x)) {
            x++;
            steps ++;
        }
        return steps;
    }

    public int stepNonPrime(int x) {
        int steps = 0;
        while(isPrime(x)) {
            x++;
            steps ++;
        }

        return steps;
    }

    public boolean isPrime(int n ) {
        if(n <= 1) return false;

        if(n == 2) return true;
        if(n%2== 0) return false;

        for(int i = 3; i *i <= n; i++) {
            if(n % i == 0) return false;
        }

        return true;
    }
}

public class FindStudentThatReplaceChalk {

    // this is the bruteforce approach and test cases 73 / 74 are working fine
    public int chalkReplacer(int[] chalk, int k) {

        int j = 0;
        int n = chalk.length;

        while (k >= chalk[j % n]) {
            k -= chalk[j % n];
            j++;
        }

        return j % n;
    }

    // optimized and approved solution
    public int chalkReplacer2(int[] chalk, int k) {

        int j = 0;
        int n = chalk.length;

        long sum = 0;
        for (int c : chalk) sum += c;

        k %= sum;
        while (k >= chalk[j % n]) {
            k -= chalk[j % n];
            j++;
        }

        return j % n;
    }
}

public class ThreeConsecutiveIntegersThatSumToAGivenNumber {

    public long[] sumOfThree(long num) {

        long temp = num/2;

        if(num % 3 != 0) return new long[0];

        long x = num/3;
        long first = x-1;
        long third = x+1;


        return new long[]{first, x, third};

    }
}

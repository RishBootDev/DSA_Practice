class Solution {
    public int maxDigitRange(int[] nums) {
        int maxRange = -1;
        int sum = 0;

        for (int num : nums) {
            int range = getDigitRange(num);
            if (range > maxRange) {
                maxRange = range;
            }
        }

        for (int num : nums) {
            if (getDigitRange(num) == maxRange) {
                sum += num;
            }
        }

        return sum;
    }

    private int getDigitRange(int num){
        int minDigit = 9;
        int maxDigit = 0;

        while(num > 0){
            int digit = num % 10;
            if(digit < minDigit) minDigit = digit;
            if(digit > maxDigit) maxDigit = digit;
            num /= 10;
        }

        return maxDigit - minDigit;
    }
}
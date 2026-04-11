public class CountDigitAppearance {

        public int countDigitOccurrences(int[] nums, int digit) {

            int count = 0;

            for(int c : nums) {

                String str = String.valueOf(c);
                char ch = String.valueOf(digit).charAt(0);

                for(int i = 0; i< str.length() ; i ++) {
                    if(str.charAt(i) == ch) count++;
                }
            }

            return count;
        }

}

public class StrictlyPalindromicNumber {

    public static void main(String[] args) {


        int num = 5;
        String bin = Integer.toBinaryString(num);

        int temp = Integer.parseInt(bin, 6);

        System.out.println(temp);
    }

    public boolean isStrictlyPalindromic(int n) {

        for (int base = 2; base <= n - 2; base++) {
            String repr = Integer.toString(n, base);
            if (!isPalindrome(repr)) {
                return false;
            }
        }
        return true;
    }

    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


}

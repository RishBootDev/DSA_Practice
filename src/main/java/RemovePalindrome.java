public class RemovePalindrome {

    public static int palindromeIndex(String s) {
        // Write your code here
        for (int i = 0; i < s.length(); i++) {

            StringBuilder sb=new StringBuilder();
            for (int j = 0; j < s.length(); j++) {
                if(i==j) continue;
                sb.append(s.charAt(j));
            }

            if (checkPalindrome(sb.toString())) return i;
        }

        return -1;
    }
    public static boolean checkPalindrome(String str){
        StringBuilder sb=new StringBuilder(str);
        return str.contentEquals(sb.reverse());
    }

    public static int palindromeIndexOptimized(String s) {

        int left = 0, right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                if (isPalindrome(s, left + 1, right)) return left;
                if (isPalindrome(s, left, right - 1)) return right;
                return -1;
            }
        }

        return -1;
    }

    private static boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }

}

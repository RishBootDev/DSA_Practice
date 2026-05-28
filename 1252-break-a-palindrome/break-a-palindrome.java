class Solution {

    public String breakPalindrome(String palindrome) {

        int n = palindrome.length();

        if (n == 1) return "";
        char[] arr = palindrome.toCharArray();

        for (int i = 0; i < n; i++) {

            char original = arr[i];
            if (arr[i] == 'a') continue;

            arr[i] = 'a';
            String temp = new String(arr);
            if (!check(temp)) {
                return temp;
            }
            arr[i] = original;
        }

        arr[n - 1] = 'b';

        return new String(arr);
    }

    public boolean check(String pal) {

        int i = 0;
        int j = pal.length() - 1;

        while (i < j) {
            if (pal.charAt(i) != pal.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
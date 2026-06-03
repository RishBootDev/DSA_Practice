class Solution {
    public String shiftingLetters(String s, int[] shifts) {

        long suff[] = new long[shifts.length];
        long sum = 0;
        for (int i = shifts.length - 1; i >= 0; i--) {
            sum += shifts[i];
            suff[i] = sum;
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            long t = s.charAt(i) - 'a';
            t = (t + suff[i]) % 26;
            char ch = (char) (t + 'a');
            sb.append(ch);
        }

        return sb.toString();

    }
}
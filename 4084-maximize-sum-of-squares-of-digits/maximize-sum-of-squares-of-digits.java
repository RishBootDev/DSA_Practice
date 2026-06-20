class Solution {
    public String maxSumOfSquares(int num, int sum) {

        int count = sum / 9;
        int temp = 0;
        if (sum % 9 != 0) temp++;

        StringBuilder sb = new StringBuilder();

        while (count-- > 0) {
            sb.append('9');
        }

        if (temp == 1) sb.append(sum % 9);

        if (sb.length() > num) return "";
        int c = num - sb.length(); 
        while (c-- > 0) {
            sb.append('0');
        }
        return sb.toString();
    }
}
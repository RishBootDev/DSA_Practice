public class HashDividedStrings {

    public String stringHash(String s, int k) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length();) {

            int temp = k;
            int count = 0;
            while(temp --> 0) {
                count += (s.charAt(i) - 97);
                i++;
            }
            sb.append((char)((count % 26) + 97));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println('m' - 97);
    }
}
